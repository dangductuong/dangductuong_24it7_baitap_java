import java.io.*;

class FileReadThread extends Thread {
    private String filePath;

    public FileReadThread(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}