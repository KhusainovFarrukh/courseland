package courseland.course.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponseDto {

    private Long id;
    private String subject;
    private Double price;
    private String files;
}
