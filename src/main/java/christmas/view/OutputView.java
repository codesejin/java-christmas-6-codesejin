package christmas.view;

import christmas.domain.Badge;
import christmas.domain.Discount;
import christmas.domain.discount.Gift;
import christmas.domain.Order;

import java.util.Map;

import static christmas.utils.Constants.*;
import static christmas.utils.ViewMessages.*;

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

        appendDiscountHistory(print, discount.getdDayDiscount().getName(),discount.getdDayDiscount().getDiscountAmount());
        appendDiscountHistory(print, discount.getWeekDayDiscount().getName(), discount.getWeekDayDiscount().getDiscountAmount());
        appendDiscountHistory(print, discount.getWeekendDiscount().getName(), discount.getWeekendDiscount().getDiscountAmount());
        appendDiscountHistory(print, discount.getSpecialDiscount().getName(),discount.getSpecialDiscount().getDiscountAmount());
        appendDiscountHistory(print, discount.getGift().getName(),discount.getGift().getDiscountAmount());

        if (print.isEmpty())
            print.append(NOTHING);

        System.out.println(print.toString().trim());
    }

    private void appendDiscountHistory(StringBuilder print, String discountType, int discountAmount) {
        if (discountAmount != 0) {
            print.append(discountType + COLON + minusAmountFormat(discountAmount) + LINE_BREAK);
        }
    }

    public void printTotalDiscount(Discount discount) {
        System.out.println(TOTAL_DISCOUNT);
        System.out.println(minusAmountFormat(discount.totalDiscountWithGift()));
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
