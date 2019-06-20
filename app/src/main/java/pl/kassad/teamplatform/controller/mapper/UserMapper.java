package pl.kassad.teamplatform.controller.mapper;

import org.mapstruct.Mapper;
import pl.kassad.teamplatform.controller.model.CreateUserDto;
import pl.kassad.teamplatform.controller.model.UserDto;
import pl.kassad.teamplatform.repository.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User map(CreateUserDto dto);

    CreateUserDto map(User entity);

    UserDto mapToUserDto(User entity);

}
