package ic2.onboarding.survey.api;

import ic2.onboarding.survey.dto.SurveyUpdateRequest;
import ic2.onboarding.survey.dto.SurveyUpdateResponse;
import ic2.onboarding.survey.global.ApiResult;
import ic2.onboarding.survey.dto.SurveyCreationRequest;
import ic2.onboarding.survey.dto.SurveyCreationResponse;
import ic2.onboarding.survey.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/surveys")
public class SurveyController implements SurveyControllerDoc {

    private final SurveyService surveyService;


    @Override
    @PostMapping
    public ResponseEntity<ApiResult<SurveyCreationResponse>> createSurvey(@RequestBody SurveyCreationRequest request) {

        SurveyCreationResponse response = surveyService.createSurvey(request);
        return ResponseEntity.ok(new ApiResult<>(response));
    }


    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ApiResult<SurveyUpdateResponse>> updateSurvey(@PathVariable(name = "id") Long id,
                                                                        @RequestBody SurveyUpdateRequest request) {

        SurveyUpdateResponse response = surveyService.updateSurvey(id, request);
        return ResponseEntity.ok(new ApiResult<>(response));
    }

}
