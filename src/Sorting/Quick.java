package Sorting;

public class Quick implements Sort {

    private static final int CUTOFF = 10;

    public static <AnyType extends Comparable<? super AnyType>>
    void sort(AnyType[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private static <AnyType extends Comparable<? super AnyType>>
    void quicksort(AnyType[] a, int low, int high) {
        if (low + CUTOFF > high)
            Insertion.sort(a);
        else {
            int middle = (low + high) / 2;
            if (a[middle].compareTo(a[low]) < 0)
                Sort.swapReferences(a, low, middle);
            if (a[high].compareTo(a[low]) < 0)
                Sort.swapReferences(a, low, high);
            if (a[high].compareTo(a[middle]) < 0)
                Sort.swapReferences(a, middle, high);
            // Place pivot at position high - 1
            Sort.swapReferences(a, middle, high - 1);
            AnyType pivot = a[high - 1];

            int i, j;
            for (i = low, j = high - 1; ; ) {
                while (a[++i].compareTo(pivot) < 0)
                    ;
                while (pivot.compareTo(a[--j]) < 0)
                    ;
                if (i >= j)
                    break;
                Sort.swapReferences(a, i, j);
            }
            Sort.swapReferences(a, i, high - 1);

            quicksort(a, low, i - 1);
            quicksort(a, i + 1, high);
        }
    }
}