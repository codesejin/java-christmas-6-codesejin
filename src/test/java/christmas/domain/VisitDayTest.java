package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VisitDayTest {

    @Test
    @DisplayName("VisitDay 생성 및 요일 확인 - 금요일")
    void createVisitDayAndCheckDayOfWeek_Monday() {
        VisitDay visitDay = VisitDay.create(1); // 2023년 12월 1일은 금요일

        assertThat(visitDay.getDate()).isEqualTo(1);
        assertThat(visitDay.getDayOfMonth()).isEqualTo(VisitDay.DayType.WEEKEND);
    }

    @Test
    @DisplayName("VisitDay 생성 및 요일 확인 - 일요일")
    void createVisitDayAndCheckDayOfWeek_Saturday() {
        VisitDay visitDay = VisitDay.create(3); // 2023년 12월 3일은 일요일

        assertThat(visitDay.getDate()).isEqualTo(3);
        assertThat(visitDay.getDayOfMonth()).isEqualTo(VisitDay.DayType.WEEKDAY);
    }

    @Test
    @DisplayName("VisitDay 생성 및 요일 확인 - 월요일")
    void createVisitDayAndCheckDayOfWeek_Sunday() {
        VisitDay visitDay = VisitDay.create(4); // 2023년 12월 4일은 월요일

        assertThat(visitDay.getDate()).isEqualTo(4);
        assertThat(visitDay.getDayOfMonth()).isEqualTo(VisitDay.DayType.WEEKDAY);
    }
}