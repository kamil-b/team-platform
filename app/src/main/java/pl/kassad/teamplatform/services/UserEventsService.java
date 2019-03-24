package pl.kassad.teamplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kassad.teamplatform.controller.model.UserEventListDto;
import pl.kassad.teamplatform.repository.UserEventsRepository;
import pl.kassad.teamplatform.repository.UserRepository;
import pl.kassad.teamplatform.repository.model.UserEvent;
import pl.kassad.teamplatform.repository.model.UserEventType;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserEventsService {

    private final UserEventsRepository userEventsRepository;
    private final UserRepository userRepository;

    public UserEventsService(@Autowired UserEventsRepository userEventsRepository,
                             @Autowired UserRepository userRepository) {
        this.userEventsRepository = userEventsRepository;
        this.userRepository = userRepository;
    }

    public List<UserEvent> getAllUserEventsForUser(String userId) {
        return userEventsRepository.findByUserId(userId);
    }

    public void createNewEvents(UserEventListDto eventsDto) {

        if (userRepository.existsById(eventsDto.getUserId())) {
            throw new IllegalArgumentException("no user with given id");
        }

        List<UserEvent> events = eventsDto.getEvents().stream().map(
                event -> UserEvent
                        .builder()
                        .id(null)
                        .userId(eventsDto.getUserId())
                        .date(event.getDate())
                        .description(event.getDescription())
                        .type(UserEventType.valueOf(event.getType()))
                        .build()
        ).collect(Collectors.toList());

        userEventsRepository.saveAll(events);
    }
}
