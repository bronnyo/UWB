
import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * Write a description of class ListWithIterator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListWithIterator{
    public class Node{
        private Object item; 
        private Node link;
        public Node(){
            link=null;
            item=null;
        }
        public Node(Object newItem, Node linkValue){
            link=linkValue;
            item=newItem;
        }
    }//end of Node Inner Class
    //Instance Variables
    private Node head;
    private Node position;
    private Node previous;
    
    //Constructor
    public ListWithIterator(){
        head=null;
        position=head;
        previous=null;
    }
    public ListWithIterator(ListWithIterator other){
        for(int i=0; i<other.size(); i++)
            append(other.atIndex(i));
    }
    public void restart(){ 
         position=head;
         previous=null;
     } 
     
    //***** Insert Methods *****//
    /**
     * Method: Insert
     *  Pre-Condition: The list-length is greater than the desired index in which 
     *                 the node is to be inserted at
     * Post-Condition: following a node will be added at the indicated index
     */
    public void insert(Object data, int index){
        if(index>=size()){
            System.out.println("Sorry "+index+" is not an index of the list");
        }
        else{
            restart();
            for(int i=0; i<index+1; i++){ 
                previous=position;
                position=position.link;
            }
            
            if(position==null && previous!=null)//adding to the end of the list
                previous.link=new Node(data, null);
            else if(position==null ||previous==null)//list is empty or position is the head
                head=new Node(data, head);
            else{
                 Node temp=new Node(data, position);
                 previous.link=temp;
                 previous=temp;
            }
        }
    }
    /**
     * Method: append
     *  Pre-Condition: Next is not null
     * Post-Condition: The object next will be added to the end of the list
     */
    public void append(Object next){
        if(next==null)
            throw new NoSuchElementException();
        
        if(isEmpty()){
            head=new Node(next, head);
            restart();
        }
        else
            insert(next, size()-1);
    }
    
    //***** Removal Methods *****//
    /**
     * Method: delete()
     *  Pre-Condition: The ListWithIterator is non-empty && the specified index does 
     *                 not exceed the size of the list.
     * Post-Condition: The item at the specified index will be deleated
     */
    public void delete(int index){
        if(isEmpty() || index>=size())
            throw new NoSuchElementException();
        
        Object garbage=remove(index);
        garbage=null;
    }
    /**
     * Method: Remove
     *  Pre-Condition: The specified index is not null, that is an element exists at position index
     * Post-Condition: The node at the specified index will be removed, and return the data thereof.
     */
    public Object remove(int index){
        if(isEmpty() || index>=size())
            throw new NoSuchElementException();
            
        restart();
        for(int i=0; i<index; i++){ 
            previous=position;
            position=position.link;
        }
        
         Object toReturn=position.item;
         
        if(position==null)
            throw new NoSuchElementException();
        else if(previous==null){
            head=head.link;
            position=head;
        }
        else{//previous position and position are both nodes
            previous.link=position.link;
            position=position.link;
        }
        return toReturn;
    }
    
    //***** Reference Methods *****//
    /**
     * Method: atIndex()
     * pre-condition: the list is not empty and the index does not exceed the size of the list
     * postcondition: Will return the bject at the specified index
     */
    public Object atIndex(int index){
        if(isEmpty() || index>=size())
            throw new NoSuchElementException();
        
        restart();
        for(int i=0; i<index; i++){ 
            previous=position;
            position=position.link;
        }   
        return position.item;
    }
    /**
     * Method: indexOf()
     * pre-condition: The target object exists in the list, ie the list is not empty
     * postcondition: will return the index of the target object is it exists, 
     *                will return -1 otherwise
     */    
    public int indexOf(Object target){
        if(isEmpty())
            throw new NoSuchElementException();
        
        int index=0;
        restart();
        Object itemAtPosition;
        
        while(position!=null){
            itemAtPosition=position.item;  
            if(itemAtPosition.equals(target))
                return index;   
            position=position.link; //moves onto next node in the list
            index++;
        }
        return -1;// target was not found
    }
    
    /**
     * Method: size()
     * returns how many nodes construct the list
     */
    public int size(){
        int size=0;
        Node position=head;
        while(position!= null){
            size++;
            position=position.link;
        }
        return size;
    }
    /**
     * Method: isEmpty()
     * Pre-Condition: N/A
     * postCondition: will return false if head contains a value for item
     *                returns false if the head item is null.
     */
    public boolean isEmpty(){
        return (head==null);
    }
    
    /**
     * Method: equals()
     * pre-condition: The other Object is of the type list and contains 
     *                the same elements in the same order
     * postcondition: Wil return true if preconditions are met and false otherwise.
     */
    public boolean equals(Object other){
        if((other==null && this!=null) || other!=null && this==null)
            return false;
        else if(this.getClass()!= other.getClass())
            return false;
        else{
            ListWithIterator otherListWithIterator=(ListWithIterator)other;
            if(this.size()!=otherListWithIterator.size())
                return false;
            Node position=this.head;
            Node otherPosition=otherListWithIterator.head;
            while(position!=null){
                if(!(position.item.equals(otherPosition.item)))
                    return false;
                position=position.link;
                otherPosition=otherPosition.link;
            }
        }
        return true;//a mismatch was not found
    }
    /**
     * Method: toString()
     * pre-condition: the list is non-empty
     * postcondition: a String containing all elements of the list will be returned.
     */
    public String toString(){
        String contents="";
        if(isEmpty())
            return "ListWithIterator is empty";
            
        restart();
        while(position!=null){
            contents += position.item+" ";
            position=position.link;
        }
        return contents;
    }
}