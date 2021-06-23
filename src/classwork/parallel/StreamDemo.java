import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main (String ... args) {
        Function<String, Integer> f = (s) -> {return Integer.parseInt(s);};
        Function<String, String> f1 = (s) -> {return Integer.decode(s).getClass().getName();};
        Function<String, Integer> f2 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        };
        List<String> list = new ArrayList<>();
        list.add("0"); list.add("1");list.add("-1");
        System.out.println(list.toString());
        System.out.println(list.stream().map(f).collect(Collectors.toList()).toString());
        System.out.println(list.stream().map(f1).collect(Collectors.toList()).toString());
    }

    public Integer toInt(String s) {
        return Integer.valueOf(s);
    }

}
