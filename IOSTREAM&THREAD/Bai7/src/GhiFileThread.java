import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class GhiFileThread extends Thread {
    private String tenFile;

    public GhiFileThread(String tenFile) {
        this.tenFile = tenFile;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in);
             PrintWriter writer = new PrintWriter(new FileWriter(tenFile, true))) {
            System.out.println("Nhập dữ liệu (gõ 'exit' để thoát):");
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) break;
                writer.println(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}