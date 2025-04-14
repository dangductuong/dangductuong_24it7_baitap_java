import java.io.RandomAccessFile;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "largefile.txt";
        RandomAccessFile raf = new RandomAccessFile(fileName, "r");
        long fileLength = raf.length();
        long partSize = fileLength / 2;

        MultiThreadFileReader.ReaderThread thread1 = new MultiThreadFileReader.ReaderThread(fileName, 0, partSize);
        MultiThreadFileReader.ReaderThread thread2 = new MultiThreadFileReader.ReaderThread(fileName, partSize, fileLength - partSize);

        thread1.start();
        thread2.start();
    }
}
