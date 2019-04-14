package pl.kassad.teamplatform.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kassad.teamplatform.controller.mapper.UserEventsMapper;
import pl.kassad.teamplatform.repository.UserEventsRepository;
import pl.kassad.teamplatform.repository.UserRepository;
import pl.kassad.teamplatform.repository.model.User;
import pl.kassad.teamplatform.repository.model.UserEvent;
import pl.kassad.teamplatform.repository.model.UserEventType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
@AllArgsConstructor
public class UserEventsService {

    private final UserEventsRepository userEventsRepository;
    private final UserRepository userRepository;


    public List<UserEvent> getAllUserEventsForUser(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("no user with given name"));

        return userEventsRepository.findByUserId(user.getId());
    }

    public void createNewEvents(String username, List<UserEvent> newEvents) {

        User user = userRepository.findByName(username).orElseThrow(
                () -> new IllegalArgumentException("no user with given id"));

        List<UserEvent> events = newEvents
                .stream()
                .filter(e -> !e.getType().equals(UserEventType.NO_EVENT))
                .map(
                        e -> {
                            UserEvent event = userEventsRepository.getByDate(e.getDate()).orElse(e);
                            e.setUserId(user.getId());
                            event.setType(e.getType());
                            return event;

                        }
                )
                .collect(Collectors.toList());

        log.info(events.toString());

        for (UserEvent event : events) {

            userEventsRepository.save(event);
        }
    }

    public List<UserEvent> getUserEventsForNextDays(String username, LocalDate startDate, LocalDate endDate) {
        log.info("startDate: {} , endDate: {}", startDate, endDate);

        User user = userRepository.findByName(username)
                .orElseThrow(() -> new IllegalArgumentException("no user with given username"));

        List<UserEvent> events = userEventsRepository.findByIdAndDateBetween(user.getId(), startDate, endDate);

        return getDatesBetween(startDate, endDate)
                .stream()
                .map(date ->
                        events.stream()
                                .filter(event -> event.getDate().equals(date))
                                .findFirst()
                                .orElse(
                                        UserEvent
                                                .builder()
                                                .id(null)
                                                .userId(user.getId())
                                                .type(UserEventType.NO_EVENT)
                                                .date(date)
                                                .description("")
                                                .build())
                ).collect(Collectors.toList());
    }


    private static List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {

        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return IntStream.iterate(0, i -> i + 1)
                .limit(numOfDaysBetween)
                .mapToObj(startDate::plusDays)
                .collect(Collectors.toList());
    }
}
