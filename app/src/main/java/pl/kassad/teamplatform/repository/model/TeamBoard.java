package pl.kassad.teamplatform.repository.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamBoard {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private User owner;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    private List<User> members = new ArrayList<>();

}
