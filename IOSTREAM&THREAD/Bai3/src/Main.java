public class Main {
    public static void main(String[] args) {
            FileCopyThread thread = new FileCopyThread("nguon.txt", "dich.txt");
            thread.start();
        }
    }
