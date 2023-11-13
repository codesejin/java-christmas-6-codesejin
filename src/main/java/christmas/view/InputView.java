package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.VisitDay;

import java.util.Map;

import static christmas.utils.Constants.INPUT_DATE_GUIDE;
import static christmas.utils.Constants.INPUT_ORDER_GUIDE;
import static christmas.utils.ErrorMessages.INPUT_DATE_FORMAT;
import static christmas.view.InputValidator.*;

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

    public static Map<String, Integer> readOrders() {
        while (true) {
            try {
                System.out.println(INPUT_ORDER_GUIDE);
                String input = Console.readLine();
                Map<String, Integer> orders = checkOrders(input);
                return orders;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
