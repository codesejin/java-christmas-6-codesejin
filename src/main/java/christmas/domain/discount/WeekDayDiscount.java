package christmas.domain.discount;

import christmas.domain.Order;
import christmas.domain.VisitDay;

import static christmas.domain.Menu.checkFoodType;
import static christmas.utils.Constants.*;

public class WeekDayDiscount {
    private final String name;
    private final int discountAmount;

    private WeekDayDiscount(Order order, VisitDay visitDay) {
        this.name = "평일 할인";
        this.discountAmount = calculateDiscount(order, visitDay);
    }

    public static WeekDayDiscount create(Order order, VisitDay visitDay) {
        return new WeekDayDiscount(order, visitDay);
    }

    public boolean isDiscountDay(VisitDay visitDay) {
        return visitDay.getDayOfMonth() == VisitDay.DayType.WEEKDAY;
    }

    private int calculateDiscount(Order order, VisitDay visitDay) {
        int calculatedDiscountAmount = DEFAULT_AMOUNT;

        if (isDiscountDay(visitDay)) {
            calculatedDiscountAmount = checkFoodType(order,DESSERT) * WEEK_DISCOUNT_PER_TYPE;
        }

        return calculatedDiscountAmount;
    }

    public String getName() {
        return name;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
