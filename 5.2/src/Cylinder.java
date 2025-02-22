public class Cylinder extends Circle {
    private Circle base;
    private double height;
    public Cylinder() {
        super();
        this.height = 1.0;
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getHeight() {
        return height;
    }
    public void setBase(Circle base) {
        this.base = base;
    }
    public Circle getBase() {
        return base;
    }
}
