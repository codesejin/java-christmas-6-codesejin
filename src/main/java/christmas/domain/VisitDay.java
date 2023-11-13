package christmas.domain;

import java.time.LocalDate;

public class VisitDay {
    private final int date;
    private final DayType dayOfMonth;

    private VisitDay(int date) {
        this.date = date;
        this.dayOfMonth = checkDayOfWeek(date);
    }

    public static VisitDay create(int date) {
        return new VisitDay(date);
    }

    public int getDate() {
        return date;
    }

    public DayType getDayOfMonth() {
        return dayOfMonth;
    }

    public static DayType checkDayOfWeek(int date) {
        LocalDate localDate = LocalDate.of(2023, 12, date);
        int dayOfWeekValue = localDate.getDayOfWeek().getValue();
        //  월요일 1, 화요일 2, 수요일 3, 목요일 4, 금요일 5, 토요일 6, 일요일 7
        if ((dayOfWeekValue >= 1 && dayOfWeekValue <= 4) || dayOfWeekValue == 7) return DayType.WEEKDAY;
        return DayType.WEEKEND;

    }

    public enum DayType {
        WEEKDAY,
        WEEKEND
    }
}
