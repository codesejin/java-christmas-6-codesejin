package christmas.domain;

import static christmas.domain.Menu.checkFoodType;
import static christmas.utils.Constants.DEFAULT_AMOUNT;

public class WeekendDiscount {
    private int discountAmount;

    private WeekendDiscount(Order order, VisitDay visitDay) {
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
            calculatedDiscountAmount = checkFoodType(order, "main") * 2023;
        }

        return calculatedDiscountAmount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
