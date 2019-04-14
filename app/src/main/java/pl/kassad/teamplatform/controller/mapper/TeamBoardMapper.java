package pl.kassad.teamplatform.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kassad.teamplatform.controller.model.TeamBoardDto;
import pl.kassad.teamplatform.repository.model.TeamBoard;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface TeamBoardMapper {

    TeamBoardDto map(TeamBoard board);

    @Mapping(target = "owner.name", source = "ownerName")
    TeamBoard map(TeamBoardDto boardDto);

    List<TeamBoardDto> map(List<TeamBoard> board);
}
