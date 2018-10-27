import java.util.Scanner;
/**
 * Write a description of class Alignmenttest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Alignmenttest
{
   
 //main method
   public static void main(String[] args){

       
       
       intro1();
       countRatio1();
       complement1();
       
       System.out.println();
       
       intro2();
       countRatio2();
       complement2();
       
       alignmentTest();
       
       
    }
    static Scanner input=new Scanner(System.in);
    //sourced from Stack Overflow forum (author: "adityaekawade")
    public static final String GENOME_1=input.next();
    public static final String GENOME_2=input.next();

    //All process below calculate sequence 1  
     public static void intro1(){//takes in DNA sequence 1  
     System.out.print("Sequence 1: ");
     System.out.println(GENOME_1); 
    }
    public static void countRatio1(){//Finds the counts and ratio of C and G

      int cCount=GENOME_1.length()-GENOME_1.replace("C","").length();
      System.out.println("C-count: " +cCount);

      int gCount=GENOME_1.length()-GENOME_1.replace("G","").length();
     
      double cAndG=cCount+gCount;
      double total=GENOME_1.length();
      double ratio= cAndG / total;
     
      System.out.printf("CG-ratio: %4.3f %n", ratio);  
      
    }
    public static void complement1(){ //determines the complement of sequence 1
        int length=GENOME_1.length();
        String complement=GENOME_1;
 
        for(int i=0; i<length; i++){
            int c=GENOME_1.substring(i).indexOf("C")+i;
            int g=GENOME_1.substring(i).indexOf("G")+i;
            int a=GENOME_1.substring(i).indexOf("A")+i;
            int t=GENOME_1.substring(i).indexOf("T")+i;
            if(t==i){
                complement=complement.substring(0,i)+"A"+complement.substring(i+1);
            
            }
            else if(a==i){
                complement=complement.substring(0,i)+"T"+complement.substring(i+1);            
            }
            else if(c==i){
                complement=complement.substring(0,i)+"G"+complement.substring(i+1);
                
            }
            else if(g==i){
                complement=complement.substring(0,i)+"C"+complement.substring(i+1);
                
            }
        }
        System.out.println("Complement: " +complement);
        
    }

    //checks char equivelancy and appropriates numerical score
    //Placed before sequence 2, because sequence2 methods=sequence1 methods
    public static void alignmentTest(){
        String genomeV1=(GENOME_2+"  ");        
        String genomeV2=(" "+GENOME_2+" ");
        String genomeV3=("  "+GENOME_2);
        
        int scoreV1=0;
        int scoreV2=0;
        int scoreV3=0;
        
        // the following for loop keeps track of the score
          for(int i=0; i<GENOME_1.length(); i++){
              char mainGenome=GENOME_1.charAt(i);
              char charOfV1=genomeV1.charAt(i); 
               if(mainGenome==charOfV1){
                    scoreV1++;
                }
            } 
          for(int j=0; j<GENOME_1.length(); j++){
             char mainGenome=GENOME_1.charAt(j);
             char charOfV2=genomeV2.charAt(j); 
             if(mainGenome==charOfV2){
                    scoreV2++;
                }
            }
          for(int k=0; k<GENOME_1.length(); k++){
             char mainGenome=GENOME_1.charAt(k);
             char charOfV3=genomeV3.charAt(k); 
             if(mainGenome==charOfV3){
                    scoreV3++;
                }
            }
        
        //To calculate the best score:
        int bestMatch=Math.max(Math.max(scoreV1,scoreV2),scoreV3);
        System.out.println("Best alignment score: "+bestMatch);
        System.out.println(GENOME_1);
           if (bestMatch==scoreV1)
                System.out.println(genomeV1);
           else if(bestMatch==scoreV2)
                System.out.println(genomeV2);
           else if(bestMatch==scoreV3)
                System.out.println(genomeV3);
    }
    
    //every method below is just a repeat of the methods above
    //essentially copycats from sequence one for sequence two
    public static void intro2(){
     System.out.print("Sequence 2: ");
     System.out.println(GENOME_2); 
    }
    public static void countRatio2(){

      int cCount=GENOME_2.length()-GENOME_2.replace("C","").length();
      System.out.println("C-count: " +cCount);

      int gCount=GENOME_2.length()-GENOME_2.replace("G","").length();
     
      double cAndG=cCount+gCount;
      double total=GENOME_2.length();
      double ratio= cAndG / total;
     
      System.out.printf("CG-ratio: %4.3f %n", ratio);  
      
    }
    public static void complement2(){
        int length=GENOME_2.length();
        String complement=GENOME_2;
     
        for(int i=0; i<length; i++){
            int c=GENOME_2.substring(i).indexOf("C")+i;
            int g=GENOME_2.substring(i).indexOf("G")+i;
            int a=GENOME_2.substring(i).indexOf("A")+i;
            int t=GENOME_2.substring(i).indexOf("T")+i;
            if(t==i){
                complement=complement.substring(0,i)+"A"+complement.substring(i+1);
            }
            else if(a==i){
                complement=complement.substring(0,i)+"T"+complement.substring(i+1);
            }
            else if(c==i){
                complement=complement.substring(0,i)+"G"+complement.substring(i+1);
            }
            else if(g==i){
                complement=complement.substring(0,i)+"C"+complement.substring(i+1);
            }
        }
        System.out.println("Complement: "+complement);
    }
    public static void complementPrint2(String complement2){
        String compnt2=complement2;
        System.out.println("Complement: " +complement2);
    }
}


