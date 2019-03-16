package main;

import indexesOfAddends.NoSolutionException;
import lowestIntNotInList.EmptyListException;
import lowestIntNotInList.TooBigListException;
import substring.Substring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Main {
    public static void main(String[] args) {
        //Matrix<Double> matrix = new Matrix<>(10,10);
        //Matrix<Double> matrix2 = new Matrix<>(10,10);
        List<Integer> list = new ArrayList<>();
        Random generator = new Random();
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
            System.out.println(i + ": " + array[i]);
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