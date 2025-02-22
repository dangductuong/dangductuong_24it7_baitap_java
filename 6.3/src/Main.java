//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 5,5);
        point.displayPosition();
        point.moveUp();
        point.displayPosition();
        point.moveRight();
        point.displayPosition();
        point.moveDown();
        point.displayPosition();
        point.moveLeft();
        point.displayPosition();
    }
}