package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountTest {

    private Order order;
    private VisitDay visitDay;

    @BeforeEach
    void setUp() {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("타파스",1);
        orderItems.put("해산물파스타",2);
        orderItems.put("아이스크림",2);
        orderItems.put("샴페인",1);
        order = Order.create(orderItems);
        visitDay = VisitDay.create(3);
    }

    @Test
    @DisplayName("Discount 객체 - 모든 할인이 다 적용되서 참조되는지 테스트")
    public void createDiscount() {
        Discount discount = Discount.create(order, visitDay);
        assertThat(discount.getdDayDiscount().getDiscountAmount()).isEqualTo(1200);
        assertThat(discount.getWeekDayDiscount().getDiscountAmount()).isEqualTo(4046);
        assertThat(discount.getWeekendDiscount().getDiscountAmount()).isEqualTo(0);
        assertThat(discount.getSpecialDiscount().getDiscountAmount()).isEqualTo(1000);
        assertThat(discount.getGift().getDiscountAmount()).isEqualTo(0);
    }

    @Test
    @DisplayName("총 할인 가격이 얼마인지 테스트")
    public void totalDiscount() {
        Discount discount = Discount.create(order, visitDay);
        assertThat(discount.totalDiscount()).isEqualTo(6246);
    }
}