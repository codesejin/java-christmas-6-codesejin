package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static christmas.utils.ErrorMessages.CHECK_ORDER_ONLY_DRINKS;
import static christmas.utils.ErrorMessages.INPUT_ORDER_FORMAT;
import static org.assertj.core.api.Assertions.*;

class MenuTest {

    @ParameterizedTest
    @DisplayName("checkMenu - 유효한 메뉴일 경우")
    @ValueSource(strings = {"타파스", "아이스크림", "레드와인", "바비큐립"})
    void checkMenu_ValidMenu(String menu) {
        Menu actual = Menu.checkMenu(menu);
        assertThat(actual.getName()).isEqualTo(menu);
        assertThatCode(() -> Menu.checkMenu(menu))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("checkMenu - 유효하지 않은 메뉴일 경우")
    @ValueSource(strings = {"콜라", "사이다", "마라탕", "떡볶이"})
    void checkMenu_InvalidMenu(String menu) {
        assertThatThrownBy(() -> Menu.checkMenu(menu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_ORDER_FORMAT);
    }

    @ParameterizedTest
    @DisplayName("checkMenuComposition - 음료수만 주문한 경우")
    @MethodSource("onlyDrink")
    void checkMenuComposition_OnlyDrinks(Map<String, Integer> orders) {
        assertThatThrownBy(() ->  Menu.checkMenuComposition(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CHECK_ORDER_ONLY_DRINKS);
    }

    static Stream<Map<String, Integer>> onlyDrink() {
        return Stream.of(
                createOrderMap("제로콜라", "4", "샴페인", "1"),
                createOrderMap("레드와인", "1", "샴페인", "1", "제로콜라", "1")
        );
    }

    @ParameterizedTest
    @DisplayName("checkMenuComposition - 음료수만 주문한 게 아닐 경우")
    @MethodSource("NotOnlyDrink")
    void checkMenuComposition_MixOfDrinksAndOthers(Map<String, Integer> orders) {
        assertThatCode(() -> Menu.checkMenuComposition(orders))
                .doesNotThrowAnyException();
    }

    static Stream<Map<String, Integer>> NotOnlyDrink() {
        return Stream.of(
                createOrderMap("타파스","1","해산물파스타","3","제로콜라", "4"),
                createOrderMap("바비큐립", "1", "아이스크림", "1", "제로콜라", "1"),
                createOrderMap("크리스마스파스타","2")
        );
    }

    @Test
    @DisplayName("checkMenuType - 특정 메뉴 타입의 주문 수량 확인")
    void checkMenuType_OrderQuantity() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("레드와인", 3);
        orderItems.put("바비큐립", 2);
        orderItems.put("아이스크림", 1);

        Order order = Order.create(orderItems);

        int drinkQuantity = Menu.checkMenuType(order, Menu.MenuType.DRINK);
        int mainQuantity = Menu.checkMenuType(order, Menu.MenuType.MAIN);
        int dessertQuantity = Menu.checkMenuType(order, Menu.MenuType.DESSERT);

        assertThat(drinkQuantity).isEqualTo(3);
        assertThat(mainQuantity).isEqualTo(2);
        assertThat(dessertQuantity).isEqualTo(1);
    }

    @Test
    @DisplayName("checkMenuType - 특정 메뉴 타입의 주문 수량 확인 - 주문이 없을 경우")
    void checkMenuType_NoOrder() {
        Map<String, Integer> orderItems = new HashMap<>();
        Order order = Order.create(orderItems);

        int drinkQuantity = Menu.checkMenuType(order, Menu.MenuType.DRINK);
        assertThat(drinkQuantity).isEqualTo(0);
    }

    @Test
    @DisplayName("checkMenuType - 특정 메뉴 타입의 주문 수량 확인 - 주문과 동일한 메뉴 타입이 아닐 경우")
    void checkMenuType_NoOrderForType() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("타파스", 2);
        Order order = Order.create(orderItems);

        int drinkQuantity = Menu.checkMenuType(order, Menu.MenuType.DRINK);

        assertThat(drinkQuantity).isEqualTo(0);
    }

    private static Map<String, Integer> createOrderMap(String... items) {
        if (items.length % 2 != 0) {
            throw new IllegalArgumentException("[ERROR] 인자는 Key-value로 쌍이어야 합니다.(menu, quantity).");
        }

        Map<String, Integer> orderItems = new HashMap<>();
        for (int i = 0; i < items.length; i += 2) {
            String itemName = items[i];
            int quantity = Integer.parseInt(items[i + 1]);
            orderItems.put(itemName, quantity);
        }

        return orderItems;
    }
}