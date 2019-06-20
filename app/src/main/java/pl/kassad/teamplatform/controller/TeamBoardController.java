package pl.kassad.teamplatform.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.kassad.teamplatform.controller.mapper.TeamBoardMapper;
import pl.kassad.teamplatform.controller.model.AddMemberToTeamDto;
import pl.kassad.teamplatform.controller.model.TeamBoardDto;
import pl.kassad.teamplatform.services.TeamBoardService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/boards")
@AllArgsConstructor
public class TeamBoardController {

    private final TeamBoardService teamBoardService;

    private final TeamBoardMapper mapper;

    @PostMapping
    public TeamBoardDto create(@RequestBody @Valid TeamBoardDto teamBoardDto) {
        log.info("Creating board: " + teamBoardDto);
        return mapper.map(teamBoardService.create(mapper.map(teamBoardDto)));
    }

    @GetMapping
    public List<TeamBoardDto> getAll() {
        return mapper.map(teamBoardService.findAll());
    }

    @PutMapping
    @RequestMapping("/addMember")
    public void addMemberToTeam(@RequestBody @Valid AddMemberToTeamDto addMemberToTeamDto){
        log.info("Adding member {} to team: {}", addMemberToTeamDto.getUsername(), addMemberToTeamDto.getBoard());
        teamBoardService.addMemberToTeamBoard(addMemberToTeamDto.getUsername(), addMemberToTeamDto.getBoard());
    }
}
