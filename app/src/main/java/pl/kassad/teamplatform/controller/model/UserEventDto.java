package pl.kassad.teamplatform.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEventDto {

    private String userId;

    private String type;

    private String date;

    private String description;
}
