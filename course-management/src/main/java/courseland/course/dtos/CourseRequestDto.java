package courseland.course.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequestDto {

    private String subject;
    private Double price;
    private String files;
}
