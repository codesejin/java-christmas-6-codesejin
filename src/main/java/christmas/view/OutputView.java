package christmas.view;

import christmas.domain.Badge;
import christmas.domain.Discount;
import christmas.domain.discount.Gift;
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
        System.out.println(DISCOUNT_HISTORIES);
        StringBuilder print = new StringBuilder();
        if (discount.getdDayDiscount().getDiscountAmount() != 0)
            print.append(discount.getdDayDiscount().getName() + COLON + minusAmountFormat(discount.getdDayDiscount().getDiscountAmount())+LINE_BREAK);
        if (discount.getWeekDayDiscount().getDiscountAmount() != 0)
            print.append(discount.getWeekDayDiscount().getName() + COLON + minusAmountFormat(discount.getWeekDayDiscount().getDiscountAmount())+LINE_BREAK);
        if (discount.getWeekendDiscount().getDiscountAmount() != 0)
            print.append(discount.getWeekendDiscount().getName() + COLON + minusAmountFormat(discount.getWeekendDiscount().getDiscountAmount())+LINE_BREAK);
        if (discount.getSpecialDiscount().getDiscountAmount() != 0)
            print.append(discount.getSpecialDiscount().getName() +COLON + minusAmountFormat(discount.getSpecialDiscount().getDiscountAmount())+LINE_BREAK);
        if (discount.getGift().getDiscountAmount() != 0)
            print.append(discount.getGift().getName() + COLON + minusAmountFormat(discount.getGift().getDiscountAmount())+LINE_BREAK);
        if (print.isEmpty())
            print.append(NOTHING);
        System.out.println(print.toString().trim());
    }

    public void printTotalDiscount(Discount discount) {
        System.out.println(TOTAL_DISCOUNT);
        System.out.println(minusAmountFormat(discount.totalDiscount()));
    }

    public String minusAmountFormat(int amount) {
        return String.format(AMOUNT, amount * -1);
    }

    public void printFinalAmount(Order order, Discount discount) {
        System.out.println(FINAL_AMOUNT);
        int finalAmount = order.getOrderAmount() - discount.totalDiscountWithoutGift();
        System.out.println(String.format(AMOUNT,finalAmount));
    }

    public void printBadge(Discount discount) {
        System.out.println(DECEMBER_BADGE);
        Badge badge = Badge.create(discount);
        System.out.println(badge.getBadge());
    }
}
