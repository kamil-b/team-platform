package pl.kassad.teamplatform.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pl.kassad.teamplatform.repository.model.UserEventType;

import java.time.LocalDate;

@Data
public class UserEventDto {

    private String id;

    @JsonProperty("userId")
    private String userId;

    private UserEventType type;

    private LocalDate date;

    private String description;
}
