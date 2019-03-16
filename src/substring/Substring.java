package substring;

public class Substring {
    public static int substring(String a, String b){

        /*  returns how many times you have to repeat a for b to be a substring of a;
            if b can't be a substring of a return -1

            ELI5:
            situation at the start of the method:
            a="abcd"
            b="cdabcdab"
            we "offset" b so it aligns with a
            a="abcd"
            b=  "cdabcdab"
            that's why we start with count=1 instead of 0; if this fails, b can't be a substring of a
            then we check if a.length() characters of b starting with offset are equal to a and if they are
            we increase offset by a.length() and count by 1; if they aren't b can't be substring of a
            if there's not enough characters to compare, we check whether the remaining characters are a substring of a
            starting at 0 and if they are; if they aren't b can't be substring of a

        */
        int offset; //offset of current fit
        offset = b.indexOf(a);
        if(offset==-1){
            if (a.contains(b)){ //in case b is shorter than a
                return 1;
            }
            else{
                return -1;
            }
        }
        if (!a.contains(b.substring(0, offset))){
            return -1;
        }
        int count = 1;
        while (b.length() >= a.length()+offset){
            if (b.substring(offset, offset+a.length()).equals(a)){
                offset += a.length();
                count++;
            }
            else return -1;
        }
        int index = 0;
        while (offset+index > b.length()){
            if (b.charAt(offset+index) != a.charAt(index)){
                return -1;
            }
            else{
                index++;
            }
        }
        count++;
        return count;
    }
}
