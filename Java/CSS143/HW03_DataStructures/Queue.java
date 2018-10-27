import java.util.Arrays;
/**
 * Queue generates a list abstact objects that follows a 
 * "First in First out" ruling with its listed objects.
 * As such its objects cannot be extracted from the
 * "middle" of the queue, and must wait to be dequeued
 * until those that were queued before it are dequeued
 * first.
 * 
 *
 * @author (Krystle S Levin)
 * @version (January 25th 2018)
 */
public class Queue
{
    // instance variables
    private Object[] dataQueue;
    private int indexOfLastIn;
    //Default constructor
    public Queue(){
        dataQueue=new Object[100];
        indexOfLastIn=-1;
    }
    //Constructor with specified size:
    public Queue(int specifiedSize){
        dataQueue=new Object[specifiedSize];
        indexOfLastIn=-1;
    }
    //Adds new object to the queue:
    public void enqueue(Object a){
        if(!full()){
            indexOfLastIn++;
            dataQueue[indexOfLastIn]=a;
        }
    }
    //removes and returns the first element of the queue and shifts the remaining
    public Object dequeue(){
        Object toDequeue=0;
        if(!empty()){
            toDequeue=dataQueue[0];
            for(int i=0; i<indexOfLastIn; i++){//shifts remaining queue elements
                dataQueue[i]=dataQueue[i+1];
            }
            dataQueue[indexOfLastIn]=null;
            indexOfLastIn --;
        }
        else    queueException("Error, Queue is empty");
        return toDequeue;
    }
    //returns the size of the queue:
    public int size(){
        return indexOfLastIn+1;
    }
    //show the contents of the data structure in a FIFO ordering
    public String toString(){ 
        String queueContents="";
        if(!empty()){
            for (int i=0; i<=indexOfLastIn; i++)//Adding contents of queue to the string
                queueContents+=dataQueue[i];
        }
        else    
            queueException("Error, Queue is empty");
            
        return queueContents;
    }
    //compares this queue to another queue and determines if they're equal
    //Character and String objects will only return true if their cases are equal
    public boolean equals(Queue other){
        boolean same=true;
        if (this.indexOfLastIn!=other.indexOfLastIn)//checks is number of elements are equal
            same=false;
        else if(this.indexOfLastIn==other.indexOfLastIn){
            for(int i=0; i<=this.indexOfLastIn; i++){       //filters through each element to
                if(this.dataQueue[i]!=other.dataQueue[i])   //determine total queue equality
                    same=false;
            }
        }
        return same; 
    }
    //determines if queue is empty
    public boolean empty(){
        if(indexOfLastIn==-1){
            return true; 
        }
        return false;
    } 
    //resizes queue if neccessary
    public boolean full(){
        if(indexOfLastIn+1==dataQueue.length){
            dataQueue=Arrays.copyOf(dataQueue, dataQueue.length+1);
        }
        return false;
    }
    //allows for error messages throughout class methods
    public void queueException(String message){
        System.out.println(message);
    }
    //returns the data queue (getter method);
    public Object[] getDataQueue(){
        return dataQueue;
    }
}
