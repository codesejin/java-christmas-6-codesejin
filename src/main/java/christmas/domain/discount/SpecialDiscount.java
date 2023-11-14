package christmas.domain.discount;

import christmas.domain.VisitDay;

import java.util.List;

import static christmas.utils.Constants.DEFAULT_AMOUNT;
import static christmas.utils.Constants.THOUSAND_WON;

public class SpecialDiscount {
    private final String name;
    private final List<Integer> starDay = List.of(3,10,17,24,25,31);
    private final int discountAmount;

    private SpecialDiscount(VisitDay visitDay) {
        this.name = "특별 할인";
        this.discountAmount = checkDiscountDay(visitDay);
    }

    public static SpecialDiscount create (VisitDay visitDay) {
        return new SpecialDiscount(visitDay);
    }

    public int checkDiscountDay(VisitDay visitDay) {
        if (starDay.contains(visitDay.getDate())) return THOUSAND_WON;
        return DEFAULT_AMOUNT;
    }

    public String getName() {
        return name;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
