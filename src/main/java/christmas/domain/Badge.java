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
        if (discount.totalDiscount() >= 5000 && discount.totalDiscount() < 10000) return "별";
        if (discount.totalDiscount() >= 10000 && discount.totalDiscount() < 20000) return "트리";
        if (discount.totalDiscount() >= 20000) return "산타";
        return NOTHING;
    }

    public String getBadge() {
        return badge;
    }
}
