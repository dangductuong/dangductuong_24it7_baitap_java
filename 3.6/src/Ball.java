public class Ball {
    private float x, y;
    private int radius;
    private float xDelta, yDelta;

    public Ball(float x, float y, int radius, float speed, float direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float) (speed * Math.cos(Math.toRadians(direction)));
        this.yDelta = (float) (-speed * Math.sin(Math.toRadians(direction)));
    }

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public int getRadius() { return radius; }
    public void setRadius(int radius) { this.radius = radius; }

    public float getXDelta() { return xDelta; }
    public void setXDelta(float xDelta) { this.xDelta = xDelta; }

    public float getYDelta() { return yDelta; }
    public void setYDelta(float yDelta) { this.yDelta = yDelta; }

    public void move() {
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball at (" + x + ", " + y + ") of velocity (" + xDelta + ", " + yDelta + ")";
    }
}
