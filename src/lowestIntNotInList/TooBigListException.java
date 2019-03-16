package lowestIntNotInList;

public class TooBigListException extends RuntimeException{
    int size;
    TooBigListException(int size) {
        this.size = size;
    }
    public String toString(){
        return "Too big list; Maximum allowed size: " + 1e5 + ", size of the list: " + size;
    }
}
