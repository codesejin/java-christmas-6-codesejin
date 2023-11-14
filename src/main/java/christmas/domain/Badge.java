package christmas.domain;

import static christmas.domain.BadgeType.*;
import static christmas.utils.Constants.*;

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

        if (isInRange(totalDiscount, STAR.getBadgeLimit(), TREE.getBadgeLimit())) return STAR.getName();
        if (isInRange(totalDiscount, TREE.getBadgeLimit(), SANTA.getBadgeLimit())) return TREE.getName();
        if (totalDiscount >= SANTA.getBadgeLimit()) return SANTA.getName();
        return NOTHING;
    }

    private boolean isInRange(int value, int start, int end) {
        return value >= start && value < end;
    }

    public String getBadge() {
        return badge;
    }
}
