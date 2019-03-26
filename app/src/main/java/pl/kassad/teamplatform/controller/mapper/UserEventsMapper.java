package pl.kassad.teamplatform.controller.mapper;


import pl.kassad.teamplatform.controller.model.UserEventDto;
import pl.kassad.teamplatform.repository.model.UserEvent;


public class UserEventsMapper {

    public static UserEventDto UserEventToUserEventDto(UserEvent entity) {
        if (entity == null) {
            return null;
        }

        return UserEventDto.builder()
                .userId(entity.getId())
                .type(entity.getType().toString())
                .description(entity.getDescription())
                .date(entity.getDate())
                .build();
    }


}
