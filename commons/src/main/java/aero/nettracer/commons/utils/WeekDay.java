package aero.nettracer.commons.utils;

public enum WeekDay {

    SUN("SUN","Sunday"),
    MON("MON","Monday"),
    TUE("TUE", "Tuesday"),
    WED("WED","Wednesday"),
    THU("THU","Thursday"),
    FRI("FRI","Friday"),
    SAT("SAT","Saturday");

    private final String shortDay;
    private final String dayOfTheWeek;

    WeekDay(String shortDay, String dayOfTheWeek) {
        this.shortDay = shortDay;
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public String getShortDay() {
        return shortDay;
    }
}
