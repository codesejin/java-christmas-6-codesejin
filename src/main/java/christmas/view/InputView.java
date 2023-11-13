package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public static Map<String,Integer> readOrders() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        String[] split = input.split(",");
        Map<String,Integer> orders = new HashMap<>();
        for (int i = 0; i < split.length ; i++) {
            String[] order = split[i].split("-");
            orders.put(order[0],Integer.parseInt(order[1]));
        }
        return orders;
    }
}
