import java.util.Scanner;
/**
 * Write a description of class StringCheck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StringCheck
{
    public static void main(String[] args){
        
        System.out.println("Please enter a DNA sequence");
        check();

    
    }
    public static void check(){
     Scanner input=new Scanner(System.in);
     String dna=input.next();
     
     for(int i=1; i<dna.length();i++){
         char test=dna.charAt(i);
         if((test!=('T'))||(test!=('A'))||(test!=('C'))||(test!=('G'))){
             System.out.println("Please enter a valid sequence");
             dna=input.next();
             break;
            }
         
        }
     
        
    }
    public static void fuck(){
     Scanner input=new Scanner(System.in);
     String dna=input.next();
     
     for(int i=1; i<dna.length();i++){
         char test=dna.charAt(i);
         if((test!=('T'))||(test!=('A'))||(test!=('C'))||(test!=('G'))){
             System.out.println("Please enter a valid sequence");
             dna=input.next();
             break;
            }
         
        }
     
        
    }
}

