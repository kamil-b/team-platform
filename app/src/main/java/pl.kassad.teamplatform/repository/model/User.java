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
public class User {

    @Id
    @GeneratedValue
    private String id;

    private String name;

    @ManyToMany(mappedBy = "members")
    private List<TeamBoard> boards = new ArrayList<>();
}
