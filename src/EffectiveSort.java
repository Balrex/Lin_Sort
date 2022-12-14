import java.io.File;
import java.util.Arrays;

public class EffectiveSort<T extends Comparable<T>> implements Comparable<T> {
    T tmp;
    T tmp2;
    int[] mas_int = new int[1];
    char[] mas_char = new char[1];
    double[] mas_double = new double[1];
    String[] mas_string = new String[1];
    Object[] mas_object = new Object[1];

    public EffectiveSort(){
    }


    private void interpret(int[] arr) {
        this.mas_int = arr;
        int size = arr.length;
        this.mas_object = Arrays.copyOf(mas_object, size);
        for (int i = 0; i < size; i++) {
            this.mas_object[i] = (int) arr[i];
        }
    }

    private void interpret(char[] arr) {
        this.mas_char = arr;
        int size = arr.length;
        this.mas_object = Arrays.copyOf(mas_object, size);
        for (int i = 0; i < size; i++) {
            this.mas_object[i] = (char) arr[i];
        }
    }

    private void interpret(String[] arr) {
        this.mas_string = arr;
        int size = arr.length;
        this.mas_object = Arrays.copyOf(mas_object, size);
        for (int i = 0; i < size; i++) {
            this.mas_object[i] = (String) arr[i];
        }
    }

    private void interpret(double[] arr) {
        this.mas_double = arr;
        int size = arr.length;
        this.mas_object = Arrays.copyOf(mas_object, size);
        for (int i = 0; i < size; i++) {
            this.mas_object[i] = (double) arr[i];
        }
    }

    // -------------------------------------------------------------------------------
    private void return_int() {
        for (int i = 0; i < mas_object.length; i++) {
            mas_int[i] = (int) mas_object[i];
        }
    }

    private void return_char() {
        for (int i = 0; i < mas_object.length; i++) {
            mas_char[i] = (char) mas_object[i];
        }
    }

    private void return_String() {
        for (int i = 0; i < mas_object.length; i++) {
            mas_string[i] = (String) mas_object[i];
        }
    }

    private void return_double() {
        for (int i = 0; i < mas_object.length; i++) {
            mas_double[i] = (double) mas_object[i];
        }
    }

    // --------------------------------------------------------------------------------------
    public Object[] ChoiceSort(Object[] arr, int choose) {
        this.mas_object = arr;
        if (choose == 1)
            QuickSort(0, arr.length-1);
        /*else if (choose == 2)
            InsertionSort(0, arr.length);
        else
            SelectionSort(0, arr.length);*/
        return mas_object;
    }

    public Object[] Sort(Object[] arr, int first, int second, int choose) {
        this.mas_object = arr;
        if (choose == 1)
            QuickSort(first, second-1);
        /*else if (choose == 2)
            InsertionSort(first, second);
        else
            SelectionSort(first, second);*/
        return mas_object;
    }

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int[] ChoiceSort(int[] arr, int choose) {
        interpret(arr);
        if (choose == 1) {
            QuickSort(0, arr.length - 1);
            revers();
        }
        else if (choose == 2)
            return mas_int=mergeSort(arr, 0, arr.length);
        else
            return  mas_int=ShellSort(arr);
        return_int();
        return mas_int;
    }

