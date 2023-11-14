package christmas.domain.discount;

import christmas.domain.VisitDay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DDayDiscountTest {

    @Test
    @DisplayName("크리스마스 디데이 할인 이벤트 - 2023년 12월 1일")
    void createDDayDiscountWith1Day() {
        VisitDay validDate = VisitDay.create(1);// 2023년 12월 1일
        DDayDiscount dDayDiscount = DDayDiscount.create(validDate);
        assertThat(dDayDiscount.getDiscountAmount()).isEqualTo(1000);
    }

    @Test
    @DisplayName("크리스마스 디데이 할인 이벤트 - 2023년 12월 2일")
    void createDDayDiscountWith2Day() {
        VisitDay validDate = VisitDay.create(2);// 2023년 12월 1일
        DDayDiscount dDayDiscount = DDayDiscount.create(validDate);
        assertThat(dDayDiscount.getDiscountAmount()).isEqualTo(1100);
    }


    @Test
    @DisplayName("크리스마스 디데이 할인 이벤트 - 2023년 12월 25일")
    void createDDayDiscountWith25Day() {
        VisitDay validDate = VisitDay.create(25);// 2023년 12월 1일
        DDayDiscount dDayDiscount = DDayDiscount.create(validDate);
        assertThat(dDayDiscount.getDiscountAmount()).isEqualTo(3400);
    }

    @Test
    @DisplayName("크리스마스 디데이 할인 이벤트 - 2023년 12월 26일")
    void createDDayDiscountWith26Day() {
        VisitDay validDate = VisitDay.create(26);// 2023년 12월 1일
        DDayDiscount dDayDiscount = DDayDiscount.create(validDate);
        assertThat(dDayDiscount.getDiscountAmount()).isEqualTo(0);
    }
}