//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyCircle c1 = new MyCircle(3, 4, 5);
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Circumference: " + c1.getCircumference());

        MyCircle c2 = new MyCircle(new MyPoint(7, 1), 10);
        System.out.println(c2);
        System.out.println("Distance: " + c1.distance(c2));
    }
}