package Sorting.Test;

import Sorting.Insertion;
import Sorting.Merge;
import Sorting.Quick;
import org.junit.Assert;
import org.junit.Test;

public class SortTest {
    private Integer[] unsorted;
    private Integer[] sorted;


    private void getTestArrays() {
        unsorted = new Integer[]{1, 5, 3, 7, 9, 12, 14, 3};
        sorted = new Integer[]{1, 3, 3, 5, 7, 9, 12, 14};
    }

    private void getEmptyArray() {
        unsorted = new Integer[]{};
        sorted = new Integer[]{};
    }

    private void getSortedArray() {
        unsorted = new Integer[]{1, 2, 3, 4, 5, 6};
        sorted = unsorted;
    }

    private void getBigArray() {
        unsorted = new Integer[]{55, 57, 73, 63, 12, 37, 49, 54, 72, 93, 83, 2, 65, 21, 79, 32, 50, 90, 53, 38, 85, 56, 27, 22, 61, 91, 97, 78, 39, 20, 6, 96, 89, 64, 99, 76, 1, 40, 17, 41, 7, 69, 87, 29, 19, 74, 42, 16, 46, 26, 68, 18, 66, 71, 28, 51, 47, 31, 59, 9, 3, 25, 15, 34, 35, 11, 95, 10, 98, 82, 100, 33, 81, 92, 62, 5, 24, 84, 80, 4, 30, 70, 14, 52, 77, 86, 94, 58, 48, 60, 13, 88, 67, 43, 36, 44, 23, 45, 75, 8};
        sorted = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};
    }


    @Test
    public void testWithNormalArray() {
        getTestArrays();
        quick(unsorted, sorted);
        getTestArrays();
        insertion(unsorted, sorted);
        getTestArrays();
        merge(unsorted, sorted);
    }

    @Test
    public void testWithEmptyArray() {
        getEmptyArray();
        quick(unsorted, sorted);
        getEmptyArray();
        insertion(unsorted, sorted);
        getEmptyArray();
        merge(unsorted, sorted);
    }

    @Test
    public void testWithSortedArray() {
        getSortedArray();
        quick(unsorted, sorted);
        getSortedArray();
        insertion(unsorted, sorted);
        getSortedArray();
        merge(unsorted, sorted);
    }

    @Test
    public void testWithBigArray() {
        getBigArray();
        quick(unsorted, sorted);
        getBigArray();
        insertion(unsorted, sorted);
        getBigArray();
        merge(unsorted, sorted);
    }


    private void quick(Integer[] unsorted, Integer[] sorted) {
        Quick.sort(unsorted);
        Assert.assertEquals(sorted, unsorted);
    }

    private void insertion(Integer[] unsorted, Integer[] sorted) {
        Insertion.sort(unsorted);
        Assert.assertEquals(sorted, unsorted);
    }

    private void merge(Integer[] unsorted, Integer[] sorted) {
        Merge.sort(unsorted);
        Assert.assertEquals(sorted, unsorted);
    }

}
