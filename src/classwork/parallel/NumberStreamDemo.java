import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberStreamDemo {

    private static List<Integer> numbers = List.of(1, 3, -5, 8, 7, 2, 12, -32);
    private static ExecutorService service = Executors.newFixedThreadPool(2);

    public static void main(String ... args) throws ExecutionException, InterruptedException {
        Function<Integer, Integer> f2 = (i) -> i*i;
        Function<Integer, Integer> f3 = (i) -> i*i*i;
        final List<Integer> numbers1 = new ArrayList<>();
        final List<Integer> numbers2 = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i%2 == 0) numbers1.add(numbers.get(i));
            else numbers2.add(numbers.get(i));
        }
        System.out.println(numbers.toString());
        System.out.println(numbers1.toString());
        System.out.println(numbers2.toString());
        Future<List<Integer>> f1 =service.submit(new Callable() {
            public List<Integer> call() {
                return numbers1.stream().map(f2).collect(Collectors.toList());
            }
        });

        List<Integer> numbers11 = f1.get();
        System.out.println(numbers11.toString());
        Future<List<Integer>> f22 =service.submit(new Callable() {
            public List<Integer> call() {
                return numbers2.stream().map(f3).collect(Collectors.toList());
            }
        });
        List<Integer> numbers22 = f22.get();
        System.out.println(numbers22.toString());
        List<Integer> numbersResult = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i%2 == 0) numbersResult.add(numbers11.get(i/2));
            else numbersResult.add(numbers22.get(i/2));
        }
        System.out.println(numbersResult.toString());
    }
}
