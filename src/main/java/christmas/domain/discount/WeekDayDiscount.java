package christmas.domain.discount;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.VisitDay;

public class WeekDayDiscount extends WeekDiscount {
    private final String name;

    private WeekDayDiscount(Order order, VisitDay visitDay) {
        super(order, visitDay,VisitDay.DayType.WEEKDAY, Menu.MenuType.DESSERT);
        this.name = "평일 할인";
    }

    public static WeekDayDiscount create(Order order, VisitDay visitDay) {
        return new WeekDayDiscount(order, visitDay);
    }

    public String getName() {
        return name;
    }
}
