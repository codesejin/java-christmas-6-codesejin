package christmas.domain.discount;

import christmas.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static christmas.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;

class GiftTest {

    @Test
    @DisplayName("GIFT 객체 생성 - 12만원 이상 주문했을 경우 샴페인 1개 증정")
    void createWithGift() {
        // given
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("레드와인", 4);
        orderItems.put("타파스",1);
        Order order = Order.create(orderItems);
        //when
        Gift gift = Gift.create(order);
        //then
        assertThat(gift.getGift()).isEqualTo(GIFT);
        assertThat(gift.getDiscountAmount()).isEqualTo(GIFT_AMOUNT);
    }
    @Test
    @DisplayName("GIFT 객체 생성 - 12만원 이상 주문하지 않았을 경우")
    void createWithoutGift() {
        // given
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put("타파스",1);
        Order order = Order.create(orderItems);
        //when
        Gift gift = Gift.create(order);
        //then
        assertThat(gift.getGift()).isEqualTo(NOTHING);
        assertThat(gift.getDiscountAmount()).isEqualTo(DEFAULT_AMOUNT);
    }
}