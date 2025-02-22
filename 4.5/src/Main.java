//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape("red", false);
        System.out.println(shape);

        Circle circle = new Circle(2.5, "blue", true);
        System.out.println(circle);
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Circle perimeter: " + circle.getPerimeter());

        Rectangle rectangle = new Rectangle(2.0, 4.0, "yellow", false);
        System.out.println(rectangle);
        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());

        Square square = new Square(3.0, "purple", true);
        System.out.println(square);
        System.out.println("Square area: " + square.getArea());
        System.out.println("Square perimeter: " + square.getPerimeter());
    }
}