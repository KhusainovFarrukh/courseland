package courseland.lesson;

import courseland.lesson.dtos.LessonRequestDto;
import courseland.lesson.dtos.LessonResponseDto;

import java.util.List;

public interface LessonService {

    LessonResponseDto createLesson(LessonRequestDto userRequestDto);

    LessonResponseDto updateLesson(Long id, LessonRequestDto userRequestDto);

    List<LessonResponseDto> getAllLessons();

    LessonResponseDto getLesson(Long id);

    void deleteLesson(Long id);
}
