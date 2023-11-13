package christmas.domain;

import java.util.List;

import static christmas.utils.Constants.DEFAULT_AMOUNT;

public class SpecialDiscount {

    private final List<Integer> starDay = List.of(3,10,17,24,25,31);
    private int discountAmount;

    private SpecialDiscount(VisitDay visitDay) {
        this.discountAmount = checkDiscountDay(visitDay);
    }

    public static SpecialDiscount create (VisitDay visitDay) {
        return new SpecialDiscount(visitDay);
    }

    public int checkDiscountDay(VisitDay visitDay) {
        if (starDay.contains(visitDay.getDate())) return 1000;
        return DEFAULT_AMOUNT;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
