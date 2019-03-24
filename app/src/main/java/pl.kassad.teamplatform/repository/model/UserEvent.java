package pl.kassad.teamplatform.repository.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {

    @Id
    @GeneratedValue
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Enumerated(EnumType.STRING)
    private UserEventType type;

    private LocalDate date;

    private String description;

}
