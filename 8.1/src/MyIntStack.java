public class MyIntStack {
    private int[] contents;
    private int tos;

    public MyIntStack(int capacity) {
        contents = new int[capacity];
        tos = -1;
    }

    public int push(int element) {
        contents[++tos] = element;
        return element;
    }

    public int pop() {
        return contents[tos--];
    }

    public int peek() {
        return contents[tos];
    }

    public boolean isEmpty() {
        return tos < 0;
    }

    public boolean isFull() {
        return tos == contents.length - 1;
    }
    private void resize() {
        int newSize = contents.length * 2;
        int[] newContents = new int[newSize];
        System.arraycopy(contents, 0, newContents, 0, contents.length);
        contents = newContents;
    }
}