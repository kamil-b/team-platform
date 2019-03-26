package pl.kassad.teamplatform.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEventListDto {
    private String userId;
    private List<UserEventDto> events;
}
