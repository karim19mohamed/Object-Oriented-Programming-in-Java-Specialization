
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringA, String stringB){
        int firstOccur = stringB.indexOf(stringA);
        if (firstOccur==-1){
            return false;
        }
        int secondOccur = stringB.indexOf(stringA,firstOccur+1);
        if (secondOccur==-1){
            return false;
        }
        return true;
    }
    
    public String lastPart(String stringA, String stringB){
        int firstOccur = stringB.indexOf(stringA);
        if (firstOccur==-1){
            return stringB;
        }
        String afterFirst = stringB.substring(firstOccur+stringA.length() , stringB.length());
        return afterFirst;
    }
    
    public void test(){
        String stringA = "by", stringB = "A story by Abby Long";
        System.out.println(twoOccurrences(stringA, stringB));
        
        stringA = "a";
        stringB = "banana";
        System.out.println(twoOccurrences(stringA, stringB));
        
        stringA = "atg";
        stringB = "ctgtatgta";
        System.out.println(twoOccurrences(stringA, stringB));
        
        stringA = "an";
        stringB = "banana";
        System.out.println(lastPart(stringA, stringB));
        
        stringA = "zoo";
        stringB = "forest";
        System.out.println(lastPart(stringA, stringB));
    }
    
    public static void main(String args[]){
        Part3 P3 = new Part3();
        P3.test();
    }
}
