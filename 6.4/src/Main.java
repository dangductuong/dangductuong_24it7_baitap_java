//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(2, 3, 1, 1);
        System.out.println("Initial: " + point);
        point.moveUp();
        System.out.println("After moveUp: " + point);
        point.moveRight();
        System.out.println("After moveRight: " + point);

        MovableCircle circle = new MovableCircle(5, 5, 2, 2, 10);
        System.out.println("Initial: " + circle);
        circle.moveDown();
        System.out.println("After moveDown: " + circle);
        circle.moveLeft();
        System.out.println("After moveLeft: " + circle);
    }
}