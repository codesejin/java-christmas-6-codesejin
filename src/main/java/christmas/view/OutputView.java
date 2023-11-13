package christmas.view;

import java.util.Map;

import static christmas.utils.Constants.*;

public class OutputView {

    public void printMenu(Map<String,Integer> stringIntegerMap) {
        System.out.println(OUTPUT_ORDER_LIST);
        for (Map.Entry<String,Integer> entry : stringIntegerMap.entrySet()) {
            System.out.println(entry.getKey() + BLANK + entry.getValue() + COUNT);
        }
    }
}
