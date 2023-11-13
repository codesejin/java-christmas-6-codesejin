package christmas.domain;

import static christmas.utils.Constants.*;

public class DDayDiscount {

    private int discountAmount;

    private DDayDiscount (VisitDay visitDay) {
        this.discountAmount = checkDuration(visitDay);
    }
    public static DDayDiscount create (VisitDay visitDay) {
        return new DDayDiscount(visitDay);
    }

    private static int checkDuration(VisitDay visitDay) {
        if (visitDay.getDate() > CHRISTMAS_DAY || visitDay.getDate() < FIRST_DAY_OF_MONTH) return DEFAULT_AMOUNT;
        return calculateDiscount(visitDay.getDate());
    }

    private static int calculateDiscount(int dayOfMonth) {
        int defaultDiscount = DEFAULT_D_DAY_DISCOUNT;
        int additionalDiscountPerDay = ADDITIONAL_DISCOUNT_PER_DAY;

        int daysUntilChristmas = CHRISTMAS_DAY - dayOfMonth + FIRST_DAY_OF_MONTH;
        int totalDiscount = defaultDiscount + (CHRISTMAS_DAY - daysUntilChristmas) * additionalDiscountPerDay;

        return totalDiscount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
