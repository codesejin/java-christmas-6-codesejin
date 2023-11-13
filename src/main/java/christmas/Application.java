package christmas;

import christmas.domain.Discount;
import christmas.domain.Gift;
import christmas.domain.Order;
import christmas.domain.VisitDay;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        VisitDay visitDay = inputView.readDate();
        Map<String, Integer> stringIntegerMap = inputView.readOrders();
        Order order = Order.create(stringIntegerMap);
        outputView.printMenu(order);
        outputView.printOrderAmountBeforeDiscount(order);
        Gift gift = Gift.create(order);
        outputView.printGift(gift);
        outputView.printDiscountHistories(Discount.create(order,visitDay));
    }
}
