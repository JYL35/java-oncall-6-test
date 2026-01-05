package oncall.util;

import java.util.List;
import oncall.constant.ErrorMessage;

public class Validator {
    private static final List<String> ALL_DAYS_OF_THE_WEEK = List.of("일", "월", "화", "수", "목", "금", "토");

    public static int validateMonth(String input) {
        validateEmpty(input, ErrorMessage.MONTH_IS_EMPTY);
        int month = validateNumber(input, ErrorMessage.MONTH_IS_NOT_NUMBER);
        validateRange(1, 12, month, ErrorMessage.MONTH_OUT_OF_RANGE);
        return month;
    }

    public static String validateDayOfTheWeek(String input) {
        validateEmpty(input, ErrorMessage.DAY_OF_THE_WEEK_IS_EMPTY);
        validateContains(input, ALL_DAYS_OF_THE_WEEK, ErrorMessage.DAY_OF_THE_WEEK_INVALID_FORMAT);
        return input;
    }

    private static void validateContains(String input, List<String> targets, ErrorMessage errorMessage) {
        if (targets.contains(input)) return;
        throw new IllegalArgumentException(errorMessage.getMessage());
    }

    private static void validateEmpty(String input, ErrorMessage errorMessage) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    private static int validateNumber(String input, ErrorMessage errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    private static void validateRange(int min, int max, int target, ErrorMessage errorMessage) {
        if (target < min || target > max) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
