package christmas.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BadgeTest {

    @Test
    @DisplayName("Badge 객체 - 총 혜택 금액이 5,000 이상일때 '별' 뱃지")
    public void createBadgeForStar() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("해산물파스타",2);
        orderItems.put("아이스크림",2);
        Order order = Order.create(orderItems);
        VisitDay visitDay = VisitDay.create(3);
        Discount discount = Discount.create(order, visitDay);

        Badge badge = Badge.create(discount);
        assertThat(badge.getBadge()).isEqualTo("별");
    }

    @Test
    @DisplayName("Badge 객체 - 총 혜택 금액이 10,000 이상일때 '트리' 뱃지")
    public void createBadgeForTree() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("크리스마스파스타",4);
        Order order = Order.create(orderItems);
        VisitDay visitDay = VisitDay.create(23);
        Discount discount = Discount.create(order, visitDay);
        Badge badge = Badge.create(discount);
        assertThat(badge.getBadge()).isEqualTo("트리");
    }

    @Test
    @DisplayName("Badge 객체 - 총 혜택 금액이 20,000 이상일때 '산타' 뱃지")
    public void createBadgeForSanta() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("바비큐립",4);
        Order order = Order.create(orderItems);
        VisitDay visitDay = VisitDay.create(23);
        Discount discount = Discount.create(order, visitDay);
        Badge badge = Badge.create(discount);
        assertThat(badge.getBadge()).isEqualTo("산타");
    }
}