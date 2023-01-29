package courseland.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    private static final String GENERATOR_NAME = "GEN_COURSE";
    private static final String SEQUENCE_NAME = "SEQ_COURSE_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
    @SequenceGenerator(name = GENERATOR_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    // TODO: 24/01/23 subject should be a separate table
    @Column(name = "subject")
    private String subject;

    // TODO: 24/01/23 relationship between Teacher and Course
    //@ManyToMany
    //private List<AppUser> teachers;

    // TODO: 24/01/23 relationship between Pupil and Course
    //only IDs
    //@ManyToMany
    //private List<AppUser> pupils;

    @Column(name = "price")
    private Double price;

    // TODO: 24/01/23 should be connected with file-management service
    private String files;


}
