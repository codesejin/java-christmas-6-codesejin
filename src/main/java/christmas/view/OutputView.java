package christmas.view;

import christmas.domain.Discount;
import christmas.domain.Gift;
import christmas.domain.Order;

import java.util.Map;

import static christmas.utils.Constants.*;

public class OutputView {

    public void printMenu(Order order) {
        System.out.println(OUTPUT_ORDER_LIST);
        for (Map.Entry<String, Integer> entry : order.getOrder().entrySet()) {
            System.out.println(entry.getKey() + BLANK + entry.getValue() + COUNT);
        }
    }

    public void printOrderAmountBeforeDiscount(Order order) {
        System.out.println(TOTAL_ORDER_AMOUNT);
        System.out.println(String.format(AMOUNT, order.getOrderAmount()));
    }

    public void printGift(Gift gift) {
        System.out.println(GIFT_DISCOUNT);
        System.out.println(gift.getGift());
    }

    public void printDiscountHistories(Discount discount) {
        System.out.println("\n<혜택 내역>");
        StringBuilder print = new StringBuilder();
        if (discount.getdDayDiscount().getDiscountAmount() != 0)
            print.append(discount.getdDayDiscount().getName() + ": " + format(discount.getdDayDiscount().getDiscountAmount()));
        if (discount.getWeekDayDiscount().getDiscountAmount() != 0)
            print.append(discount.getWeekDayDiscount().getName() + ": " + format(discount.getWeekDayDiscount().getDiscountAmount()));
        if (discount.getWeekendDiscount().getDiscountAmount() != 0)
            print.append(discount.getWeekendDiscount().getName() + ": " + format(discount.getWeekendDiscount().getDiscountAmount()));
        if (discount.getSpecialDiscount().getDiscountAmount() != 0)
            print.append(discount.getSpecialDiscount().getName() + ": " + format(discount.getSpecialDiscount().getDiscountAmount()));
        if (discount.getGift().getDiscountAmount() != 0)
            print.append(discount.getGift().getName() + ": " + format(discount.getGift().getDiscountAmount()));
        System.out.println(print);
    }

    public String format(int amount) {
        return String.format("%,d원\n", amount * -1);
    }
}
