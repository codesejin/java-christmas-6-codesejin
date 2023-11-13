package christmas.view;

import java.util.HashMap;
import java.util.Map;

import static christmas.domain.Menu.checkMenu;
import static christmas.utils.Constants.MAX_NUMBER_IN_RANGE;
import static christmas.utils.Constants.MIN_NUMBER_IN_RANGE;
import static christmas.utils.ErrorMessages.*;

public class InputValidator {

    public static int parseNumber(String string, String errorMessage) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(errorMessage);
        }
    }

    public static int checkNumberInRange(int date) {
        if (date < MIN_NUMBER_IN_RANGE || date > MAX_NUMBER_IN_RANGE) throw new IllegalArgumentException(INPUT_DATE_FORMAT);
        return date;
    }

    public static Map<String, Integer> checkOrders(String input) {
        Map<String, Integer> orders = new HashMap<>();
        String[] eachOrder = input.split(",", -1);
        for (int i = 0; i < eachOrder.length; i++) {
            String[] order = eachOrder[i].split("-");
            checkOrderFormat(order);
            String menu = checkMenu(order[0]);
            int count = parseNumber(order[1],INPUT_ORDER_FORMAT);
            orders.put(menu, count);
        }
        return orders;
    }

    public static void checkOrderFormat(String[] order) {
        if (order.length < 2) throw new IllegalArgumentException(INPUT_ORDER_FORMAT);
    }
}
