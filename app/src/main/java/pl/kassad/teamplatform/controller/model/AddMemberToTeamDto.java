package pl.kassad.teamplatform.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberToTeamDto {

    @NotBlank
    String board;

    @NotBlank
    String username;
}
