package christmas.domain;

import static christmas.utils.Constants.DEFAULT_AMOUNT;

public class DDayDiscount {

    private int discountAmount;

    private DDayDiscount (VisitDay visitDay) {
        this.discountAmount = checkDuration(visitDay);
    }
    public static DDayDiscount create (VisitDay visitDay) {
        return new DDayDiscount(visitDay);
    }

    private static int checkDuration(VisitDay visitDay) {
        if (visitDay.getDate() > 25 || visitDay.getDate() < 1) return DEFAULT_AMOUNT;
        return calculateDiscount(visitDay.getDate());
    }

    private static int calculateDiscount(int dayOfMonth) {
        int defaultDiscount = 1000;
        int additionalDiscountPerDay = 100;

        int daysUntilChristmas = 25 - dayOfMonth + 1;
        int totalDiscount = defaultDiscount + (25 - daysUntilChristmas) * additionalDiscountPerDay;

        return totalDiscount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
