package pl.kassad.teamplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kassad.teamplatform.repository.model.TeamBoard;

public interface TeamBoardRepository extends JpaRepository<TeamBoard, Long> {
}
