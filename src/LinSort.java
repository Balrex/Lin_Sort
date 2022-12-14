import java.util.Arrays;

public class LinSort {

    int size=1;
    int mas[]=new int[size];
    public LinSort(){}

    public int[] ChoiceSort(int[] arr, int choose) {
        this.size=arr.length;
        this.mas=Arrays.copyOf(arr, arr.length);
        if (choose == 1)
            mas=CountingSort(mas);
        else if (choose == 2)
            mas=LSDsort(mas);
        /*else
            SelectionSort(0, arr.length);*/
        return mas;
    }

    //сортировка подсчётом
    private int[] CountingSort(int[] input) {
        int max=findMaximumNumberIn(input);
        int[] c = countElements(input, max);
        int[] sorted = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            int current = input[i];
            sorted[c[current] - 1] = current;
            c[current] -= 1;
        }

        return sorted;
    }
    //создадем частотный массив
    private int[] countElements(int[] input, int k) {
        int[] c = new int[k+1];
        Arrays.fill(c, 0);
        for (int i : input) {
            c[i] += 1;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        return c;
    }
    public int findMaximumNumberIn(int[] input) {
        int max=0;
        for (int i=0; i<input.length; ++i)
            if (input[i]>max)
                max=input[i];
        return max;
    }
    //сортировка LSD
    private int[] LSDsort(int[] mas) {
        int maximumNumber = findMaximumNumberIn(mas); // максимальный элемент в массиве
        int numberOfDigits = String.valueOf(maximumNumber).length(); // количество числен в нем
        int placeValue = 1;
        while (numberOfDigits-- > 0) {
            mas=applyCountingSortOn(mas, placeValue);
            placeValue *= 10;
        }
        return mas;
    }

    private int[] applyCountingSortOn(int[] input, int placeValue) {
        int[] c=new int[10];
        Arrays.fill(c, 0);
        for (int i = 0; i < input.length; i++) {
            int digit = (input[i] / placeValue) % 10;
            c[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            c[i] += c[i - 1];
        }
        int[] result=new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            int digit = (input[i] / placeValue) % 10;
            result[c[digit]-1]=input[i];
            c[digit]-=1;
        }
        //System.out.println(Arrays.toString(result));
        return result;
    }
}
