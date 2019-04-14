package pl.kassad.teamplatform.controller.mapper;


import org.mapstruct.Mapper;
import pl.kassad.teamplatform.controller.model.UserEventDto;
import pl.kassad.teamplatform.repository.model.UserEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEventsMapper {

    String LOCAL_DATE_FORMAT = "yyyy-MM-dd";

    UserEventDto map(UserEvent entity);

    UserEvent map(UserEventDto dto);

    List<UserEventDto> mapToDto(List<UserEvent> entities);

    List<UserEvent> map(List<UserEventDto> dtos);

    default String map(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT));
    }

    default LocalDate map(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT));
    }
}
