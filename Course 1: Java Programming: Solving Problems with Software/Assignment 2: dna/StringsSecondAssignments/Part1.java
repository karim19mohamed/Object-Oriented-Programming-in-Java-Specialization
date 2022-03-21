
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String DNA, int startCodon_index, String stopCodon){
        // String DNAUpper = DNA.toUpperCase();
        int stopCodon_index = DNA.indexOf(stopCodon, startCodon_index);
        if (stopCodon_index==-1 || (stopCodon_index-startCodon_index)%3!=0 ){
            return -1;
        }
        return stopCodon_index;
    }
    
    public int findGene(String DNA, int DNA_start_index){
        String startCodon = "ATG";
        int startCodon_index = DNA.indexOf(startCodon,DNA_start_index);
        if (startCodon_index==-1){
            return -1;
        }
        int TAA_index = findStopCodon(DNA,startCodon_index,"TAA");
        int TAG_index = findStopCodon(DNA,startCodon_index,"TAG");
        int TGA_index = findStopCodon(DNA,startCodon_index,"TGA");
        if (TAA_index==-1 && TAG_index==-1 && TGA_index==-1){
            return -1;
        }
        if (TAA_index==-1){
            TAA_index = DNA.length() + 9;
        }
        if (TAG_index==-1){
            TAG_index = DNA.length() + 9;
        }
        if (TGA_index==-1){
            TGA_index = DNA.length() + 9;
        }
        int shortest_index = Math.min(TAA_index, Math.min(TAG_index,TGA_index));
        String Gene = DNA.substring(startCodon_index,shortest_index+3);
        System.out.println(Gene);
        return shortest_index;
    }
    
    public void printAllGenes(String DNA){
        int DNA_start_index = 0;
        while(true){
            int stopCodon_index = findGene(DNA, DNA_start_index);
            if (stopCodon_index == -1){
                break;
            }
            
            DNA_start_index = stopCodon_index + 3;
        }
    }
    
    public void test(){
        String DNA = "";
        DNA = "AATGCTAACTAGCTGACTAAT";
        printAllGenes(DNA);
    }
    
    public static void main(String args[]){
        Part1 P1 = new Part1();
        P1.test();
    }
}
