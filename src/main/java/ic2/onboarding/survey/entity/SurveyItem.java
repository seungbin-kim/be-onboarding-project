package ic2.onboarding.survey.entity;

import ic2.onboarding.survey.global.ItemInputType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SurveyItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "SURVEY_ID",
            nullable = false,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    private Survey survey;

    @Column(nullable = false)
    private String name;

    @Column(length = 500, nullable = false)
    private String description;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private ItemInputType inputType;

    @Column(nullable = false)
    private Boolean required;

    @Column(length = 500)
    private String choices;


    public List<String> getChoiceList() {

        if (choices == null || !inputType.isChoiceType()) {
            return List.of();
        }
        return Arrays.stream(choices.split("\\|")).toList();
    }


    public void update(SurveyItem surveyItem) {

        this.name = surveyItem.getName();
        this.description = surveyItem.getDescription();
        this.inputType = surveyItem.getInputType();
        this.required = surveyItem.getRequired();
        this.choices = surveyItem.getChoices();
    }
}
