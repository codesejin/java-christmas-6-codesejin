package christmas;

import christmas.controller.Promotion;

public class Application {
    public static void main(String[] args) {
        Promotion promotion = new Promotion();
        promotion.start();;
        promotion.running();;
    }
}
