package christmas.domain;


import java.util.Map;

public class Order {

    private final Map<String, Integer> order;
    private final int orderAmount;

    private Order(Map<String, Integer> order) {
        this.order = order;
        this.orderAmount = orderAmount(order);
    }

    public static Order create(Map<String, Integer> order) {
        return new Order(order);
    }

    public static int orderAmount(Map<String, Integer> order) {
        int totalAmount = order.entrySet().stream()
                .mapToInt(entry -> Menu.checkMenu(entry.getKey()).getPrice() * entry.getValue())
                .sum();
        return totalAmount;
    }


    public Map<String, Integer> getOrder() {
        return order;
    }

    public int getOrderAmount() {
        return orderAmount;
    }
}
