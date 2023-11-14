package christmas.domain.discount;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.VisitDay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static christmas.utils.Constants.DEFAULT_AMOUNT;
import static christmas.utils.Constants.WEEK_DISCOUNT_PER_TYPE;
import static org.assertj.core.api.Assertions.assertThat;


class WeekDiscountTest {

    @Test
    @DisplayName("calculateDiscount 메서드 - 평일에 디저트 주문 안했을 경우")
    public void calculateDiscount_NoDessertOnWeekday() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("타파스", 1);
        orderItems.put("레드와인", 1);
        Order order = Order.create(orderItems);

        VisitDay weekdayVisitDay = VisitDay.create(4);// 월요일

        int amount = WeekDiscount.calculateDiscount(order, weekdayVisitDay, VisitDay.DayType.WEEKDAY, Menu.MenuType.DESSERT);
        assertThat(amount).isEqualTo(DEFAULT_AMOUNT);
    }

    @Test
    @DisplayName("calculateDiscount 메서드 - 평일에 디저트 1개 주문했을 경우")
    public void calculateDiscount_1DessertOnWeekday() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("아이스크림", 1);
        orderItems.put("타파스", 1);
        orderItems.put("레드와인", 1);
        Order order = Order.create(orderItems);

        VisitDay weekdayVisitDay = VisitDay.create(4);// 월요일

        int amount = WeekDiscount.calculateDiscount(order, weekdayVisitDay, VisitDay.DayType.WEEKDAY, Menu.MenuType.DESSERT);
        assertThat(amount).isEqualTo(WEEK_DISCOUNT_PER_TYPE);
    }

    @Test
    @DisplayName("calculateDiscount 메서드 - 평일에 디저트 3개 주문했을 경우")
    public void calculateDiscount_3DessertOnWeekday() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("아이스크림", 3);
        orderItems.put("타파스", 1);
        orderItems.put("레드와인", 1);
        Order order = Order.create(orderItems);

        VisitDay weekdayVisitDay = VisitDay.create(4);// 월요일

        int amount = WeekDiscount.calculateDiscount(order, weekdayVisitDay, VisitDay.DayType.WEEKDAY, Menu.MenuType.DESSERT);
        assertThat(amount).isEqualTo(3 * WEEK_DISCOUNT_PER_TYPE);
    }

    @Test
    @DisplayName("calculateDiscount 메서드 - 주말에 메인 주문 안했을 경우")
    public void calculateDiscount_NoMainOnWeekend() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("타파스", 1);
        Order order = Order.create(orderItems);

        VisitDay weekend = VisitDay.create(2);// 토요일

        int amount = WeekDiscount.calculateDiscount(order, weekend, VisitDay.DayType.WEEKEND, Menu.MenuType.MAIN);
        assertThat(amount).isEqualTo(DEFAULT_AMOUNT);
    }

    @Test
    @DisplayName("calculateDiscount 메서드 - 주말에 메인 주문 1개 했을 경우")
    public void calculateDiscount_1MainOnWeekend() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("해산물파스타", 1);
        Order order = Order.create(orderItems);

        VisitDay weekend = VisitDay.create(2);// 토요일

        int amount = WeekDiscount.calculateDiscount(order, weekend, VisitDay.DayType.WEEKEND, Menu.MenuType.MAIN);
        assertThat(amount).isEqualTo(WEEK_DISCOUNT_PER_TYPE);
    }

    @Test
    @DisplayName("calculateDiscount 메서드 - 주말에 메인 주문 3개 했을 경우")
    public void calculateDiscount_3MainOnWeekend() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("바비큐립", 3);
        Order order = Order.create(orderItems);

        VisitDay weekend = VisitDay.create(2);// 토요일

        int amount = WeekDiscount.calculateDiscount(order, weekend, VisitDay.DayType.WEEKEND, Menu.MenuType.MAIN);
        assertThat(amount).isEqualTo(3 * WEEK_DISCOUNT_PER_TYPE);
    }
}