package pl.kassad.teamplatform.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEventListDto {
    private String username;
    private List<UserEventDto> events;
}
