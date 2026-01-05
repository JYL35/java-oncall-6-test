package oncall.domain;

public enum DayOfTheWeek {
    월("화"),
    화("수"),
    수("목"),
    목("금"),
    금("토"),
    토("일"),
    일("월");

    private final String nextDayOfTheWeek;

    DayOfTheWeek(String nextDayOfTheWeek) {
        this.nextDayOfTheWeek = nextDayOfTheWeek;
    }

    public static String findNextDayOfTheWeek(String input) {
        for (DayOfTheWeek dayOfTheWeek : DayOfTheWeek.values()) {
            if (dayOfTheWeek.name().equals(input)) {
                return dayOfTheWeek.getNextDayOfTheWeek();
            }
        }

        throw new IllegalArgumentException("다음 요일을 찾을 수 없습니다.");
    }

    public String getNextDayOfTheWeek() {
        return nextDayOfTheWeek;
    }
}
