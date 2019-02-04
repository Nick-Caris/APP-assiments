package Sorting;

public class Insertion implements Sort {


    /**
     * Simple insertion sort
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void sort(AnyType[] a) {
        System.out.println("Insertion");
        for (int p = 1; p < a.length; p++) {
            AnyType tmp = a[p];
            int j = p;

            for (; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }
}
