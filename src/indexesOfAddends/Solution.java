package indexesOfAddends;

import java.util.Arrays;

public class Solution {

    public static int []solution(float []array, float target) throws NoSolutionException {
        Float []unsortedArray = new Float[array.length];
        Float []sortedArray = new Float[array.length];
        for (int i=0; i<array.length; i++){
            unsortedArray[i] = sortedArray[i] = array[i];
        }
        Arrays.sort(sortedArray);
        int [] indexes = FindSolution(sortedArray, target);
        int []actualIndexes = new int[2];
        actualIndexes[0] = Arrays.asList(unsortedArray).indexOf(sortedArray[indexes[0]]);
        actualIndexes[1] = Arrays.asList(unsortedArray).indexOf(sortedArray[indexes[1]]);
        return actualIndexes;

    }

    private static int []FindSolution(Float []array, float target) throws NoSolutionException{
            int lower=0;
            int upper=array.length-1;
            Arrays.sort(array);
            int count =0;
            while (lower < upper){

                while (array[lower]+array[upper]>target){
                    upper--;
                    count++;
                }
                while (array[lower]+array[upper] < target){
                    lower++;
                    count++;
                }
                if (array[lower]+array[upper] == target){
                    return new int[]{lower,upper};
                }
            }
            throw new NoSolutionException();
        }

}
