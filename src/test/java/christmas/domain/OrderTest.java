package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static christmas.domain.Order.orderAmount;
import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {
    @Test
    @DisplayName("Order 객체 생성 - 주문 아이템 2개 각각 하나씩 일 경우 경우")
    void createOrderWithTwoItems() {
        // given
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("양송이수프", 1);
        orderItems.put("타파스", 1);

        int orderAmount = Menu.양송이수프.getPrice() + Menu.타파스.getPrice();

        // when
        Order order = Order.create(orderItems);
        // then
        assertThat(order.getOrder()).isEqualTo(orderItems);
        assertThat(order.getOrderAmount()).isEqualTo(orderAmount);
    }

    @Test
    @DisplayName("Order 객체 생성 - 주문 여러 개일 경우 경우")
    void createOrderWithSeveralItems() {
        // given
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("양송이수프", 3);
        orderItems.put("레드와인", 1);
        orderItems.put("타파스",1);

        int orderAmount = (Menu.양송이수프.getPrice() * 3) + (Menu.레드와인.getPrice() * 1) + (Menu.타파스.getPrice() * 1);

        // when
        Order order = Order.create(orderItems);
        // then
        assertThat(order.getOrder()).isEqualTo(orderItems);
        assertThat(order.getOrderAmount()).isEqualTo(orderAmount);
    }

    @Test
    @DisplayName("Order 객체 생성 - 주문을 아무것도 안했을 경우")
    void createOrderWithEmptyOrderAndGetOrderAmount() {
        // given
        Map<String, Integer> emptyOrder = new HashMap<>();

        // when
        Order order = Order.create(emptyOrder);

        // then
        assertThat(order.getOrder()).isEqualTo(emptyOrder);
        assertThat(order.getOrderAmount()).isEqualTo(0);
    }

    @Test
    @DisplayName("orderAmount 메서드 - 총 주문 금액")
    void orderAmountSum() {
        // given
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("양송이수프", 3);
        orderItems.put("레드와인", 1);
        orderItems.put("타파스",1);

        int sum = (Menu.양송이수프.getPrice() * 3) + (Menu.레드와인.getPrice() * 1) + (Menu.타파스.getPrice() * 1);

        assertThat(orderAmount(orderItems)).isEqualTo(sum);
    }
}