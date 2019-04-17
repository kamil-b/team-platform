package pl.kassad.teamplatform.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kassad.teamplatform.controller.mapper.UserMapper;
import pl.kassad.teamplatform.controller.model.UserDto;
import pl.kassad.teamplatform.services.UserService;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        return mapper.map(userService.createUser(mapper.map(userDto)));
    }
}
