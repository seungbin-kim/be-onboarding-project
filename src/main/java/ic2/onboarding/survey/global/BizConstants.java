package ic2.onboarding.survey.global;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BizConstants {

    public static final int MIN_NAME_LENGTH = 2;
    public static final int MAX_NAME_LENGTH = 255;

    public static final int MIN_DESCRIPTION_LENGTH = 2;
    public static final int MAX_DESCRIPTION_LENGTH = 500;

    public static final int MIN_QUESTION_SIZE = 1;
    public static final int MAX_QUESTION_SIZE = 10;

    public static final int MIN_CHOICES_SIZE = 0;
    public static final int MAX_CHOICES_SIZE = 5;

    public static final int MIN_TEXT_ANSWER_LENGTH = 1;
    public static final int MAX_TEXT_ANSWER_LENGTH = 1000;

}
