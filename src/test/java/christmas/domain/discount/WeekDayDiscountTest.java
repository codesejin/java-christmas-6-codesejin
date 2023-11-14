package christmas.domain.discount;

import christmas.domain.Order;
import christmas.domain.VisitDay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static christmas.utils.Constants.DEFAULT_AMOUNT;
import static christmas.utils.Constants.WEEK_DISCOUNT_PER_TYPE;
import static org.assertj.core.api.Assertions.assertThat;

class WeekDayDiscountTest {

    @Test
    @DisplayName("평일 할인 - 평일에 여러 주문했을 경우 ( 디저트 1개당 2023원할인 )")
    void createWeekdayDiscount_severalOrder() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("아이스크림", 1);  // Dessert
        orderItems.put("타파스", 1);
        orderItems.put("레드와인", 1);
        Order order = Order.create(orderItems);

        VisitDay weekdayVisitDay = VisitDay.create(4);// 월요일
        WeekDayDiscount weekDayDiscount = WeekDayDiscount.create(order, weekdayVisitDay);

        assertThat(weekDayDiscount.getDiscountAmount()).isEqualTo(1 * WEEK_DISCOUNT_PER_TYPE);
    }
    @Test
    @DisplayName("평일 할인 - 평일에 디저트 2개 주문했을 경우 ( 디저트 1개당 2023원할인 )")
    void createWeekdayDiscount_TwoDessert() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("초코케이크", 2);  // Dessert
        Order order = Order.create(orderItems);

        VisitDay weekdayVisitDay = VisitDay.create(3);// 일요일
        WeekDayDiscount weekDayDiscount = WeekDayDiscount.create(order, weekdayVisitDay);

        assertThat(weekDayDiscount.getDiscountAmount()).isEqualTo(2 * WEEK_DISCOUNT_PER_TYPE);
    }

    @Test
    @DisplayName("평일 할인 - 주말에 디저트 2개 주문했을 경우 할인 없음")
    void createWeekdayDiscount_NoWeekDay() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("초코케이크", 2);  // Dessert
        Order order = Order.create(orderItems);

        VisitDay weekendVisitDay = VisitDay.create(2);// 토요일
        WeekDayDiscount weekDayDiscount = WeekDayDiscount.create(order, weekendVisitDay);

        assertThat(weekDayDiscount.getDiscountAmount()).isEqualTo(DEFAULT_AMOUNT);
    }
}