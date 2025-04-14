import java.io.*;

public class FileCopyThread extends Thread {
    private String fileNguon;
    private String fileDich;

    public FileCopyThread(String fileNguon, String fileDich) {
        this.fileNguon = fileNguon;
        this.fileDich = fileDich;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileNguon));
             FileWriter fw = new FileWriter(fileDich)) {
            String dong;
            while ((dong = br.readLine()) != null) {
                fw.write(dong + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

