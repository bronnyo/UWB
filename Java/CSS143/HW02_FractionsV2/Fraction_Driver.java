import java.util.*;
import java.io.*;
/**
 * Write a description of class Fraction_Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fraction_Driver
{
    public static void main(String[] args){
        FractionDraft fraction1=new FractionDraft();
        
        Scanner inputStream= null;
        try{
            inputStream= new Scanner(new FileInputStream ("fractions.txt")); 
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        while(inputStream.hasNextLine()){
                String newFraction=inputStream.nextLine();
                String[] split=newFraction.split("/");
                if(split[1]=="0"){
                    System.out.println("Sorry, the file contains and invalid denominator of 0");
                    System.out.println("Please check your file and try again");
                    System.exit(0);
                }
                fraction1.addNew(split[0],split[1]); 
        }
    }
}
