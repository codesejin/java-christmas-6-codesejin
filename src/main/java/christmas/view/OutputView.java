package christmas.view;

import christmas.domain.Gift;
import christmas.domain.Order;

import java.util.Map;

import static christmas.utils.Constants.*;

public class OutputView {

    public void printMenu(Order order) {
        System.out.println(OUTPUT_ORDER_LIST);
        for (Map.Entry<String,Integer> entry : order.getOrder().entrySet()) {
            System.out.println(entry.getKey() + BLANK + entry.getValue() + COUNT);
        }
    }

    public void printOrderAmountBeforeDiscount(Order order) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(String.format("%,d원", order.getOrderAmount()));
    }

    public void printGift(Gift gift) {
        System.out.println("\n<증정 메뉴>");
        System.out.println(gift.getGift());
    }
}
