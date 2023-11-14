package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Order;
import christmas.domain.VisitDay;

import static christmas.utils.ErrorMessages.INPUT_DATE_FORMAT;
import static christmas.utils.ViewMessages.INPUT_DATE_GUIDE;
import static christmas.utils.ViewMessages.INPUT_ORDER_GUIDE;
import static christmas.view.InputValidator.checkDateNumberInRange;
import static christmas.view.InputValidator.parseNumber;
import static christmas.view.InputValidator.checkOrders;

public class InputView {
    public VisitDay readDate() {
        while(true) {
            try {
                System.out.println(INPUT_DATE_GUIDE);
                String input = Console.readLine();
                int date = checkDateNumberInRange(parseNumber(input, INPUT_DATE_FORMAT));
                return VisitDay.create(date);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Order readOrders() {
        while (true) {
            try {
                System.out.println(INPUT_ORDER_GUIDE);
                String input = Console.readLine();
                return Order.create(checkOrders(input));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
