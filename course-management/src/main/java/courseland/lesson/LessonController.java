package courseland.lesson;

import courseland.lesson.dtos.LessonRequestDto;
import courseland.lesson.dtos.LessonResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
@Slf4j
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public LessonResponseDto createLesson(@RequestBody LessonRequestDto requestDto) {
        log.info("Request to create lesson");
        return lessonService.createLesson(requestDto);
    }

    @PatchMapping("{id}")
    public LessonResponseDto updateLesson(
            @PathVariable Long id,
            @RequestBody LessonRequestDto requestDto
    ) {
        log.info("Request to update lesson");
        return lessonService.updateLesson(id, requestDto);
    }

    @GetMapping
    public List<LessonResponseDto> getAllLessons() {
        log.info("Request to get all lessons");
        return lessonService.getAllLessons();
    }

    @GetMapping("{id}")
    public LessonResponseDto getLesson(@PathVariable Long id) {
        log.info("Request to get a lesson");
        return lessonService.getLesson(id);
    }

    @DeleteMapping("{id}")
    public void deleteLesson(@PathVariable Long id) {
        log.info("Request to delete a lesson");
        lessonService.deleteLesson(id);
    }
}
