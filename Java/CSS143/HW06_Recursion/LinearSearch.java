import java.util.Arrays;

/**
 * Linear seach is a sub class of the class SearchAlgorithm
 * Linear search is best implemented with a itterative approach
 * Recursive searching is not advised when searching linearly.
 *
 * @author (Krystle S Levin)
 * @version (February 16th, 2018)
 */
public class LinearSearch extends SearchAlgorithm 
{
    /**
     * Method: Search 
     * Pre-condition:   Words is a nonempty array of Strings, and target is a non-null string 
     *                  to search for in our collection of strings
     *                  
     * Post-Condition:  The method will return the position of the list in which the desired
     *                  word can be found, provided that the word exists in the list. 
     *                  Search uses an itterative Linear method to accomplish this task.
     */  
    public int search(String[] words, String target)        throws ItemNotFoundException{
        
        while(getCount()<words.length){
            incrementCount();
            if(words[getCount()-1].equals(target))
                return getCount()-1;
            
        }
        throw new ItemNotFoundException("Item was not located");
    }
    public String[] temp;//Was used in attempt at recursive searching
    /**
     * Method: recSearch 
     * Pre-condition:   Words is a nonempty array of Strings that has a length smaller than 3000,
     *                  and target is a non-null string to search for in our collection of strings
     *                  
     * Post-Condition:  The method will return the position of the list in which the desired
     *                  word can be found, provided that the word exists in the list. 
     *                  Search uses an recursive binary method to accomplish this task.
     */ 
    public int recSearch(String[] words, String target)     throws ItemNotFoundException{
        if(words.length>3000)
            throw new ItemNotFoundException(" Sorry, array will result in an "+
                                            "overflow error if searched recursively."+
                                            "\n              Please use itterative search or nodes");
        if(words.length>0 && target!=null){
            temp=words;
            return recursion(getElement(), target);
        }
        throw new ItemNotFoundException();
    } 
    /**
     * Method: recursion 
     * Pre-condition:   String compare and String target are non null in addition to the String 
     *                  in which compare is extracted from is also non null.
     * Post-Condition:  The method will return the position of the list in which the desired
     *                  word can be found, provided that the word exists in the list. 
     *                  Search uses an recursive linear method to accomplish this task.
     */ 
    public int recursion(String compare, String target)     throws ItemNotFoundException{
        if(getCount()<temp.length && compare!=null){
            System.out.println(super.getCount());
            incrementCount();
            System.out.println(super.getCount());
            if (compare.equals(target))
                return (super.getCount()-1);
            else
                return recursion(getElement(), target);
            
        }
        throw new ItemNotFoundException("Item was not located");
    }
    /**
     * Method: getElement 
     * Pre-condition:   Temp has been initialized to a non empty array of strings and super.getCount()
     *                  is greater than 0.
     * Post-Condition:  The method will return a single element from the String array temp
     */ 
    public String getElement(){
        return temp[super.getCount()]; 
    }
}
//425-643-3400
