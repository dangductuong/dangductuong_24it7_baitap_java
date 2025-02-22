//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Point2D p2d = new Point2D(3.0f, 4.0f);
        System.out.println("Point2D: " + p2d);

        Point3D p3d = new Point3D(3.0f, 4.0f, 5.0f);
        System.out.println("Point3D: " + p3d);

        p3d.setXYZ(7.0f, 8.0f, 9.0f);
        System.out.println("Updated Point3D: " + p3d);
    }
}