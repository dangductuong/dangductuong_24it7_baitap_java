import java.util.Random;

public class Player {
    private String name;
    private int number;
    private double x, y;
    private Random random = new Random();

    public Player(String name, int number, double x, double y) {
        this.name = name;
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void move(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }
    public String getName() {
        return name;
    }

    public void kick(Ball ball) {
        double newX = random.nextDouble() * 100;
        double newY = random.nextDouble() * 50;
        ball.move(newX, newY);
    }

    public double[] getPosition() {
        return new double[]{x, y};
    }

    @Override
    public String toString() {
        return "Player " + name + " (#" + number + ") at (" + x + ", " + y + ")";
    }
}
