package pl.kassad.teamplatform.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kassad.teamplatform.controller.mapper.UserMapper;
import pl.kassad.teamplatform.controller.model.CreateUserDto;
import pl.kassad.teamplatform.controller.model.UserDto;
import pl.kassad.teamplatform.services.UserService;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    @PostMapping
    public UserDto createUser(@RequestBody CreateUserDto createUserDto) {
        return mapper.mapToUserDto(userService.createUser(mapper.map(createUserDto)));
    }
}
