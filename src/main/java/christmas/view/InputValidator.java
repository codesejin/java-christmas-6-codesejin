package christmas.view;

import java.util.HashMap;
import java.util.Map;

import static christmas.domain.Menu.checkMenu;
import static christmas.domain.Menu.checkMenuComposition;
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

    public static int checkDateNumberInRange(int date) {
        if (date < MIN_NUMBER_IN_RANGE || date > MAX_NUMBER_IN_RANGE) throw new IllegalArgumentException(INPUT_DATE_FORMAT);
        return date;
    }

    public static Map<String, Integer> checkOrders(String input) {
        Map<String, Integer> orders = new HashMap<>();
        String[] eachOrder = input.split(",", -1);
        for (int i = 0; i < eachOrder.length; i++) {
            String[] order = checkOrderFormat(eachOrder[i].split("-"));
            String menu = checkDuplicateMenu(orders, checkMenu(order[0]).getName());
            int count = checkOrderCntIsPositive(parseNumber(order[1],INPUT_ORDER_FORMAT));
            orders.put(menu, count);
        }
        checkMenuComposition(orders);
        checkTotalMenuCount(orders);
        return orders;
    }

    public static String[] checkOrderFormat(String[] order) {
        if (order.length < 2) throw new IllegalArgumentException(INPUT_ORDER_FORMAT);
        return order;
    }

    public static String checkDuplicateMenu(Map<String,Integer> orders, String menu) {
        if (orders.containsKey(menu)) throw new IllegalArgumentException(INPUT_ORDER_FORMAT);
        return menu;
    }

    public static int checkOrderCntIsPositive(int count) {
        if (count < 1) throw new IllegalArgumentException(INPUT_ORDER_FORMAT);
        return count;
    }

    private static void checkTotalMenuCount(Map<String, Integer> orders) {
        int totalOrderCount = orders.values().stream().mapToInt(Integer::intValue).sum();
        if (totalOrderCount > 20) {
            throw new IllegalArgumentException("[ERROR] 주문된 메뉴의 총합이 20을 초과합니다.");
        }
    }
}
