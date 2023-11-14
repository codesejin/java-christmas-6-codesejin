package christmas.domain;

public enum BadgeType {

    STAR("별",5000),
    TREE("트리",10000),
    SANTA("산타",20000);

    private final String name;
    private final int badgeLimit;

    BadgeType(String name,int badgeLimit) {
        this.name = name;
        this.badgeLimit = badgeLimit;
    }

    public String getName() {
        return name;
    }

    public int getBadgeLimit() {
        return badgeLimit;
    }
}
