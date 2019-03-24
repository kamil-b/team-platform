package pl.kassad.teamplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kassad.teamplatform.repository.UserEventsRepository;
import pl.kassad.teamplatform.repository.model.UserEvent;

import java.util.List;

@Service
public class UserEventsService {

    private final UserEventsRepository userEventsRepository;

    public UserEventsService(@Autowired UserEventsRepository userEventsRepository) {
        this.userEventsRepository = userEventsRepository;
    }

    public List<UserEvent> getAllUserEventsForUser(String userId) {
        return userEventsRepository.findByUserId(userId);
    }
}
