package courseland.lesson;

import courseland.lesson.dtos.LessonRequestDto;
import courseland.lesson.dtos.LessonResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository userRepository;
    private final LessonMapper userMapper;

    @Override
    public LessonResponseDto createLesson(LessonRequestDto userRequestDto) {
        Lesson user = userRepository.save(userMapper.toEntity(userRequestDto));
        return userMapper.toResponse(user);
    }

    @Override
    public LessonResponseDto updateLesson(Long id, LessonRequestDto userRequestDto) {
        Lesson user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        userMapper.partialUpdate(userRequestDto, user);
        return userMapper.toResponse(user);
    }

    @Override
    public List<LessonResponseDto> getAllLessons() {
        return userRepository.findAll().stream().map(userMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public LessonResponseDto getLesson(Long id) {
        Lesson user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        return userMapper.toResponse(user);
    }

    @Override
    public void deleteLesson(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("invalid id"));
        userRepository.deleteById(id);
    }
}
