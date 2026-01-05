package oncall.domain;

import oncall.constant.ErrorMessage;

public enum Calendar {
    January(1, 31),
    February(2, 28),
    March(3, 31),
    April(4, 30),
    May(5, 31),
    June(6, 30),
    July(7, 31),
    August(8, 31),
    September(9, 30),
    October(10, 31),
    November(11, 30),
    December(12, 31);

    private final int month;
    private final int lastDay;

    Calendar(int month, int lastDay) {
        this.month = month;
        this.lastDay = lastDay;
    }

    public static int lastDayOfMonth(int month) {
        for (Calendar calendar : Calendar.values()) {
            if (calendar.getMonth() == month) {
                return calendar.getLastDay();
            }
        }
        throw new IllegalArgumentException(ErrorMessage.MONTH_OUT_OF_RANGE.getMessage());
    }

    public int getMonth() {
        return month;
    }

    public int getLastDay() {
        return lastDay;
    }
}
