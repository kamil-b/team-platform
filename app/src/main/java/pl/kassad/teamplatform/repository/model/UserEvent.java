package pl.kassad.teamplatform.repository.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent {

    @Id
    @GeneratedValue
    private String id;

    private String userId;

    @Enumerated(EnumType.STRING)
    private UserEventType type;

    private LocalDate date;

    private String description;

}
