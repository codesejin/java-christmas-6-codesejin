package christmas.view;

import java.util.HashMap;
import java.util.Map;

import static christmas.domain.Menu.checkMenu;
import static christmas.domain.Menu.checkMenuComposition;
import static christmas.utils.Constants.*;
import static christmas.utils.ErrorMessages.*;

public class InputValidator {

    public static int parseNumber(String string, String errorMessage) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(errorMessage);
        }
    }

    public static int checkDateNumberInRange(int date) {
        if (date < MIN_NUMBER_IN_RANGE || date > MAX_NUMBER_IN_RANGE) throw new IllegalArgumentException(INPUT_DATE_FORMAT);
        return date;
    }

    public static Map<String, Integer> checkOrders(String input) {
        Map<String, Integer> orders = new HashMap<>();
        String[] eachOrder = input.split(ORDERS_DELIMITER, -1);
        for (int i = 0; i < eachOrder.length; i++) {
            String[] order = checkOrderFormat(eachOrder[i].split(ORDER_DELIMITER));
            String menu = checkDuplicateMenu(orders, checkMenu(order[0]).getName());
            int count = checkOrderCntIsPositive(parseNumber(order[1],INPUT_ORDER_FORMAT));
            orders.put(menu, count);
        }
        checkMenuComposition(orders);
        checkTotalMenuCount(orders);
        return orders;
    }

    public static String[] checkOrderFormat(String[] order) {
        if (order.length < ONE_ORDER_FORMAT_SIZE) throw new IllegalArgumentException(INPUT_ORDER_FORMAT);
        return order;
    }

    public static String checkDuplicateMenu(Map<String,Integer> orders, String menu) {
        if (orders.containsKey(menu)) throw new IllegalArgumentException(INPUT_ORDER_FORMAT);
        return menu;
    }

    public static int checkOrderCntIsPositive(int count) {
        if (count < MIN_ORDER_COUNT_NUMBER) throw new IllegalArgumentException(INPUT_ORDER_FORMAT);
        return count;
    }

    private static void checkTotalMenuCount(Map<String, Integer> orders) {
        int totalOrderCount = orders.values().stream().mapToInt(Integer::intValue).sum();
        if (totalOrderCount > MAX_ORDER_COUNT_NUMBER) {
            throw new IllegalArgumentException(CHECK_MAX_ORDER_COUNT_MAX);
        }
    }
}
