package pl.kassad.teamplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kassad.teamplatform.controller.mapper.UserMapper;
import pl.kassad.teamplatform.controller.model.UserDto;
import pl.kassad.teamplatform.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto){
        return UserMapper.map(userService.createUser(UserMapper.map(userDto)));
    }
}
