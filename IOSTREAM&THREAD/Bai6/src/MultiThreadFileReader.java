import java.io.RandomAccessFile;

public class MultiThreadFileReader {
    static class ReaderThread extends Thread {
        private String fileName;
        private long start;
        private long length;

        public ReaderThread(String fileName, long start, long length) {
            this.fileName = fileName;
            this.start = start;
            this.length = length;
        }

        @Override
        public void run() {
            try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
                raf.seek(start);
                byte[] buffer = new byte[(int) length];
                raf.read(buffer);
                System.out.println(Thread.currentThread().getName() + ": " + new String(buffer).trim());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}