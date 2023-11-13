package christmas.view;

import christmas.domain.Badge;
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
            print.append(discount.getdDayDiscount().getName() + ": " + minusAmountFormat(discount.getdDayDiscount().getDiscountAmount())+LINE_BREAK);
        if (discount.getWeekDayDiscount().getDiscountAmount() != 0)
            print.append(discount.getWeekDayDiscount().getName() + ": " + minusAmountFormat(discount.getWeekDayDiscount().getDiscountAmount())+LINE_BREAK);
        if (discount.getWeekendDiscount().getDiscountAmount() != 0)
            print.append(discount.getWeekendDiscount().getName() + ": " + minusAmountFormat(discount.getWeekendDiscount().getDiscountAmount())+LINE_BREAK);
        if (discount.getSpecialDiscount().getDiscountAmount() != 0)
            print.append(discount.getSpecialDiscount().getName() + ": " + minusAmountFormat(discount.getSpecialDiscount().getDiscountAmount())+LINE_BREAK);
        if (discount.getGift().getDiscountAmount() != 0)
            print.append(discount.getGift().getName() + ": " + minusAmountFormat(discount.getGift().getDiscountAmount())+LINE_BREAK);
        if (print.isEmpty())
            print.append(NOTHING);
        System.out.println(print.toString().trim());
    }

    public void printTotalDiscount(Discount discount) {
        System.out.println("\n<총혜택 금액>");
        System.out.println(minusAmountFormat(discount.totalDiscount()));
    }

    public String minusAmountFormat(int amount) {
        return String.format("%,d원", amount * -1);
    }

    public void printFinalAmount(Order order, Discount discount) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        int finalAmount = order.getOrderAmount() - discount.totalDiscountWithoutGift();
        System.out.println(String.format("%,d원",finalAmount));
    }

    public void printBadge(Discount discount) {
        System.out.println("\n<12월 이벤트 배지>");
        Badge badge = Badge.create(discount);
        System.out.println(badge.getBadge());
    }
}
