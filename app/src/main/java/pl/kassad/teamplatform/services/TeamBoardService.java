package pl.kassad.teamplatform.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kassad.teamplatform.repository.TeamBoardRepository;
import pl.kassad.teamplatform.repository.UserRepository;
import pl.kassad.teamplatform.repository.model.TeamBoard;
import pl.kassad.teamplatform.repository.model.User;
import pl.kassad.teamplatform.services.exeption.UserNotFoundException;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class TeamBoardService {

    private final TeamBoardRepository teamBoardRepository;
    private final UserRepository userRepository;

    public TeamBoard create(TeamBoard teamBoard){

        log.info("Creating board: " + teamBoard);

       User user = userRepository.findByName(teamBoard.getOwner().getName())
                .orElseThrow( () -> new UserNotFoundException("user not found: "+ teamBoard.getOwner().getName()));

        teamBoard.setOwner(user);

        return teamBoardRepository.save(teamBoard);
    }

    public List<TeamBoard> findAll(){
        return teamBoardRepository.findAll();
    }
}
