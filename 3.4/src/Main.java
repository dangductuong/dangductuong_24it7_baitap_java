//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyTime time = new MyTime(23, 59, 59);
        System.out.println("Current Time: " + time);

        time.nextSecond();
        System.out.println("After nextSecond(): " + time);

        time.previousSecond();
        System.out.println("After previousSecond(): " + time);

        time.nextMinute();
        System.out.println("After nextMinute(): " + time);

        time.previousMinute();
        System.out.println("After previousMinute(): " + time);

        time.nextHour();
        System.out.println("After nextHour(): " + time);

        time.previousHour();
        System.out.println("After previousHour(): " + time);

        try {
            time.setTime(25, 61, 61);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}