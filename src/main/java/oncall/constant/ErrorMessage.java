package oncall.constant;

public enum ErrorMessage {
    MONTH_IS_EMPTY("월이 비어있습니다. 다시 입력해주세요."),
    MONTH_IS_NOT_NUMBER("월이 숫자가 아닙니다. 다시 입력해주세요."),
    MONTH_OUT_OF_RANGE("월은 1~12이어야 합니다. 다시 입력해주세요."),

    DAY_OF_THE_WEEK_IS_EMPTY("요일이 비어있습니다. 다시 입력해주세요."),
    DAY_OF_THE_WEEK_INVALID_FORMAT("잘못된 요일 형식입니다. 다시 입력해주세요."),

    WEEKDAY_WORKERS_COUNT_OUT_OF_RANGE("평일 근무자들은 최소 5명, 최대 35명이어야합니다. 다시 입력해주세요."),
    WEEKDAY_WORKER_IS_EMPTY("평일 근무자가 비어있습니다. 다시 입력해주세요."),
    WEEKDAY_WORKER_NAME_OUT_OF_RANGE("평일 근무자 닉네임은 1~5글자이어야 합니다. 다시 입력해주세요."),
    WEEKDAY_WORKERS_DUPLICATE("평일 근무자가 중복됩니다. 다시 입력해주세요."),

    HOLIDAY_WORKERS_COUNT_OUT_OF_RANGE("휴일 근무자들은 최소 5명, 최대 35명이어야합니다. 다시 입력해주세요."),
    HOLIDAY_WORKER_IS_EMPTY("휴일 근무자가 비어있습니다. 다시 입력해주세요."),
    HOLIDAY_WORKER_NAME_OUT_OF_RANGE("휴일 근무자 닉네임은 1~5글자이어야 합니다. 다시 입력해주세요."),
    HOLIDAY_WORKERS_DUPLICATE("휴일 근무자가 중복됩니다. 다시 입력해주세요."),
    WORKERS_IS_WRONG("휴일 근무자 중 평일 근무자에 없는 사람이 있습니다. 다시 입력해주세요."),

    NOT_FOUND_WORK_RECORD("근무 기록을 찾을 수 없습니다."),
    INVALID_FORMAT("잘못된 형식을 입력하였습니다."),
    NOT_FOUND_NICKNAME("등록되지 않은 닉네임입니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
