import java.util.*;

public class MyDate {
    private int year, month, day;

    private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    public void setDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12) {
            return false;
        }
        int daysInMonth = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            daysInMonth = 29;
        }
        return day >= 1 && day <= daysInMonth;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }

    public void setYear(int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Invalid year!");
        }
        this.year = year;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month!");
        }
        this.month = month;
    }

    public void setDay(int day) {
        if (!isValidDate(this.year, this.month, day)) {
            throw new IllegalArgumentException("Invalid day!");
        }
        this.day = day;
    }

    public MyDate nextDay() {
        if (isValidDate(year, month, day + 1)) {
            day++;
        } else if (isValidDate(year, month + 1, 1)) {
            month++;
            day = 1;
        } else {
            year++;
            month = 1;
            day = 1;
        }
        return this;
    }

    public MyDate previousDay() {
        if (isValidDate(year, month, day - 1)) {
            day--;
        } else if (month > 1) {
            month--;
            day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) {
                day = 29;
            }
        } else {
            year--;
            month = 12;
            day = 31;
        }
        return this;
    }

    public MyDate nextMonth() {
        if (month == 12) {
            month = 1;
            year++;
        } else {
            month++;
        }
        day = Math.min(day, DAYS_IN_MONTHS[month - 1]);
        if (month == 2 && isLeapYear(year)) {
            day = 29;
        }
        return this;
    }

    public MyDate previousMonth() {
        if (month == 1) {
            month = 12;
            year--;
        } else {
            month--;
        }
        day = Math.min(day, DAYS_IN_MONTHS[month - 1]);
        if (month == 2 && isLeapYear(year)) {
            day = 29;
        }
        return this;
    }

    public MyDate nextYear() {
        if (year + 1 > 9999) {
            throw new IllegalStateException("Year out of range!");
        }
        year++;
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }

    public MyDate previousYear() {
        year--;
        if (month == 2 && day == 29 && !isLeapYear(year)) {
            day = 28;
        }
        return this;
    }

    public String toString() {
        return DAYS[getDayOfWeek(year, month, day)] + " " + day + " " + MONTHS[month - 1] + " " + year;
    }
}
