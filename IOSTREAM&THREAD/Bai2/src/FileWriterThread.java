import java.io.*;

class FileWriterThread extends Thread {
    private String fileName;
    private String content;

    public FileWriterThread(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    @Override
    public void run() {
        synchronized (FileWriterThread.class) {
            try (FileWriter writer = new FileWriter(fileName, true)) {
                writer.write(content + "\n");
                System.out.println(Thread.currentThread().getName() + " ghi xong dữ liệu.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}