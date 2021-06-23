package classwork.sample;

class MyThread extends Thread {
    public static int index;
    public static Object obj = new Object();

    public MyThread() {
        System.out.println(getName());
    }

    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 50; i++) {
                System.out.println(getName() + ";" + index++);
            }
        }
    }
}
public class Test {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }
}