    public int[] Sort(int[] arr, int first, int second, int choose) {
        interpret(arr);
        if (choose == 1)
            QuickSort(first, second-1);
        else if (choose == 2) {
            return mas_int=mergeSort(arr, first, second);
        }
        /*else
            SelectionSort(first, second);*/
        return_int();
        return mas_int;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public char[] ChoiceSort(char[] arr, int choose) {
        interpret(arr);
        if (choose == 1)
            QuickSort(0, arr.length-1);
        /*else if (choose == 2)
            InsertionSort(0, arr.length);
        else
            SelectionSort(0, arr.length);*/
        return_char();
        return mas_char;
    }
    public char[] Sort(char[] arr, int first, int second, int choose) {
        interpret(arr);
        if (choose == 1)
            QuickSort(first, second-1);
        /*else if (choose == 2)
            InsertionSort(first, second);
        else
            SelectionSort(first, second);*/
        return_char();
        return mas_char;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String[] ChoiceSort (String[] arr, int choose){
        interpret(arr);
        if (choose==1)
            QuickSort(0, arr.length-1);
        /*else if (choose==2)
            InsertionSort(0, arr.length);
        else
            SelectionSort(0, arr.length);*/
        return_String();
        return mas_string;
    }
    public String[] Sort (String[] arr, int first, int second, int choose){
        interpret(arr);
        if (choose==1)
            QuickSort(first, second-1);
        /*else if (choose==2)
            InsertionSort(first, second);
        else
            SelectionSort(first, second);*/
        return_String();
        return mas_string;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public double[] ChoiceSort (double[] arr, int choose){
        interpret(arr);
        if (choose==1)
            QuickSort(0, arr.length-1);
        /*else if (choose==2)
            InsertionSort(0, arr.length);
        else
            SelectionSort(0, arr.length);*/
        return_double();
        return mas_double;
    }
    public double[] Sort (double[] arr, int first, int second, int choose){
        interpret(arr);
        if (choose==1)
            QuickSort(first, second-1);
        /*else if (choose==2)
            InsertionSort(first, second);
        else
            SelectionSort(first, second);*/
        return_double();
        return mas_double;
    }
    // --------------------------------------------------------------------------------------
    //быстрая сортировка
    public void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int opora = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
            while (array[j] > opora) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
        array=change(array);
    }

    public int[] change(int[] arr) {
        for (int i=0; i<arr.length-1;++i)
            for (int j=i+1; j<arr.length; ++j){
                if (arr[i]%2==0 && arr[j]%2==0 && arr[i]<arr[j]){
                    int tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                }
            }
        return arr;
    }

    //быстрая сортировка
    public void QuickSort(int first, int second){
        if (mas_object.length==0)
            return;
        if (first>=second)
            return;
        int middle = first+(second-first)/2;
        tmp = (T) mas_object[middle];
        int i=first, j=second;
        while (i<=j){
            tmp2=(T) mas_object[i];
            while (tmp.compareTo(tmp2)<0){
                i++;
                tmp2=(T) mas_object[i];
            }
            tmp2=(T) mas_object[j];
            while (tmp.compareTo(tmp2)>0){
                j--;
                tmp2=(T) mas_object[j];
            }
            if(i<=j){
                tmp2=(T) mas_object[i];
                mas_object[i]=mas_object[j];
                mas_object[j]=tmp2;
                ++i;
                --j;
            }
        }

        if (first<j)
            QuickSort(first, j);
        if(second>i)
            QuickSort(i, second);
    }

    private void revers () {
        for (int l = 0; l < mas_object.length / 2; ++l) {
            tmp = (T) mas_object[l];
            mas_object[l] = mas_object[mas_object.length - l - 1];
            mas_object[mas_object.length - l - 1] = tmp;
        }
    }
    //сортировка слиянием
    private int[] mergeSort(int[] a, int first, int second) {
        if ((second-first) < 2) {
            return null;
        }
        int mid = (second-first) / 2;
        int[] l = new int[mid];
        int[] r = new int[(second-first) - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < (second-first); i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l,0, mid);
        mergeSort(r, mid, second-first);

        merge(a, l, r, mid, (second-first) - mid);
        return a;
    }
    private void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    //сортировка Шелла
    public int[] ShellSort(int arrayToSort[]) {
        int n = arrayToSort.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int tmp = arrayToSort[i];
                int j = i;
                for( j = i; j >= gap && tmp<arrayToSort[ j - gap ]; j -= gap )
                    arrayToSort[j] = arrayToSort[j - gap];
                arrayToSort[j] = tmp;
            }
        }
        return arrayToSort;
    }
    @Override
    public int compareTo(T o) {return 0;    }
}
