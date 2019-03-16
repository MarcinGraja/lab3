package lowestIntNotInList;

public class EmptyListException extends RuntimeException {
    public String toString(){
        return "List is empty";
    }
    public EmptyListException(){}
}
