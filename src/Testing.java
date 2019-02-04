import Sorting.Insertion;
import Sorting.Merge;
import java.util.Arrays;

public class Testing {

    public static void main(String[] args) {
        Integer[] unsorted = {1, 5, 3, 7, 9};
        System.out.println("unsorted array: " + Arrays.toString(unsorted));

        Insertion.sort(unsorted);
        System.out.println("Sorted wth insertionSort: " + Arrays.toString(unsorted));


        Integer[] unsorted2 = {1, 5, 3, 7, 9, 12, 14, 3};
        System.out.println("unsorted array: " + Arrays.toString(unsorted2));

        Merge.sort(unsorted2);
        System.out.println("Sorted wth mergeSort: " + Arrays.toString(unsorted2));

    }
}
