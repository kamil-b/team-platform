package pl.kassad.teamplatform.controller.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EventsRequest {

    private String username;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate from;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate to;
}
