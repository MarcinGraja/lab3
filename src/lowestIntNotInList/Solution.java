package lowestIntNotInList;

import java.util.List;

public class Solution {
    public static int solution(List<Integer> list) throws EmptyListException, TooBigListException{
        if (list.isEmpty()){
            throw new EmptyListException();
        }
        if (list.size()>1e5){
            throw new TooBigListException(list.size());
        }

        int minimum = 1;
        while (list.contains(minimum)) {
            minimum++;
        }
        return minimum;
    }
}
