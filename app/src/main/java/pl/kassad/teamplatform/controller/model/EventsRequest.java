package pl.kassad.teamplatform.controller.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EventsRequest {

    private String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
