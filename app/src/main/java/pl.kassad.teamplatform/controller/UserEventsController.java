package pl.kassad.teamplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kassad.teamplatform.controller.mapper.UserEventsMapper;
import pl.kassad.teamplatform.controller.model.UserEventDto;
import pl.kassad.teamplatform.services.UserEventsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/events")
public class UserEventsController {

    private final UserEventsService userEventsService;

    public UserEventsController(@Autowired UserEventsService userEventsService) {
        this.userEventsService = userEventsService;
    }

    @GetMapping
    @RequestMapping(path = "/{userId}")
    public List<UserEventDto> getAllEventsForUser(@PathVariable(name = "userId") String userId) {
        return userEventsService.getAllUserEventsForUser(userId).stream()
                .map(UserEventsMapper::UserEventToUserEventDto)
                .collect(Collectors.toList());
    }
}
