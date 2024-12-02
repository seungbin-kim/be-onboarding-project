package ic2.onboarding.survey.api;

import ic2.onboarding.survey.dto.SurveyUpdateRequest;
import ic2.onboarding.survey.dto.SurveyUpdateResponse;
import ic2.onboarding.survey.global.ApiResult;
import ic2.onboarding.survey.dto.SurveyCreationRequest;
import ic2.onboarding.survey.dto.SurveyCreationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Tag(name = "설문조사 API")
public interface SurveyControllerDoc {

    @Operation(summary = "설문조사 생성",
            description = """
                    설문조사를 생성합니다.
                    - basic.name: 설문조사 이름
                    - basic.description: 설문조사 설명
                    - items[].name: 항목 이름
                    - items[].description: 항목 설명
                    - items[].inputType: 항목 타입 (SHORT_ANSWER | LONG_ANSWER | SINGLE_CHOICE | MULTIPLE_CHOICE 중 하나)
                    - items[].required: 필수여부
                    - items[].choices[]: 선택형 항목 목록 배열 (타입이 SINGLE_CHOICE 또는 MULTIPLE_CHOICE 일 때)
                    """,
            requestBody = @RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(
                                    name = "요청 예시 1",
                                    value = """
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
                                                  "choices": [
                                                    "피자",
                                                    "치킨",
                                                    "햄버거",
                                                    "초밥"
                                                  ]
                                                },
                                                {
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
                                            """
                            )
                    )
            ),
            responses = @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(
                                    name = "응답 예시 1",
                                    value = """
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
                    )
            )
    )
    ResponseEntity<ApiResult<SurveyCreationResponse>> createSurvey(SurveyCreationRequest request);


    @Operation(summary = "설문조사 수정",
            description = """
                    설문조사를 수정합니다.
                    - path parameter
                      - id: 수정할 설문조사 식별자
                    - basic.name: 설문조사 이름
                    - basic.description: 설문조사 설명
                    - items[]
                      - <b>기존 항목이 요청 목록에 없다면 삭제됩니다.</b>
                    - items[].id: 항목 식별자 (존재시 기존 항목 변경, 미존재시 신규 항목 등록)
                    - items[].name: 항목 이름
                    - items[].description: 항목 설명
                    - items[].inputType: 항목 타입 (SHORT_ANSWER | LONG_ANSWER | SINGLE_CHOICE | MULTIPLE_CHOICE 중 하나)
                    - items[].required: 필수여부
                    - items[].choices[]: 선택형 항목 목록 배열 (타입이 SINGLE_CHOICE 또는 MULTIPLE_CHOICE 일 때)
                    """,
            requestBody = @RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(
                                    name = "요청 예시 1",
                                    value = """
                                            {
                                              "basic": {
                                                "name": "설문지 이름 수정~",
                                                "description": "설문지 설명 수정~"
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
                                                  "name": "생년월일",
                                                  "description": "당신의 생년월일을 적어주세요.",
                                                  "inputType": "SHORT_ANSWER",
                                                  "required": true,
                                                  "choices": []
                                                },
                                                {
                                                  "id": 4,
                                                  "name": "음식제외",
                                                  "description": "싫어하는 음식을 모두 골라주세요.",
                                                  "inputType": "MULTIPLE_CHOICE",
                                                  "required": true,
                                                  "choices": [
                                                    "고등어순살조림",
                                                    "명태순살조림"
                                                  ]
                                                },
                                                {
                                                  "name": "인사해요",
                                                  "description": "안녕하세요?",
                                                  "inputType": "SINGLE_CHOICE",
                                                  "required": true,
                                                  "choices": [
                                                    "안녕하세요",
                                                    "안녕못해요"
                                                  ]
                                                }
                                              ]
                                            }
                                            """
                            )
                    )
            ),
            responses = @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(
                                    name = "응답 예시 1",
                                    value = """
                                            {
                                              "code": "SUCCESS",
                                              "message": null,
                                              "validations": null,
                                              "result": {
                                                "basic": {
                                                  "id": 1,
                                                  "name": "설문지 이름 수정~",
                                                  "description": "설문지 설명 수정~"
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
                                                    "name": "생년월일",
                                                    "description": "당신의 생년월일을 적어주세요.",
                                                    "inputType": "SHORT_ANSWER",
                                                    "required": true,
                                                    "choices": []
                                                  },
                                                  {
                                                    "id": 4,
                                                    "name": "음식제외",
                                                    "description": "싫어하는 음식을 모두 골라주세요.",
                                                    "inputType": "MULTIPLE_CHOICE",
                                                    "required": true,
                                                    "choices": [
                                                      "고등어순살조림",
                                                      "명태순살조림"
                                                    ]
                                                  },
                                                  {
                                                    "id": 5,
                                                    "name": "인사해요",
                                                    "description": "안녕하세요?",
                                                    "inputType": "SINGLE_CHOICE",
                                                    "required": true,
                                                    "choices": [
                                                      "안녕하세요",
                                                      "안녕못해요"
                                                    ]
                                                  }
                                                ]
                                              }
                                            }
                                            """
                            )
                    )
            )
    )
    ResponseEntity<ApiResult<SurveyUpdateResponse>> updateSurvey(Long id, SurveyUpdateRequest request);

}
