
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.URLResource;
//import java.lang.String;

public class Part4 {
    public void test(){
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String s : ur.lines()) {
            String sUpper = s.toLowerCase();
            int idx = sUpper.indexOf("youtube.com");
            if (idx==-1){
                continue;
            }
            int st = idx, en = idx;
            while(s.charAt(st)!='\"'){
                st -=1;
            }
            while(s.charAt(en)!='\"'){
                en +=1;
            }
            System.out.println(s.substring(st,en+1));
        }
        
    }
    
    public static void main(String args[]){
        Part4 P4 = new Part4();
        P4.test();
    }
}
