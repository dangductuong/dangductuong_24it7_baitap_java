//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyTriangle t1 = new MyTriangle(0, 0, 3, 0, 3, 4);
        System.out.println(t1);
        System.out.println("Perimeter: " + t1.getPerimeter());
        t1.printType();
    }
}