package pl.kassad.teamplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kassad.teamplatform.repository.model.TeamBoard;

import java.util.Optional;

public interface TeamBoardRepository extends JpaRepository<TeamBoard, Long> {

    boolean existsByName(String name);

    Optional<TeamBoard> findByName(String name);
}
