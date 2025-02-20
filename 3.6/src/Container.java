public class Container {
    private int x1, y1, x2, y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x + width - 1;
        this.y2 = y + height - 1;
    }

    public boolean collidesWith(Ball ball) {
        boolean collision = false;
        if (ball.getX() - ball.getRadius() <= x1 || ball.getX() + ball.getRadius() >= x2) {
            ball.reflectHorizontal();
            collision = true;
        }
        if (ball.getY() - ball.getRadius() <= y1 || ball.getY() + ball.getRadius() >= y2) {
            ball.reflectVertical();
            collision = true;
        }
        return collision;
    }

    @Override
    public String toString() {
        return "Container at (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")";
    }
}
