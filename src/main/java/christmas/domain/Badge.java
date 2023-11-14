package christmas.domain;

import static christmas.utils.Constants.NOTHING;

public class Badge {
    private final String badge;

    private Badge(Discount discount) {
        this.badge = checkBadge(discount);
    }
    public static Badge create (Discount discount) {
        return new Badge(discount);
    }

    public String checkBadge(Discount discount) {
        int totalDiscount = discount.totalDiscountWithGift();

        if (isInRange(totalDiscount, 5000, 10000)) return "별";
        if (isInRange(totalDiscount, 10000, 20000)) return "트리";
        if (totalDiscount >= 20000) return "산타";
        return NOTHING;
    }

    private boolean isInRange(int value, int start, int end) {
        return value >= start && value < end;
    }

    public String getBadge() {
        return badge;
    }
}
