package ic2.onboarding.survey.dto;

import ic2.onboarding.survey.entity.SurveyItem;
import ic2.onboarding.survey.global.BizConstants;
import ic2.onboarding.survey.global.ItemInputType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record SurveyFormItem(Long id,

                             @Size(message = "{name.length}",
                                     min = BizConstants.MIN_NAME_LENGTH,
                                     max = BizConstants.MAX_NAME_LENGTH)
                             String name,

                             @Size(message = "{description.length}",
                                     min = BizConstants.MIN_DESCRIPTION_LENGTH,
                                     max = BizConstants.MAX_DESCRIPTION_LENGTH)
                             String description,

                             @NotBlank(message = "{inputType.notBlank}")
                             String inputType,

                             @NotNull(message = "{required.notNull}")
                             Boolean required,

                             @Size(message = "{choices.size}",
                                     min = BizConstants.MIN_CHOICES_SIZE,
                                     max = BizConstants.MAX_CHOICES_SIZE)
                             List<String> choices)
{

    public static SurveyFormItem fromEntity(SurveyItem item) {

        return new SurveyFormItem(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getInputType().name(),
                item.getRequired(),
                item.getChoiceList());
    }


    public String choicesAsString() {

        if (choices == null || !inputTypeAsEnum().isChoiceType()) {
            return null;
        }

        return String.join("|", choices);
    }


    public ItemInputType inputTypeAsEnum() {

        return ItemInputType.fromString(inputType);
    }

}
