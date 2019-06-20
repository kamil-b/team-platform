package pl.kassad.teamplatform.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class TeamBoardDto {

    @NotBlank
    private String name;
    @NotBlank
    private String ownerName;
    private List<CreateUserDto> members;

}
