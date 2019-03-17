package main;

import matrix.Matrix;
import substring.Substring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        int sizeX=5;
        int sizeY=5;
        Double [][]arr1 = new Double[sizeX][sizeY];
        Double [][]arr2 = new Double[sizeX][sizeY];
        String [][]arr3 = new String[sizeX][sizeY];
        String [][]arr4 = new String[sizeX][sizeY];
        Random generator = new Random();
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
        List<Integer> list = new ArrayList<>();
        Timer timer = new Timer();
        long tStart = System.currentTimeMillis();
        timer.start();
        for (int i=0; i<1e5; i++){
            list.add(generator.nextInt()%100000);
        }
        System.out.println("Number generation time: " + timer);

        timer.start();
        System.out.println(lowestIntNotInList.Solution.solution(list));
        System.out.println("lowestIntNotInList total time: " + timer);

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
}