package christmas.domain.discount;

import christmas.domain.Order;
import christmas.domain.VisitDay;
import christmas.domain.discount.WeekendDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static christmas.utils.Constants.DEFAULT_AMOUNT;
import static christmas.utils.Constants.WEEK_DISCOUNT_PER_TYPE;
import static org.assertj.core.api.Assertions.assertThat;

class WeekendDiscountTest {
    @Test
    @DisplayName("주말 할인 - 주말에 여러 주문했을 경우 ( 메인요리 1개당 2023원할인 )")
    void createWeekdayDiscount_severalOrder() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("아이스크림", 1);
        orderItems.put("바비큐립", 1); // main
        orderItems.put("레드와인", 1);
        Order order = Order.create(orderItems);

        VisitDay weekdayVisitDay = VisitDay.create(2);// 토요일
        WeekendDiscount weekendDiscount = WeekendDiscount.create(order, weekdayVisitDay);

        assertThat(weekendDiscount.getDiscountAmount()).isEqualTo(1 * WEEK_DISCOUNT_PER_TYPE);
    }
    @Test
    @DisplayName("주말 할인 - 주말에 메인요리 2개 주문했을 경우 ( 메인요리 1개당 2023원할인 )")
    void createWeekdayDiscount_TwoDessert() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("해산물파스타", 2);  // main
        Order order = Order.create(orderItems);

        VisitDay weekdayVisitDay = VisitDay.create(1);// 금요일
        WeekendDiscount weekendDiscount = WeekendDiscount.create(order, weekdayVisitDay);

        assertThat(weekendDiscount.getDiscountAmount()).isEqualTo(2 * WEEK_DISCOUNT_PER_TYPE);
    }

    @Test
    @DisplayName("주말 할인 - 평일에 메인요리 2개 주문했을 경우 할인 없음")
    void createWeekdayDiscount_NoWeekDay() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("해산물파스타", 2);  // main
        Order order = Order.create(orderItems);

        VisitDay weekDayVisitDay = VisitDay.create(3);// 일요일
        WeekendDiscount weekendDiscount = WeekendDiscount.create(order, weekDayVisitDay);

        assertThat(weekendDiscount.getDiscountAmount()).isEqualTo(DEFAULT_AMOUNT);
    }
}