package courseland.lesson;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "lessons")
@Getter
@Setter
public class Lesson {

    private static final String GENERATOR_NAME = "GEN_LESSON";
    private static final String SEQUENCE_NAME = "SEQ_LESSON_ID";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
    @SequenceGenerator(name = GENERATOR_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    // TODO: 24/01/23 should be connected with file-management service
    @Column(name = "study_materials")
    private String studyMaterials;

    // TODO: 24/01/23 should be connected with file-management service
    @Column(name = "related_resources")
    private String relatedResources;
}
