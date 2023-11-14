package christmas.domain.discount;

import christmas.domain.Order;
import christmas.domain.VisitDay;

import static christmas.utils.Constants.*;

public class WeekendDiscount extends WeekDiscount {
    private final String name;

    private WeekendDiscount(Order order, VisitDay visitDay) {
        super(order, visitDay, VisitDay.DayType.WEEKEND, MAIN);
        this.name = "주말 할인";
    }

    public static WeekendDiscount create(Order order, VisitDay visitDay) {
        return new WeekendDiscount(order, visitDay);
    }

    public String getName() {
        return name;
    }
}
