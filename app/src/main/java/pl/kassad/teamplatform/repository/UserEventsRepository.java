package pl.kassad.teamplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kassad.teamplatform.repository.model.UserEvent;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserEventsRepository extends JpaRepository<UserEvent, String> {

    List<UserEvent> findByUserId(Long userId);

    Optional<UserEvent> getByDate(LocalDate date);

    @Query("SELECT e FROM UserEvent e WHERE e.userId=:userId AND e.date BETWEEN :startDate AND :endDate")
    List<UserEvent> findByIdAndDateBetween(@Param("userId") Long userId,
                                           @Param("startDate") LocalDate startDate,
                                           @Param("endDate") LocalDate endDate);
}
