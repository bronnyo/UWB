import java.util.Arrays;
/**
 * ArrayList is an abstract list that can be
 * used with any object type. Elements may be 
 * added, deleated, or extracted in any arbitrary
 * order. 
 *
 * @author (Krystle S Levin)
 * @version (January 25th 2018)
 */
public class ArrayList
{
    // instance variables:
    private Object[] arrayList;
    private int listSize;
    
    //Default Constructor
    public ArrayList(){
        arrayList=new Object[100];
        int listSize=0;
    }
    //Constructor with specified list length
    public ArrayList(int definedSize){
        arrayList=new Object[definedSize];
        int listSize=0;
    }
    
    //full() increases the size of array as needed, by 1 to conserve as much memory as possible
    public boolean full(){
        if(listSize==arrayList.length){
            arrayList=Arrays.copyOf(arrayList, arrayList.length+10);
        }
        return false;
    }
    //Adds object at specified index, and shifts elements as needed.
    //Pre-Condition: specified index is within the bounds of the list.
    public void insert(Object add, int index){
        if(!full()){//increases size of list if necessary
            if(index<this.listSize){
                for(int i=listSize+1; i>index; i--)
                    arrayList[i]=arrayList[i-1];
                arrayList[index]=add;
                listSize++;
            }
            else if(index==listSize){
                arrayList[index]=add;
                this.listSize++;            
            }
            else
                arrayListException("Index out of bounds");
        }
    }
    //Replaces an object directly such that the list needs no post shifting
    //Pre-Condition: the index is within the bounds of the non empty list
    public void replace(Object replaceWith, int index){
        if(!empty()&& index<listSize){//checks index is within the bounds and list !empty
            arrayList[index]=replaceWith;
        }
        else
            arrayListException("Error list is empty or index is out of bounds");
    }
    //Removes and returns the object at the specified index and shift elements as needed
    //Pre-Condition: index must be within the bounds of the array and the array is not empty
    public Object remove(int index){        
        Object toReturn=0;
        if(!empty()&& index<listSize){//checks index is within the bounds and list !empty
            toReturn=arrayList[index];
            if(index!=listSize-1){ //check if index is not the last index
                for (int i=index; i<listSize-1;i++) //removes and shifts
                    arrayList[i]=arrayList[i+1];    
                arrayList[listSize-1]=null;
                listSize--;    
            }
            else{//removes last indexed object
                arrayList[listSize-1]=null;
                listSize--;
            }
        }
        else
            arrayListException("Error list is empty or index is out of bounds");
        return toReturn;
    } 
    //searches through List to find a specific object
    public Object indexOf(Object searchFor){
        //Returns -1 if not found
        if(!empty()){
            for (int i=0; i<listSize; i++){
                if(arrayList[i]==searchFor)
                    return i;
            }    
        }   
        else    arrayListException("Error, Stack is empty");
        return "is not in the list";  
    }
    //returns the object at the specified index
    //Pre-Condition: the specified index is within the bounds of the list.
    public Object get(int index){
        if(index<listSize && !empty())
            return arrayList[index];
        else
            arrayListException("That index does not exist");
        return "Error";
    }
    //Shows the contents of the data structure in a "natural" ordering (left to right i.e 0 to n)
    public String toString(){
        String contents="";
        if(!empty()){
            for(int i=0; i<listSize; i++)//adds list elements to one String
                contents+=arrayList[i];
        }
        return contents;
    }
    //Checks if Array list is empty:
    public boolean empty(){
        if(listSize==0){
            return true; 
        }
        return false;
    } 
    //Determines if two ArrayLists are equal to one another in size and contents
    //Character and String objects will only return true if their cases are equal
    public boolean equals(ArrayList other){
        boolean same=true;
        if (this.listSize!=other.listSize)//check if they use same number of elements
            same=false;
        else if(this.listSize==other.listSize){
            for(int i=0; i<this.listSize; i++){ //checks if each element of the lists are equal
                if(this.arrayList[i]!=other.arrayList[i])
                    same=false;
            }
        }
        return same; 
    }
    //Allows for error message throughout the methods of the class
    public void arrayListException(String message){
        System.out.println(message);
    }
    //returns the size of the array list:
    public int size(){
        return listSize;
    }
    //returns the reserved memory of the list
    public int length(){
        return arrayList.length;
    }
    //returns the array list itself.
    public Object[] getArrayList(){
        return arrayList;
    }
}
