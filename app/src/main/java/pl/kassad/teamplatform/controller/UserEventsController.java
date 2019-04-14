package pl.kassad.teamplatform.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.kassad.teamplatform.controller.mapper.UserEventsMapper;
import pl.kassad.teamplatform.controller.model.UserEventDto;
import pl.kassad.teamplatform.controller.model.UserEventListDto;
import pl.kassad.teamplatform.services.UserEventsService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
@Slf4j
public class UserEventsController {

    private final UserEventsService userEventsService;
    private final UserEventsMapper mapper;

    public UserEventsController(@Autowired UserEventsService userEventsService,
                                @Autowired UserEventsMapper mapper) {
        this.userEventsService = userEventsService;
        this.mapper = mapper;
    }

    @GetMapping
    @RequestMapping(path = "/{username}")
    public List<UserEventDto> getAllEventsForUser(@PathVariable(name = "username") String username) {
        return userEventsService.getAllUserEventsForUser(username)
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }

    @GetMapping
    @RequestMapping(path = "/batch/{username}")
    public List<UserEventDto> getAllEventsForTimeRange(@PathVariable(name = "username") String username,
                                                       @RequestParam(name = "startDate")
                                                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                                       @RequestParam(name = "endDate")
                                                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return mapper.mapToDto(userEventsService.getUserEventsForNextDays(username, startDate, endDate));
    }

    @PostMapping
    public void createNewEvents(@RequestBody UserEventListDto events) {
        log.info("creating new events: {} for user: {}", events.getEvents(), events.getUsername());
        userEventsService.createNewEvents(events.getUsername(), mapper.map(events.getEvents()));
    }
}
