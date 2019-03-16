package indexesOfAddends;

public class NoSolutionException extends RuntimeException {
    public String toString(){
        return "NoSolutionException: no 2 numbers in given array add up to target number";
    }
}
