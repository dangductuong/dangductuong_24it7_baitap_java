//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String fileName = "output.txt";

        Thread thread1 = new FileWriterThread(fileName, "Xin chào từ luồng 1!");
        Thread thread2 = new FileWriterThread(fileName, "Chào mừng từ luồng 2!");

        thread1.start();
        thread2.start();
    }
}