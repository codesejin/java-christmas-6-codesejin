package christmas.domain;

import christmas.domain.discount.DDayDiscount;
import christmas.domain.discount.WeekDayDiscount;
import christmas.domain.discount.WeekendDiscount;
import christmas.domain.discount.SpecialDiscount;
import christmas.domain.discount.Gift;

public class Discount {

    private final DDayDiscount dDayDiscount;
    private final WeekDayDiscount weekDayDiscount;
    private final WeekendDiscount weekendDiscount;
    private final SpecialDiscount specialDiscount;
    private final Gift gift;

    private Discount(Order order, VisitDay visitDay) {
        this.dDayDiscount = DDayDiscount.create(visitDay);
        this.weekDayDiscount = WeekDayDiscount.create(order,visitDay);
        this.weekendDiscount = WeekendDiscount.create(order,visitDay);
        this.specialDiscount = SpecialDiscount.create(visitDay);
        this.gift = Gift.create(order);
    }

    public static Discount create(Order order, VisitDay visitDay) {
        return new Discount(order,visitDay);
    }

    public int totalDiscountWithGift() {
        return totalDiscountWithoutGift() + gift.getDiscountAmount();
    }

    public int totalDiscountWithoutGift() {
        return dDayDiscount.getDiscountAmount() +
                weekDayDiscount.getDiscountAmount()+
                weekendDiscount.getDiscountAmount()+
                specialDiscount.getDiscountAmount();
    }

    public DDayDiscount getdDayDiscount() {
        return dDayDiscount;
    }

    public WeekDayDiscount getWeekDayDiscount() {
        return weekDayDiscount;
    }

    public WeekendDiscount getWeekendDiscount() {
        return weekendDiscount;
    }

    public SpecialDiscount getSpecialDiscount() {
        return specialDiscount;
    }

    public Gift getGift() {
        return gift;
    }
}
