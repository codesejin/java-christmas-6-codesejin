package christmas.domain;

public class VisitDay {
    private int date;

    private VisitDay(int date) {
        this.date = date;
    }

    public static VisitDay create(int date) {
        return new VisitDay(date);
    }

    public int getDate() {
        return date;
    }
}
