
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany (String stringa ,String stringb){
        int start_index = 0;
        int counter = 0;
        while (true){
            int found_index = stringb.indexOf(stringa,start_index);
            if (found_index == -1){
                break;
            }
            counter += 1;
            start_index = found_index + stringa.length();
        }
        return counter;
    }
    
    public void test(){
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println(howMany("AA", "ATAAAA"));
    }
    
    public static void main(String args[]){
        Part2 p2 = new Part2();
        p2.test();
    }
}
