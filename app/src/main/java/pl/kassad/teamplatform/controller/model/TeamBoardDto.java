package pl.kassad.teamplatform.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamBoardDto {

    private String name;
    private String ownerName;
    private List<CreateUserDto> members;

}
