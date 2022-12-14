import java.util.Arrays;
import static org.testng.AssertJUnit.assertEquals;

public class TestLinSort {
    public static void main(String[] args) throws InterruptedException {
        LinSort sort1 = new LinSort();
        EffectiveSort sort2 = new EffectiveSort();
        int[] arr = new int[10000];
        int[] arr_1 = new int[10000];
        int[] arr_2 = new int[10000];
        for (int i = 0; i < 10000; ++i)
            arr[i] = (int) (100 * Math.random());
        System.arraycopy(arr, 0, arr_1, 0, arr.length);
        System.arraycopy(arr, 0, arr_2, 0, arr.length);
        long start = System.currentTimeMillis();
        arr_1 = sort1.ChoiceSort(arr_1, 1);
        long middle = System.currentTimeMillis();
        arr_2 = sort2.ChoiceSort(arr_2, 3);
        long finish = System.currentTimeMillis();
        start=middle-start;
        finish=finish-middle;
        System.out.println("Сортировка подстчетов выполнилась за "+start+" мс.");
        System.out.println("Сортировка Шелла выполнилась за "+finish+" мс.");
//        for (int i = 0; i < arr_2.length; ++i)
//            System.out.println("arr[" + (i+1) + "]=" + arr_2[i]);
    }
}
