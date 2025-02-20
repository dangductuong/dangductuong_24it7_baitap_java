import java.util.Random;

public class SoccerGame {
    private Ball ball;
    private Player[] team1;
    private Player[] team2;
    private Random random = new Random();

    public SoccerGame() {
        ball = new Ball(50, 25);
        team1 = new Player[5];
        team2 = new Player[5];

        for (int i = 0; i < 5; i++) {
            team1[i] = new Player("Player" + (i + 1), i + 1, random.nextDouble() * 50, random.nextDouble() * 50);
            team2[i] = new Player("Player" + (i + 6), i + 6, 50 + random.nextDouble() * 50, random.nextDouble() * 50);
        }
    }

    public void play() {
        System.out.println("Starting Soccer Game!");
        System.out.println(ball);

        for (int i = 0; i < 5; i++) {
            Player player = random.nextBoolean() ? team1[random.nextInt(5)] : team2[random.nextInt(5)];
            System.out.println(player.getName() + " kicks the ball!");
            player.kick(ball);
            System.out.println(ball);
        }

        System.out.println("Game Over!");
    }
}
