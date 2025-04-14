import java.io.*;
public class Main {
    public static void main(String[] args) {
        GhiLogThread log = new GhiLogThread("log.txt", "Đây là một thông điệp log.");
        log.start();
    }
}