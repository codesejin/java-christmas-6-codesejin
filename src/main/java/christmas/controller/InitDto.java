package christmas.controller;

import christmas.domain.Order;
import christmas.domain.VisitDay;

public class InitDto {

    private final Order order;
    private final VisitDay visitDay;

    private InitDto(Order order, VisitDay visitDay) {
        this.order = order;
        this.visitDay = visitDay;
    }

    public static InitDto create(Order order, VisitDay visitDay) {
        return new InitDto(order, visitDay);
    }

    public Order getOrder() {
        return order;
    }

    public VisitDay getVisitDay() {
        return visitDay;
    }
}
