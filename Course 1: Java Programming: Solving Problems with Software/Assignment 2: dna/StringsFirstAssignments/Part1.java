
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String DNA){
        String Gene = "";
        int ATG_index = DNA.indexOf("ATG");
        int TAA_index = DNA.indexOf("TAA");
        if (ATG_index==-1 || TAA_index==-1 || TAA_index<ATG_index || (TAA_index-ATG_index)%3!=0 ){
            return "No Gene Found";
        }
        Gene = DNA.substring(ATG_index,TAA_index+3);
        return Gene;
    }
    
    public void test(){
        String DNA = "";
        // DNA with no “ATG”
        DNA = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println(findSimpleGene(DNA));
        // DNA with no “TAA”
        DNA = "QWEQWEATGQWEQEQEWQE";
        System.out.println(findSimpleGene(DNA));
        // DNA with no “ATG” or “TAA”
        DNA = "QWEQWEQWEQEQEWQE";
        System.out.println(findSimpleGene(DNA));
        // DNA with ATG, TAA and the substring between them is a multiple of 3
        DNA = "QWEQWEQATGWEQEQEWQETAA";
        System.out.println(findSimpleGene(DNA));
    }
    
    public static void main(String args[]){
        Part1 P1 = new Part1();
        P1.test();
    }
}
