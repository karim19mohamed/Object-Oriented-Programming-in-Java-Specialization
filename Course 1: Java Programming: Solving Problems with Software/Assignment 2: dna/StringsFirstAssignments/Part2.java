
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String DNA, String startCodon, String stopCodon){
        String DNAUpper = DNA.toUpperCase();
        String Gene = "";
        int ATG_index = DNAUpper.indexOf(startCodon);
        int TAA_index = DNAUpper.indexOf(stopCodon);
        if (ATG_index==-1 || TAA_index==-1 || TAA_index<ATG_index || (TAA_index-ATG_index)%3!=0 ){
            return "No Gene Found";
        }
        Gene = DNA.substring(ATG_index,TAA_index+3);
        return Gene;
    }
    
    public void test(){
        String DNA = "";
        // DNA with no “ATG”
        DNA = "QWEQWEQWEQEQEWQETAA";
        System.out.println(findSimpleGene(DNA,"ATG","TAA"));
        // DNA with no “TAA”
        DNA = "QWEQWEATGQWEQEQEWQE";
        System.out.println(findSimpleGene(DNA,"ATG","TAA"));
        // DNA with no “ATG” or “TAA”
        DNA = "QWEQWEQWEQEQEWQE";
        System.out.println(findSimpleGene(DNA,"ATG","TAA"));
        // DNA with ATG, TAA and the substring between them is a multiple of 3
        DNA = "QWEQWEQATGWEQEQEWQETAA";
        System.out.println(findSimpleGene(DNA,"ATG","TAA"));
        DNA = "qweqweqatgweqeqewqetaa";
        System.out.println(findSimpleGene(DNA,"ATG","TAA"));
    }
    
    public static void main(String args[]){
        Part2 P2 = new Part2();
        P2.test();
    }
}
