import java.util.*;
public class PolyLine {
    private List<Point> points;

    public PolyLine() {
        points = new ArrayList<Point>();
    }

    public PolyLine(List<Point> points) {
        this.points = points;
    }

    public void appendPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public void appendPoint(Point point) {
        points.add(point);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Point aPoint : points) {
            sb.append(aPoint.toString());
        }
        sb.append("}");
        return sb.toString();
    }

    public double getLength() {
        double length = 0.0;
        for (int i = 1; i < points.size(); i++) {
            length += points.get(i - 1).distance(points.get(i));
        }
        return length;
    }
}
