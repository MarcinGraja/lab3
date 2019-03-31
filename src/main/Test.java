package main;

import matrix.Matrix;
import sorting.BogoSort;
import sorting.BubbleSort;
import sorting.HeapSort;
import sorting.MergeSort;
import substring.Substring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    private static void restore(int[]arr, int []reverse, int []original){
        for (int i=0; i<arr.length; i++){
            arr[i]=original[i];
            reverse[arr.length-i-1] = i;
        }
    }
    public static void print(int[]arr){
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]+'\t');
        }
    }
    private static void matrixTest(){
        Random generator = new Random();
        int sizeX=5;
        int sizeY=5;
        Double [][]arr1 = new Double[sizeX][sizeY];
        Double [][]arr2 = new Double[sizeX][sizeY];
        String [][]arr3 = new String[sizeX][sizeY];
        String [][]arr4 = new String[sizeX][sizeY];
        for (int i=0; i<sizeX; i++){
            for (int j=0; j<sizeY; j++) {
                arr1[i][j] = (double) generator.nextInt() % 100;
                arr2[i][j] = (double) generator.nextInt() % 100;
                arr3[i][j] = Integer.toString(generator.nextInt() % 100);
                arr4[i][j] = Integer.toString(generator.nextInt() % 100);
            }
        }
        Matrix<Double> matrix = new Matrix<>(arr1);
        Matrix<Double> matrix2 = new Matrix<>(arr2);
        Matrix<String> matrix3 = new Matrix<>(arr3);
        Matrix<String> matrix4 = new Matrix<>(arr4);
        System.out.println("matrix");
        matrix.print();
        System.out.println("matrix2");
        matrix2.print();
        System.out.println("added:");
        matrix.add(matrix2).print();
        System.out.println("matrix3");
        matrix3.print();
        System.out.println("matrix4");
        matrix4.print();
        System.out.println("added:");
        matrix3.add(matrix4).print();
    }
    private static void sortingTest(){
        Random generator = new Random();
        Timer timer = new Timer();

        int size = 100000;
        int []original = new int[size];
        int []arr = new int[size];
        int []reverse = new int[size];
        int []sorted = new int[size];
        for (int i=0; i<size; i++){
            original[i] = arr[i] = generator.nextInt()%10;
            reverse[size-i-1] = i;
            sorted[i]=i;
        }
        System.out.println("Bubblesort");
        timer.start();
        BubbleSort.bubbleSort(arr);
        System.out.println(timer.tellSeconds());
        timer.start();
        BubbleSort.bubbleSort(reverse);
        System.out.println(timer.tellSeconds());
        timer.start();
        BubbleSort.bubbleSort(sorted);
        System.out.println(timer.tellSeconds());
        restore(arr, reverse, original);

        System.out.println("Heapsort");
        timer.start();
        HeapSort.sort(arr);
        System.out.println(timer.tellSeconds());
        timer.start();
        HeapSort.sort(reverse);
        System.out.println(timer.tellSeconds());
        timer.start();
        HeapSort.sort(sorted);
        System.out.println(timer.tellSeconds());
        restore(arr, reverse, original);

        System.out.println("Mergesort");
        timer.start();
        MergeSort.sort(arr, 0, arr.length-1);
        System.out.println(timer.tellSeconds());
        timer.start();
        MergeSort.sort(reverse, 0, arr.length-1);
        System.out.println(timer.tellSeconds());
        timer.start();
        MergeSort.sort(sorted, 0, arr.length-1);
        System.out.println(timer.tellSeconds());

        System.out.println("Bogosort");
        timer.start();
        BogoSort.bogoSort(arr);
        System.out.println(timer.tellSeconds());
        timer.start();
        BogoSort.bogoSort(reverse);
        System.out.println(timer.tellSeconds());
        timer.start();
        BogoSort.bogoSort(sorted);
        System.out.println(timer.tellSeconds());
    }
    private static void lowestIntNotInSolutionTest(){
        Random generator = new Random();
        List<Integer> list = new ArrayList<>();
        Timer timer = new Timer();
        timer.start();
        for (int i=0; i<1e5; i++){
            list.add(generator.nextInt()%100000);
        }
        System.out.println("Number generation time: " + timer);

        timer.start();
        System.out.println(lowestIntNotInList.Solution.solution(list));
        System.out.println("lowestIntNotInList total time: " + timer);
    }
    private  static void indexesOfAddendsTest(){
        Random generator = new Random();
        float []array  = new float[10000];
        for (int i=0; i<10000; i++){
            array[i] = generator.nextInt()%100;
        }
        int []indexes = indexesOfAddends.Solution.solution(array,50);
        System.out.println("Indexes of addends: " + indexes[0] + ", " + indexes[1]);
        String a;
        String b;
        a="abcd";
        b="cdabcdab";
        System.out.println("a: " + a + "\tb: " + b);
        System.out.println("a needs to be repeated " + Substring.substring(a,b) + " times for b to be a substring of a");
        System.out.println("b needs to be repeated " + Substring.substring(b,a) + " times for a to be a substring of b");
    }
    public static void test(){
        matrixTest();
        sortingTest();
        lowestIntNotInSolutionTest();
        indexesOfAddendsTest();

    }
}
