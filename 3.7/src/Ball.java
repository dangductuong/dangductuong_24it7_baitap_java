public class Ball {
    private double x, y;

    public Ball(double x, double y) {
            this.x = x;
            this.y = y;
    }

    public void move(double newX, double newY) {
            this.x = newX;
            this.y = newY;
    }

    public double[] getPosition() {
            return new double[]{x, y};
    }

    @Override
    public String toString() {
        return "Ball Position: (" + x + ", " + y + ")";
    }
}
