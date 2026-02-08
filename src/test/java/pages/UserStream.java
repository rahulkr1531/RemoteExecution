package pages;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UserStream {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 1, 6, 2);
        Stream<Integer> stream = list.stream();

        //EvenNumbers

        Stream<Integer> integerStream = list.stream().filter(x -> x % 2 == 0);
        int count = (int) list.stream().filter(x -> x % 2 == 0).count();
        System.out.println(integerStream);
        String z = "hello hello";
        Integer[] a = {2,2, 4, 7, 9, 5,5};
        int sum=0;

    }

    static Integer cumulativeSum(Integer[] a, Integer x) {
        int m = Arrays.asList(a).indexOf(x);
        int sum = 0;
        for (int i = 0; i <= m; i++) {
            if (m > a.length)
                return 0;
            sum = sum + a[i];

        }
        return sum;
    }

}
