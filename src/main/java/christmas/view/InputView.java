package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

import static christmas.utils.Constants.INPUT_DATE_GUIDE;
import static christmas.utils.Constants.INPUT_ORDER_GUIDE;
import static christmas.utils.ErrorMessages.INPUT_DATE_FORMAT;
import static christmas.view.InputValidator.*;

public class InputView {
    public int readDate() {
        while(true) {
            try {
                System.out.println(INPUT_DATE_GUIDE);
                String input = Console.readLine();
                return checkDateNumberInRange(parseNumber(input,INPUT_DATE_FORMAT));
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
