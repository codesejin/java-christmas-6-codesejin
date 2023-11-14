package christmas.domain.discount;

import christmas.domain.Order;

import static christmas.utils.Constants.GIFT_POSSIBLE_AMOUNT;
import static christmas.utils.Constants.GIFT;
import static christmas.utils.Constants.NOTHING;
import static christmas.utils.Constants.GIFT_AMOUNT;
import static christmas.utils.Constants.DEFAULT_AMOUNT;

public class Gift {
    private final String name;
    private final String gift;
    private final int discountAmount;

    private Gift(Order order) {
        this.name = "증정 이벤트";
        this.gift = checkGift(order);
        this.discountAmount = checkAmount(order);
    }

    public static Gift create(Order order) {
        return new Gift(order);
    }

    public String checkGift(Order order) {
        if (order.getOrderAmount() >= GIFT_POSSIBLE_AMOUNT) return GIFT;
        return NOTHING;
    }

    public int checkAmount(Order order) {
        if (order.getOrderAmount() >= GIFT_POSSIBLE_AMOUNT) return GIFT_AMOUNT;
        return DEFAULT_AMOUNT;
    }

    public String getName() {
        return name;
    }

    public String getGift() {
        return gift;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
