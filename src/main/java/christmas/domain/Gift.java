package christmas.domain;

import static christmas.utils.Constants.*;

public class Gift {

    private String gift;

    private Gift(Order order) {
        this.gift = checkGift(order);
    }

    public static Gift create(Order order) {
        return new Gift(order);
    }

    public String checkGift(Order order) {
        if (order.getOrderAmount() >= GIFT_POSSIBLE_AMOUNT) return GIFT;
        return NOTHING;
    }

    public String getGift() {
        return gift;
    }
}
