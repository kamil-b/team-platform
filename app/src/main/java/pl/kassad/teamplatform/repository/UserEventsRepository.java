package pl.kassad.teamplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kassad.teamplatform.repository.model.UserEvent;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserEventsRepository extends JpaRepository<UserEvent, String> {

    List<UserEvent> findByUserId(String userId);

    List<UserEvent> findByIdAndDateBetween(String userId, LocalDate start, LocalDate end);
}
