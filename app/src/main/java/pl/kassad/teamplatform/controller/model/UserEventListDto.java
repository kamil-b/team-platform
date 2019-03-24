package pl.kassad.teamplatform.controller.model;

import lombok.Data;

import java.util.List;

@Data
public class UserEventListDto {
    private String userId;
    private List<UserEventDto> events;
}
