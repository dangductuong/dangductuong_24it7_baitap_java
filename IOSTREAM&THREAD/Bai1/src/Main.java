//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String filePath = "filethread.txt";
        FileReadThread fileReadThread = new FileReadThread(filePath);
        fileReadThread.start();
    }
}