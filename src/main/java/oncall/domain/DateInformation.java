package oncall.domain;

public class DateInformation {

    private final String dayOfTheWeek;
    private final boolean holiday;

    public DateInformation(String dayOfTheWeek, boolean holiday) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.holiday = holiday;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public boolean isHoliday() {
        return holiday;
    }
}
