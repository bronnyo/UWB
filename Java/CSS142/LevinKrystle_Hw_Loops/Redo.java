import java.util.Scanner;

/**
 * Write a description of class Redo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Redo
{
   public static void main(String[] args){
       Scanner input=new Scanner(System.in);
       
       System.out.println("Please enter a DNA Sequence consisting of:");
       System.out.println("AT,TA,GC or CG, in all capitals");
       System.out.println();
              while(!input.hasNext("[A,C,T,G]+")){//sourced from StackOverflow source N/A
                     System.out.println("Not a valid input");
                     input.next();
                    }
                 String sequence=input.next();
                 String dna1=sequence;
         
       complement1(sequence);
       countandRatio(sequence);
       
       System.out.println();
       System.out.println();
       
       System.out.println("Please enter a another DNA Sequence consisting of:");
       System.out.println();
                 while(!input.hasNext("[A,C,T,G]+")){
                     System.out.println("Not a valid input");
                     input.next();
                    }
                 sequence=input.next();
                 String dna2=sequence;
       
       complement1(sequence);
       countandRatio(sequence);    
       
       System.out.println();
       alignmentTest(dna1,dna2);
       
       
    }
   
    
    
     public static void countandRatio(String sequence){//Finds the counts and ratio of C and G
      int cCount=sequence.length()-sequence.replace("C","").length();
      System.out.println("C-count: " +cCount);

      int gCount=sequence.length()-sequence.replace("G","").length();
     
      double cAndG=cCount+gCount;
      double total=sequence.length();
      double ratio= cAndG / total;
     
      System.out.printf("CG-ratio: %4.3f %n", ratio);  
      
    }
    
    public static void complement1(String sequence){ //determines the complement of sequence 1
        int length=sequence.length();
        String complement=sequence;
 
        for(int i=0; i<length; i++){
            int c=sequence.substring(i).indexOf("C")+i;
            int g=sequence.substring(i).indexOf("G")+i;
            int a=sequence.substring(i).indexOf("A")+i;
            int t=sequence.substring(i).indexOf("T")+i;
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
    public static void alignmentTest(String dna1, String dna2){
        // computes the best allignment possibilities
        int max=Math.max(dna1.length(),dna2.length());
        int min=Math.min(dna1.length(),dna2.length());
        int shift=(max-min);
        String s=" ";//adds a space to allignment

        int scoreV1=0;
        int scoreV2=0;
        int scoreV3=0;
        int scoreV4=0;
        int scoreV5=0;
       String dnaV1=dna2;
       String dnaV2=dna2; 
        for(int i=0; i<shift;i++){
            dnaV1=dnaV1+s; 
            dnaV2=s+dnaV2;
        }
        
        for(int i=0; i<max; i++){
           char charOfDna1=dna1.charAt(i);
           char charOfV1=dnaV1.charAt(i); 
               if(charOfDna1==charOfV1){
                 scoreV1++;
                }
            } 
            
        for(int j=0; j<max; j++){
           char charOfDna1=dna1.charAt(j);
           char charOfV2=dnaV2.charAt(j); 
               if(charOfDna1==charOfV2){
                        scoreV2++;
                  }
         }    
         
        if(shift%2==0){
           shift=shift/2;
           String dnaV3=dna2;       
                for(int i=0; i<shift;i++){
                    dnaV3= s+dnaV3+s ; 
                }
            
                for(int k=0; k<max; k++){
                 char charOfDna1=dna1.charAt(k);
                 char charOfV3=dnaV3.charAt(k); 
                     if(charOfDna1==charOfV3){
                            scoreV3++;
                        }
                }
            int bestMatch=Math.max(Math.max(scoreV1,scoreV2),scoreV3);
            System.out.println("Best alignment score: "+bestMatch);
            System.out.println(dna1);
                if (bestMatch==scoreV1)
                    System.out.println(dnaV1);
                else if(bestMatch==scoreV2)
                    System.out.println(dnaV2);
                else if(bestMatch==scoreV3)
                    System.out.println(dnaV3);
                
        }
        else if((shift>=3)&&(shift%3==0)){
            shift=shift/3;
            String dnaV4=dna2; 
            String dnaV5=dna2;
                for(int i=0; i<shift;i++){
                    dnaV4= s+s+dnaV4+s ;
                    dnaV5= s+dnaV5+s+s;
                }
                for(int k=0; k<max; k++){
                 char charOfDna1=dna1.charAt(k);
                 char charOfV4=dnaV4.charAt(k); 
                     if(charOfDna1==charOfV4){
                            scoreV4++;
                        }
                }
                for(int k=0; k<max; k++){
                 char charOfDna1=dna1.charAt(k);
                 char charOfV5=dnaV5.charAt(k); 
                     if(charOfDna1==charOfV5){
                            scoreV5++;
                        }
                }
            int bestMatch=Math.max(Math.max(Math.max(scoreV1,scoreV2),scoreV4),scoreV5);
            System.out.println("Best alignment score: "+bestMatch);
            System.out.println(dna1);
                if (bestMatch==scoreV1)
                    System.out.println(dnaV1);
                else if(bestMatch==scoreV2)
                    System.out.println(dnaV2);
                else if(bestMatch==scoreV4)
                    System.out.println(dnaV4);
                else if(bestMatch==scoreV5)
                    System.out.println(dnaV5); 
          }     
    }
}
