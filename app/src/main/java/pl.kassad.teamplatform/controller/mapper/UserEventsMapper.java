package pl.kassad.teamplatform.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.kassad.teamplatform.controller.model.UserEventDto;
import pl.kassad.teamplatform.repository.model.UserEvent;

@Mapper(componentModel = "spring")
public interface UserEventsMapper {

    @Mappings(@Mapping(target = "userId", source = "entity.user.id"))
    UserEventDto UserEventToUserEventDto(UserEvent entity);

    //List<UserEvent> mapUserEventsDtoToModel(List<UserEventDto> events);
}
