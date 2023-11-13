package christmas.view;

import java.util.Map;

public class OutputView {

    public void printMenu(Map<String,Integer> stringIntegerMap) {
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n<주문 메뉴>");
        for (Map.Entry<String,Integer> entry : stringIntegerMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "개");
        }
    }
}
