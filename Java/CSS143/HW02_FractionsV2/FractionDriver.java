import java.io.*;
import java.util.*;
/**
 * FractionDriver reads a text file containg an unknown number
 * of fractions of which are split by a designated delimiter
 * and sent as an int value to soecific containers used to
 * both reduce the fraction and store unique values.
 * of which are then printed to the Terminal Window.
 *
 * @author (Krystle S Levin)
 * @version (January 18th 2018)
 */
public class FractionDriver
{
    public static void main(String[] args){
        FractionCounter stored=new FractionCounter();
        Scanner inputStream= null;
        
        try{//Try-Catch used in an attempt to reach desired file
            inputStream= new Scanner(new FileInputStream ("fractions.txt")); 
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        
        //The following while loop reads each line individually and sends
        //them to their appropriate destinations to be counted and stored.
        while(inputStream.hasNextLine()){
            //here the line is read, split and parsed to seperate int values    
            String newFraction=inputStream.nextLine();
            String[] split=newFraction.split("/");
            int nNum=Integer.parseInt(split[0]);
            int dNum=Integer.parseInt(split[1]);
                
            if(dNum==0){//this avoids any division by 0.
                System.out.println("Sorry, the file contains and invalid denominator of 0");
                System.out.println("Please check your file and try again");
                System.exit(0);
            }
            else{
                 Fraction fraction=new Fraction(nNum, dNum);
                 stored.addNew(fraction.getNumerator(), fraction.getDenominator());
            } 
        }
        
        //the following retrieves final index size of the lists
        //and uses it to print the fractions and their associated counts
        int i=stored.getIndex();
        System.out.println(i);
        for(int k=0; k<i; k++){ //this is the loop used for printing
            System.out.print(stored.getNumeratorList().get(k)+"/");
            System.out.print(stored.getDenominatorList().get(k)+" appears exactly ");
            System.out.println(stored.getFrequencyList().get(k)+" times.");
        }
         
    }
}
