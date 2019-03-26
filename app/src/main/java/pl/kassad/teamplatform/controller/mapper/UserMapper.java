package pl.kassad.teamplatform.controller.mapper;

import pl.kassad.teamplatform.controller.model.UserDto;
import pl.kassad.teamplatform.repository.model.Role;
import pl.kassad.teamplatform.repository.model.User;

import java.util.ArrayList;


public class UserMapper {

    public static User map(UserDto dto) {
        if (dto == null) {
            return null;
        }
        return new User(null, dto.getName(), dto.getPassword(), new ArrayList<>(), Role.USER);
    }

    public static UserDto map(User entity) {
        if (entity == null) {
            return null;
        }
        return new UserDto(entity.getName(), null);
    }
}
