import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class Main {
    public static void main(String[] args) {
        FileProcessor.ReaderThread reader = new FileProcessor.ReaderThread("input.txt");
        FileProcessor.ProcessorThread processor = new FileProcessor.ProcessorThread();

        reader.start();
        processor.start();

    }
}