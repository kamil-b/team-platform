package pl.kassad.teamplatform.controller.mapper;

import org.mapstruct.Mapper;
import pl.kassad.teamplatform.controller.model.UserDto;
import pl.kassad.teamplatform.repository.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(UserDto dto);

    UserDto map(User entity);

}
