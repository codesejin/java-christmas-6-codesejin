package christmas.domain.discount;

import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.VisitDay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static christmas.utils.Constants.DEFAULT_AMOUNT;
import static christmas.utils.Constants.WEEK_DISCOUNT_PER_TYPE;
import static org.assertj.core.api.Assertions.assertThat;


class WeekDiscountTest {

    private static final int WEEKDAY = 4; // 월요일
    private static final int WEEKEND = 2; // 토요일

    @ParameterizedTest
    @DisplayName("calculateDiscount 메서드 - 평일에 디저트 주문 테스트")
    @MethodSource("weekdayDessertParameters")
    public void calculateDiscount_WeekdayDessertTest(String menuName, int quantity, int expectedAmount) {
        testCalculator(WEEKDAY, Menu.MenuType.DESSERT, menuName, quantity, expectedAmount);
    }

    private static Stream<Object[]> weekdayDessertParameters() {
        return Stream.of(
                new Object[]{"타파스", 1, DEFAULT_AMOUNT},
                new Object[]{"아이스크림", 1, WEEK_DISCOUNT_PER_TYPE},
                new Object[]{"초코케이크", 3, 3 * WEEK_DISCOUNT_PER_TYPE}
        );
    }
    @ParameterizedTest
    @DisplayName("calculateDiscount 메서드 - 주말에 메인 주문 테스트")
    @MethodSource("weekendMainParameters")
    public void calculateDiscount_WeekendMainTest(String menuName, int quantity, int expectedAmount) {
        testCalculator(WEEKEND, Menu.MenuType.MAIN, menuName, quantity, expectedAmount);
    }

    private static Stream<Object[]> weekendMainParameters() {
        return Stream.of(
                new Object[]{"타파스", 1, DEFAULT_AMOUNT},
                new Object[]{"해산물파스타", 1, WEEK_DISCOUNT_PER_TYPE},
                new Object[]{"바비큐립", 3, 3 * WEEK_DISCOUNT_PER_TYPE}
        );
    }

    @ParameterizedTest
    @DisplayName("isDiscountDay - 주말인지 평일인지 검증")
    @MethodSource("discountDayParameters")
    public void isDiscountDay(int dayOfMonth, VisitDay.DayType discountDay, boolean expectedResult) {
        VisitDay visitDay = VisitDay.create(dayOfMonth);
        boolean result = WeekDiscount.isDiscountDay(visitDay, discountDay);
        assertThat(result).isEqualTo(expectedResult);
    }

    private void testCalculator(int dayOfMonth, Menu.MenuType menuType, String itemName, int quantity, int expectedAmount) {
        Map<String, Integer> orderItems = new HashMap<>();
        orderItems.put(itemName, quantity);
        Order order = Order.create(orderItems);

        VisitDay visitDay = VisitDay.create(dayOfMonth);

        int amount = WeekDiscount.calculateDiscount(order, visitDay, getDayType(dayOfMonth), menuType);
        assertThat(amount).isEqualTo(expectedAmount);
    }

    private VisitDay.DayType getDayType(int dayOfMonth) {
        if (dayOfMonth == WEEKDAY) return VisitDay.DayType.WEEKDAY;
        return VisitDay.DayType.WEEKEND;

    }

    private static Stream<Object[]> discountDayParameters() {
        return Stream.of(
                new Object[]{1, VisitDay.DayType.WEEKDAY, false},
                new Object[]{1, VisitDay.DayType.WEEKEND, true},
                new Object[]{2, VisitDay.DayType.WEEKDAY, false},
                new Object[]{2, VisitDay.DayType.WEEKEND, true},
                new Object[]{7, VisitDay.DayType.WEEKDAY, true},
                new Object[]{7, VisitDay.DayType.WEEKEND, false}
        );
    }
}
