package Sorting;

public class insertion {
    /**
     * Simple insertion sort
     */
    public static <AnyType extends Comparable<? super AnyType>>

    AnyType[] insertionSort(AnyType[] a) {
        for (int p = 1; p < a.length; p++) {
            AnyType tmp = a[p];
            int j = p;

            for (; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }

        return a;
    }
}
