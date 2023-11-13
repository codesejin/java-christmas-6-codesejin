package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

import static christmas.utils.ErrorMessages.INPUT_DATE_FORMAT;
import static christmas.view.InputValidator.*;

public class InputView {
    public int readDate() {
        while(true) {
            try {
                System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
                String input = Console.readLine();
                return checkNumberInRange(parseNumber(input,INPUT_DATE_FORMAT));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Map<String, Integer> readOrders() {
        while (true) {
            try {
                System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
                String input = Console.readLine();
                Map<String, Integer> orders = checkOrders(input);
                return orders;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
