package christmas.domain.discount;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.VisitDay;

import static christmas.domain.Menu.checkMenuType;
import static christmas.utils.Constants.DEFAULT_AMOUNT;
import static christmas.utils.Constants.WEEK_DISCOUNT_PER_TYPE;

public class WeekDiscount {
    private int discountAmount;

    public WeekDiscount(Order order, VisitDay visitDay, VisitDay.DayType discountDay, Menu.MenuType menuType) {
        this.discountAmount = calculateDiscount(order, visitDay, discountDay, menuType);
    }

    public static WeekDiscount create(Order order, VisitDay visitDay, VisitDay.DayType discountDay, Menu.MenuType menuType) {
        return new WeekDiscount(order, visitDay, discountDay, menuType);
    }

    private int calculateDiscount(Order order, VisitDay visitDay, VisitDay.DayType discountDay, Menu.MenuType menuType) {
        int calculatedDiscountAmount = DEFAULT_AMOUNT;
        if (isDiscountDay(visitDay, discountDay)) {
            calculatedDiscountAmount = checkMenuType(order, menuType) * WEEK_DISCOUNT_PER_TYPE;
        }
        return calculatedDiscountAmount;
    }

    private static boolean isDiscountDay(VisitDay visitDay, VisitDay.DayType discountDay) {
        return visitDay.getDayOfMonth() == discountDay;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
