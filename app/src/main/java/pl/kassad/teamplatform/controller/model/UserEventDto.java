package pl.kassad.teamplatform.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEventDto {

    private String userId;

    private String type;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private String description;
}
