
/**
 * BinarySearch is a subclass of SearchAlgorithm.
 * Binary search has two methods that either search for a target word
 * in a non empty array of strings using either an itterative
 * or a recursive method
 *
 * @author (Krystle S Levin)
 * @version (February 16th, 2018)
 */
public class BinarySearch extends  SearchAlgorithm
{
    //Instance variables:
    int lowIndex;
    int highIndex;
    int midIndex;
    //constructor:
    public BinarySearch(){//initializes variables to default values
        lowIndex=0;
        highIndex=0;
        midIndex=0;
    }
    /**
     * Method: Search 
     * Pre-condition:   Words is a nonempty array of Strings, and target is a non-null string 
     *                  to search for in our collection of strings
     * Post-Condition:  The method will return the position of the list in which the desired
     *                  word can be found, provided that the word exists in the list. 
     *                  Search uses an itterative binary method to accomplish this task.
     */    
    public int search(String[] words, String target)throws ItemNotFoundException{
        lowIndex=0;
        highIndex=words.length-1;
        while (lowIndex <= highIndex){
            int midIndex = lowIndex + (highIndex - lowIndex)/2;
            incrementCount();
            int result = words[midIndex].compareTo(target);
            if (result == 0)
                return midIndex;
            else if (result < 0)
                lowIndex = midIndex + 1;
            else 
                highIndex = midIndex - 1;
        }
        throw new ItemNotFoundException("Item was not located");
    }
    /**
     * Method: recSearch 
     * Pre-condition:   Words is a nonempty array of Strings, and target is a non-null string 
     *                  to search for in our collection of strings
     * Post-Condition:  The method will return the position of the list in which the desired
     *                  word can be found, provided that the word exists in the list. 
     *                  Search uses an recursive binary method to accomplish this task.
     */  
    public int recSearch(String[] words, String target) throws ItemNotFoundException{
        if(getCount()==0){//resets instance variable values
            highIndex=words.length-1;
            lowIndex=0;
        }
        
        if (words.length > 0 && target != null){//ensures conditions are met
            midIndex = (highIndex + lowIndex)/2;//sets midvalue
            
            if (lowIndex > highIndex) //checks for proper coding
                throw new ItemNotFoundException();
                
            super.incrementCount(); //adds one to the counter in the super class
            int result = words[midIndex].compareTo(target);
            
            if (result == 0)//this checks if we have found our target
                return midIndex;
            else if (result < 0){ //checks if target is below our current spot
                lowIndex=midIndex + 1;
                return recSearch(words, target);
            }
            else if(result > 0) { //checks if target is above our current spot
                highIndex=midIndex-1;
                return recSearch(words, target);
            }
        }
        throw new ItemNotFoundException("Item was not located");
    }
    
}
