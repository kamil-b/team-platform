package pl.kassad.teamplatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.kassad.teamplatform.repository.UserRepository;
import pl.kassad.teamplatform.repository.model.User;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByName(name).orElseThrow(() -> new UsernameNotFoundException("No user with passed name"));
    }

    public User createUser(User user) {
        if(userRepository.existsByName(user.getName())){
            throw  new IllegalArgumentException("Username already exist in database");
        }

        return userRepository.save(user);
    }
}
