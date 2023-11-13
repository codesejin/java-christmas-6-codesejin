package christmas.domain;

import java.util.Map;

import static christmas.utils.ErrorMessages.CHECK_ORDER_ONLY_DRINKS;
import static christmas.utils.ErrorMessages.INPUT_ORDER_FORMAT;

public enum Menu {
    양송이수프("appetizer", "양송이수프", 6000),
    타파스("appetizer", "타파스", 5500),
    시저샐러드("appetizer", "시저샐러드", 8000),

    티본스테이크("main", "티본스테이크", 55000),
    바비큐립("main", "바비큐립", 54000),
    해산물파스타("main", "해산물파스타", 35000),
    크리스마스파스타("main", "크리스마스파스타", 25000),

    초코케이크("dessert", "초코케이크", 15000),
    아이스크림("dessert", "아이스크림", 5000),

    제로콜라("drink", "제로콜라", 3000),
    레드와인("drink", "레드와인", 60000),
    샴페인("drink", "샴페인", 25000);

    private final String type;
    private final String name;
    private final int price;

    Menu(String type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static Menu checkMenu(String input) {
        for (Menu menu : values()) {
            if (menu.name.equals(input)) return menu;
        }
        throw new IllegalArgumentException(INPUT_ORDER_FORMAT);
    }

    public static void checkMenuComposition(Map<String, Integer> orders) {
        String drinkType = "drink";
        if (orders.keySet().stream().allMatch(menu -> Menu.checkMenu(menu).getType().equals(drinkType))) {
            throw new IllegalArgumentException(CHECK_ORDER_ONLY_DRINKS);
        }
    }

    public static int checkDessert(Order order) {
        String dessertType = "dessert";
        int dessertCnt = 0;
        for (String menu : order.getOrder().keySet()) {
            if (Menu.checkMenu(menu).getType().equals(dessertType)) {
                dessertCnt += order.getOrder().get(menu);
            }
        }
        return dessertCnt;
    }
}
