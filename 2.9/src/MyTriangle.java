public class MyTriangle {
    private MyPoint v1, v2, v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1 = new MyPoint(x1, y1);
        this.v2 = new MyPoint(x2, y2);
        this.v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public void printType() {
        double d1 = v1.distance(v2);
        double d2 = v2.distance(v3);
        double d3 = v3.distance(v1);

        if (d1 == d2 && d2 == d3) {
            System.out.println("Equilateral");
        } else if (d1 == d2 || d2 == d3 || d3 == d1) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }

    public String toString() {
        return "MyTriangle[v1=" + v1 + ", v2=" + v2 + ", v3=" + v3 + "]";
    }
}
