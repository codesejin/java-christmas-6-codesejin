package christmas.domain;

import java.util.Map;

import static christmas.utils.ErrorMessages.CHECK_ORDER_ONLY_DRINKS;
import static christmas.utils.ErrorMessages.INPUT_ORDER_FORMAT;

public enum Menu {
    양송이수프(MenuType.APPETIZER, "양송이수프", 6000),
    타파스(MenuType.APPETIZER, "타파스", 5500),
    시저샐러드(MenuType.APPETIZER, "시저샐러드", 8000),

    티본스테이크(MenuType.MAIN, "티본스테이크", 55000),
    바비큐립(MenuType.MAIN, "바비큐립", 54000),
    해산물파스타(MenuType.MAIN, "해산물파스타", 35000),
    크리스마스파스타(MenuType.MAIN, "크리스마스파스타", 25000),

    초코케이크(MenuType.DESSERT, "초코케이크", 15000),
    아이스크림(MenuType.DESSERT, "아이스크림", 5000),

    제로콜라(MenuType.DRINK, "제로콜라", 3000),
    레드와인(MenuType.DRINK, "레드와인", 60000),
    샴페인(MenuType.DRINK, "샴페인", 25000);

    private final MenuType type;
    private final String name;
    private final int price;

    Menu(MenuType type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public MenuType getType() {
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
        if (orders.keySet().stream().allMatch(menu -> Menu.checkMenu(menu).getType().equals(MenuType.DRINK))) {
            throw new IllegalArgumentException(CHECK_ORDER_ONLY_DRINKS);
        }
    }

    public static int checkMenuType(Order order, Menu.MenuType menuType) {
        return order.getOrder().keySet().stream()
                .filter(menu -> Menu.checkMenu(menu).getType().equals(menuType))
                .mapToInt(menu -> order.getOrder().get(menu))
                .sum();
    }
    
    public enum MenuType {
        APPETIZER,
        MAIN,
        DESSERT,
        DRINK
    }
}
