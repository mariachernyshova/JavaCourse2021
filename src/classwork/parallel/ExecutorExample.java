import java.util.concurrent.*;

public class ExecutorExample {

    private static ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String ... args) throws ExecutionException, InterruptedException {
        service.execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Another thread was executed - " + Thread.currentThread().getName());
            }
        });

        service.execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Another thread was executed - " + Thread.currentThread().getName());
            }
        });

        service.execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Another thread was executed - " + Thread.currentThread().getName());
            }
        });

        service.execute(new Runnable() {
            public void run() {
                System.out.println("Another thread was executed - " + Thread.currentThread().getName());
            }
        });

        Future future = service.submit(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Another thread was executed");
            }
        });
        future.get();

        future = service.submit(new Callable(){
            public Object call() throws Exception {
                Thread.sleep(10000);
                System.out.println("Another thread was executed");
                return "result";
            }
        });
        System.out.println("Result: " + future.get());
    }
}
