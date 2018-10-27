import java.util.Arrays;
/**
 * Stack generates a list that follows a 
 * "First in Last out" ruling with its listed objects
 * As such it an object cannot be extracted from the 
 * "middle" of the stack. However the stack may be 
 * restacked, or poped to obtain such an object.
 *
 * @author (Krystle S Levin)
 * @version (January 25th 2018)
 */
public class Stack
{
    // instance variables
    private Object[] dataStack; 
    private int indexOfTop;
    
    //Default Contructor:
    public Stack(){
        dataStack=new Object[100];
        indexOfTop=-1;
    }
    //Contructor to allow size specifications:
    public Stack(int reserve){
        if(reserve<=0)
            stackException("Cannot create an empty stack");
            else
            dataStack=new Object[reserve];
        indexOfTop=-1;
    }
    //Adds new object to top of stack:
    public void push(Object a){
        if(!full()){
            indexOfTop++;
            dataStack[indexOfTop]=a;
        }
        else    stackException("Error, Stack is full");
    }
    //Removes object from the "top" of the stack
    public Object pop(){
        Object toPop=-1;
        if(!empty()){
            toPop=dataStack[indexOfTop];
            dataStack[indexOfTop]=null;
            indexOfTop--;
        }
        else    stackException("Error, Stack is empty");
        return toPop;
    }
    //returns the item at the "peek" (the top) of the stack without removing it
    public Object peek(){
        if(!empty())
            return dataStack[indexOfTop];
        else    stackException("Error, Stack is empty");
        return "";
    }
    //returns the object at the bottom without removing it
    public Object bottom(){
        if(!empty()){
            return dataStack[0];
        }
        else    stackException("Error, Stack is empty");
        return "";
    }
    //restacks object list such that the top item becomes the bottom and vice versa
    public void restack(){
        Object temp;//allows for swapping numbers
        if(!empty()){
            for(int i=0; i<indexOfTop/2; i++){//restacks the "pile"
                temp=dataStack[i];
                dataStack[i]=dataStack[indexOfTop-i];
                dataStack[indexOfTop-i]=temp;
            }
        }
        else    
            stackException("Error, Stack is empty");
    }
    //Allows for the search of a specific object and returns its index
    public Object search(Object searchFor){
        if(!empty()){
            for (int i=indexOfTop; i>=0; i--){//Searching through each element of the list
                if(dataStack[i]==searchFor)
                    return i;
            }    
        }   
        else    
            stackException("Error, Stack is empty");
            
        return ("that could not be found");
    }
    //returns the size of the stack
    public int size(){
        return indexOfTop+1;
    }
    //converts the stack into one string
    public String toString(){//Shows the contents of the data structure in a FILO ordering
        String stackContents="";
        if(!empty()){
            for (int i=indexOfTop; i>=0; i--)
                stackContents+=dataStack[i];
        }
        return stackContents;
    }
    //Checks if stack is empty
    public boolean empty(){
        if(indexOfTop==-1){
            return true;
        }
        return false; 
    }
    //resizes stack if more space is necessary
    public boolean full(){
        if(indexOfTop+1==dataStack.length){ //checks if full
            dataStack=Arrays.copyOf(dataStack, dataStack.length+1); //increases by 1
            //stackException("Warning: stack is in overflow memory"); //notifies user of resize
        }
        return false;
    }
    //Checks if two stacks are the same
    //Character and String objects will only return true if their cases are equal
    public boolean equals(Stack compareTo){
        boolean same=true;
        if (this.indexOfTop!=compareTo.indexOfTop) //checks if different number of indicies are used
            same=false;
        else if(this.indexOfTop==compareTo.indexOfTop){ 
            for(int i=0; i<this.dataStack.length; i++){ 
                //loop filters through each element of the stack
                if(this.dataStack[i]!=compareTo.dataStack[i]) //determines !equal
                    same=false;
            }
        }
        return same;
    }
    //allows error message to be sent in other methods
    public void stackException(String message){
        System.out.println(message);
    }
    //returns the stack
    public Object[] getDataStack(){
        return dataStack;
    }
    //returns the last index filled in the stack
    public int getIndexOfTop(){
        return indexOfTop;
    }
}
