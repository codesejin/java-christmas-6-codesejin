package christmas.controller;

import christmas.domain.Discount;
import christmas.domain.Order;
import christmas.domain.VisitDay;
import christmas.domain.discount.Gift;
import christmas.view.InputView;
import christmas.view.OutputView;

import static christmas.utils.ViewMessages.EVENT_BENEFIT_MESSAGE;
import static christmas.utils.ViewMessages.PROMOTION_START_MESSAGE;

public class Promotion {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private InitDto initDto;

    public void start() {
        System.out.println(PROMOTION_START_MESSAGE);
        VisitDay visitDay = inputView.readDate();
        Order order = inputView.readOrders();
        initDto = InitDto.create(order,visitDay);
    }

    public void running() {
        System.out.println(EVENT_BENEFIT_MESSAGE);
        outputView.printMenu(initDto.getOrder());
        outputView.printOrderAmountBeforeDiscount(initDto.getOrder());
        outputView.printGift(Gift.create(initDto.getOrder()));
        Discount discount = Discount.create(initDto.getOrder(), initDto.getVisitDay());
        outputView.printDiscountHistories(discount);
        outputView.printTotalDiscount(discount);
        outputView.printFinalAmount(initDto.getOrder(), discount);
        outputView.printBadge(discount);
    }
}
