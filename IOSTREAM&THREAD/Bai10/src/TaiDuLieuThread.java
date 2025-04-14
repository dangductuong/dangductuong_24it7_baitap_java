import java.io.*;
import java.net.URL;

public class TaiDuLieuThread extends Thread {
    private String url;
    private String tenFile;

    public TaiDuLieuThread(String url, String tenFile) {
        this.url = url;
        this.tenFile = tenFile;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
             PrintWriter writer = new PrintWriter(new FileWriter(tenFile))) {
            String dong;
            while ((dong = reader.readLine()) != null) {
                writer.println(dong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}