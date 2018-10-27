import java.util.*;
/**
 * FractionCounter takes in reduced fractions
 * checks to see if they already exist in the 
 * existing array lists and records their 
 * associated frequencies.
 *
 * @author (Krystle S Levin)
 * @version (January 18th 2018)
 */
public class FractionCounter
{
    //Instance varibales to hold and reference
    //Numerator, denominator and frequency values
    private ArrayList<Integer>numerator;
    private ArrayList<Integer>denominator;
    private ArrayList<Integer>frequency;
    
    private int index;//simply just keeps track of the total size.
    public FractionCounter(){
        numerator=new ArrayList<Integer>();
        denominator=new ArrayList<Integer>();
        frequency=new ArrayList<Integer>();
        index=0;
    }
    public void addNew(int n, int d){
        if(compare(n, d)){//compare() checks to see if the fraction already exists
            numerator.add(index, n);
            denominator.add(index,d);
            frequency.add(index, 1);
            index++;
        }
    }
    public boolean compare(int n, int d){
        for(int i=0; i<index; i++){
            //goes through existing numerator and denominator values
            //to determine if new values should be added.
            if (numerator.get(i)==n && denominator.get(i)==d){//values exists
                    frequency.set(i, frequency.get(i)+1);
                    return false;//no need to add a new value
            }
        }
        return true;//new values must be added
        }
    //The following are getter methods so that they may be accessed in main.
    public ArrayList getNumeratorList(){
        return numerator;
    }
    public ArrayList getDenominatorList(){
        return denominator;
    }
    public ArrayList getFrequencyList(){
        return frequency;
    }
    public int getIndex(){
        return index;
    }
}
