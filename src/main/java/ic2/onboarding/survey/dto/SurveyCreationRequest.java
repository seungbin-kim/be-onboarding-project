package ic2.onboarding.survey.dto;

import ic2.onboarding.survey.global.BizConstants;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.List;

public record SurveyCreationRequest(@Valid SurveyForm basic,

                                    @Valid
                                    @Size(message = "{items.size}",
                                            min = BizConstants.MIN_ITEMS_SIZE,
                                            max = BizConstants.MAX_ITEMS_SIZE)
                                    List<SurveyFormItem> items)
{

}
