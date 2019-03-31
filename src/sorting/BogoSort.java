package sorting;

public class BogoSort {
    // Sorts array a[0..n-1] using Bogo sort
    static public void bogoSort(int[] a) {
        // if array is not sorted then shuffle the
        // array again
        while (isSorted(a) == false)
            shuffle(a);
    }

    // To generate permuatation of the array
    static void shuffle(int[] a) {
        // Math.random() returns a double positive
        // value, greater than or equal to 0.0 and
        // less than 1.0.
        for (int i = 1; i <= a.length; i++)
            swap(a, i, (int) (Math.random() * i));
    }

    // Swapping 2 elements
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // To check if array is sorted or not
    static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i - 1])
                return false;
        return true;
    }
}
