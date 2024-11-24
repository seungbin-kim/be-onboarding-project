package ic2.onboarding.survey.api;

import ic2.onboarding.survey.global.ApiResult;
import ic2.onboarding.survey.dto.SurveyCreationRequest;
import ic2.onboarding.survey.dto.SurveyCreationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "설문조사 API")
public interface SurveyControllerDoc {

    @Operation(
            summary = "설문조사 생성",
            description = "설문조사를 생성합니다.",
            requestBody = @RequestBody(content = @Content(
                    examples = @ExampleObject(name = "요청 예시", value = """
                            {
                              "basic": {
                                "name": "설문지 이름",
                                "description": "설문지 설명 입니다."
                              },
                              "items": [
                                {
                                  "name": "이름",
                                  "description": "당신의 이름은?",
                                  "inputType": "SHORT_ANSWER",
                                  "required": true,
                                  "choices": []
                                },
                                {
                                  "name": "나이",
                                  "description": "당신의 나이는?",
                                  "inputType": "SHORT_ANSWER",
                                  "required": true,
                                  "choices": []
                                },
                                {
                                  "name": "음식선택",
                                  "description": "좋아하는 음식 1개만 골라주세요.",
                                  "inputType": "SINGLE_CHOICE",
                                  "required": true,
                                  "choices": ["피자", "치킨", "햄버거", "초밥"]
                                },
                                {
                                  "name": "음식제외",
                                  "description": "싫어하는 음식을 모두 골라주세요.",
                                  "inputType": "MULTIPLE_CHOICE",
                                  "required": false,
                                  "choices": ["회", "오이김밥", "고등어순살조림", "명태순살조림"]
                                }
                              ]
                            }
                            """
                    )
            )),
            responses = @ApiResponse(content = @Content(
                    examples = @ExampleObject(name = "응답 예시", value = """
                            {
                              "code": "SUCCESS",
                              "message": null,
                              "validations": null,
                              "result": {
                                "basic": {
                                  "id": 1,
                                  "name": "설문지 이름",
                                  "description": "설문지 설명 입니다."
                                },
                                "items": [
                                  {
                                    "id": 1,
                                    "name": "이름",
                                    "description": "당신의 이름은?",
                                    "inputType": "SHORT_ANSWER",
                                    "required": true,
                                    "choices": []
                                  },
                                  {
                                    "id": 2,
                                    "name": "나이",
                                    "description": "당신의 나이는?",
                                    "inputType": "SHORT_ANSWER",
                                    "required": true,
                                    "choices": []
                                  },
                                  {
                                    "id": 3,
                                    "name": "음식선택",
                                    "description": "좋아하는 음식 1개만 골라주세요.",
                                    "inputType": "SINGLE_CHOICE",
                                    "required": true,
                                    "choices": [
                                      "피자",
                                      "치킨",
                                      "햄버거",
                                      "초밥"
                                    ]
                                  },
                                  {
                                    "id": 4,
                                    "name": "음식제외",
                                    "description": "싫어하는 음식을 모두 골라주세요.",
                                    "inputType": "MULTIPLE_CHOICE",
                                    "required": false,
                                    "choices": [
                                      "회",
                                      "오이김밥",
                                      "고등어순살조림",
                                      "명태순살조림"
                                    ]
                                  }
                                ]
                              }
                            }
                            """
                    )
            ))
    )
    ResponseEntity<ApiResult<SurveyCreationResponse>> createSurvey(SurveyCreationRequest surveyCreationRequest);

}
