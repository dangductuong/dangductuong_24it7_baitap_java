//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("Circle Perimeter: " + circle.getPerimeter());
        System.out.println("Circle Area: " + circle.getArea());

        ResizableCircle resizableCircle = new ResizableCircle(10.0);
        System.out.println("Original Radius: " + resizableCircle.getRadius());
        System.out.println("Original Perimeter: " + resizableCircle.getPerimeter());
        System.out.println("Original Area: " + resizableCircle.getArea());

        resizableCircle.resize(50);
        System.out.println("After resizing by 50%");
        System.out.println("New Radius: " + resizableCircle.getRadius());
        System.out.println("New Perimeter: " + resizableCircle.getPerimeter());
        System.out.println("New Area: " + resizableCircle.getArea());
    }
}