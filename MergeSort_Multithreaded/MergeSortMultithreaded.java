import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;
import java.util.Scanner;

public class MergeSortMultithreaded {

    public static class MergeTask extends RecursiveTask<List<Long>> {
        private static final int THRESHOLD = 3; //nie dzielimy listy gdy będzie mniejsza niż 2
        private final List<Long> list;

        public MergeTask(List<Long> list) {
            this.list = list;
        }

        @Override
        protected List<Long> compute() {
            if (list.size() < THRESHOLD) {
                return list.stream().sorted().collect(toList());
            }

            MergeTask left = new MergeTask(list.stream().limit(list.size()/2).collect(toList()));
            MergeTask right = new MergeTask(list.stream().skip(list.size()/2).collect(toList()));
            invokeAll(left, right);

            return merge(left.join(), right.join());
        }
    }

    public static List<Long> merge(List<Long> a, List<Long> b) {
        int i=0, j=0;
        List<Long> result = new ArrayList<>(a.size() + b.size());
        while(i < a.size() && j < b.size())
            result.add(a.get(i) < b.get(j) ? a.get(i++): b.get(j++));

        while(i < a.size())
            result.add(a.get(i++));

        while(j < b.size())
            result.add(b.get(j++));

        return result;
    }



    public static Long[] generateRandomArray(int length) {
        Random random = new Random();
        Long[] array = new Long[length];
        for(int i = 0;i<length;i++){
            array[i] = Long.valueOf(random.nextInt(1000));
        }
        return array;
    }




    public static void main(String[] args) {

        System.out.println("Wprowadź, ile wątków chcesz użyć:");;
        Scanner scanner = new Scanner(System.in);
        int number_of_threads = scanner.nextInt();
        System.out.println(number_of_threads);


        Long[] array = generateRandomArray(1000);
        List<Long> longs = asList(array); //tworzymy z listy tablicę
        System.out.println("Lista przed posortowaniem:");


        ForkJoinPool pool = new ForkJoinPool(number_of_threads);
        ForkJoinTask<List<Long>> task = new MergeTask(longs);

        long start = System.nanoTime();
        List<Long> result = pool.invoke(task); //wywołujemy nasze zadanie MergeTask
        long end = System.nanoTime();
        System.out.println("Tym razem zajęło: " + ((end - start) / 1000) + "ms." );
        pool.shutdown();


        System.out.println("Lista po posortowaniu:");
        System.out.println(result);
    }


}