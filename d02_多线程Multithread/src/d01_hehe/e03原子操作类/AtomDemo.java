package d01_hehe.e03原子操作类;

public class AtomDemo {
    public static void main(String[] args) {
        MyAtomThread myAtomThread = new MyAtomThread();

        for (int i = 0; i < 100; i++) {
            new Thread(myAtomThread).start();
        }
    }
}
