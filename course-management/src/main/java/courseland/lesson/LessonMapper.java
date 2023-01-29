package courseland.lesson;

import courseland.lesson.dtos.LessonRequestDto;
import courseland.lesson.dtos.LessonResponseDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mapping(target = "id", ignore = true)
    Lesson toEntity(LessonRequestDto request);

    LessonResponseDto toResponse(Lesson user);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(LessonRequestDto request, @MappingTarget Lesson user);
}
