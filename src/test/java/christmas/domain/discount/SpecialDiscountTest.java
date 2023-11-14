package christmas.domain.discount;


import christmas.domain.VisitDay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static christmas.utils.Constants.DEFAULT_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;

class SpecialDiscountTest {
    @Test
    @DisplayName("스페셜 할인 - 달력에 별표시 있는 날짜에 방문하는 경우")
    void createSpecialDiscountWithStar() {

        VisitDay discountVisitDay = VisitDay.create(3);

        SpecialDiscount specialDiscount = SpecialDiscount.create(discountVisitDay);

        assertThat(specialDiscount.getDiscountAmount()).isEqualTo(1000);
    }

    @Test
    @DisplayName("스페셜 할인 - 달력에 별표시 없는 날짜에 방문하는 경우")
    void createSpecialDiscountWithoutStar() {

        VisitDay discountVisitDay = VisitDay.create(15);

        SpecialDiscount specialDiscount = SpecialDiscount.create(discountVisitDay);

        assertThat(specialDiscount.getDiscountAmount()).isEqualTo(DEFAULT_AMOUNT);
    }
}