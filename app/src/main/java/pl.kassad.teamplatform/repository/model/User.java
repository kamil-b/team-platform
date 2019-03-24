package pl.kassad.teamplatform.repository.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User  implements UserDetails{

    //https://www.devglan.com/spring-security/spring-boot-oauth2-angular
    @Id
    @GeneratedValue
    private String id;

    private String name;

    private String password;

    @ManyToMany(mappedBy = "members", fetch = FetchType.EAGER)
    private List<TeamBoard> boards = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
