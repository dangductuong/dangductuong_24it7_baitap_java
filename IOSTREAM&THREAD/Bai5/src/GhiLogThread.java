import java.io.*;
import java.time.LocalDateTime;

public class GhiLogThread extends Thread {
    private String tenFile;
    private String thongDiep;

    public GhiLogThread(String tenFile, String thongDiep) {
        this.tenFile = tenFile;
        this.thongDiep = thongDiep;
    }

    @Override
    public void run() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(tenFile, true))) {
            writer.println(LocalDateTime.now() + " - " + thongDiep);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}