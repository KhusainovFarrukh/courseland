package courseland.lesson.dtos;

import courseland.lesson.Type;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class LessonRequestDto {

    @NonNull
    private Type type;

    private String studyMaterials;

    private String relatedResources;
}
