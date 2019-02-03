import Sorting.insertion;
import java.util.Arrays;

public class testing {

    public static void main(String[] args) {
        Integer[] unsorted = {1, 5, 3, 7, 9};
        System.out.println("unsorted array: " + Arrays.toString(unsorted));

        Integer[] sorted = insertion.insertionSort(unsorted);
        System.out.println("Sorted wth insertionSOrt: " + Arrays.toString(sorted));

        System.out.println("Hello World");
    }
}
