package christmas.domain;

import static christmas.domain.Menu.checkFoodType;
import static christmas.utils.Constants.*;

public class WeekendDiscount {
    private final String name;
    private final int discountAmount;

    private WeekendDiscount(Order order, VisitDay visitDay) {
        this.name = "주말 할인";
        this.discountAmount = calculateDiscount(order, visitDay);
    }

    public static WeekendDiscount create(Order order, VisitDay visitDay) {
        return new WeekendDiscount(order, visitDay);
    }

    public boolean isDiscountDay(VisitDay visitDay) {
        return visitDay.getDayOfMonth() == VisitDay.DayType.WEEKEND;
    }

    private int calculateDiscount(Order order, VisitDay visitDay) {
        int calculatedDiscountAmount = DEFAULT_AMOUNT;

        if (isDiscountDay(visitDay)) {
            calculatedDiscountAmount = checkFoodType(order, MAIN) * WEEK_DISCOUNT_PER_TYPE;
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
