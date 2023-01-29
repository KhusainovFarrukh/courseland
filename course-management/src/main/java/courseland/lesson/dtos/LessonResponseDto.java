package courseland.lesson.dtos;

import courseland.lesson.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LessonResponseDto {

    private Long id;
    private Type type;
    private String studyMaterials;
    private String relatedResources;
}
