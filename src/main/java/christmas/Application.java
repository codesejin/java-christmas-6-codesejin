package christmas;

import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        inputView.readDate();
        Map<String, Integer> stringIntegerMap = inputView.readOrders();
        outputView.printMenu(stringIntegerMap);
    }
}
