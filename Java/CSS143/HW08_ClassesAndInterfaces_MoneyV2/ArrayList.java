import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Array List is a call by reference list
 * that is composed of nodes as such it has
 * no definite size and grows as what is needed
 * by the method calling it.
 *
 * @author (Krystle S Levin)
 * @version (March 1st 2018)
 */
public class ArrayList<E> implements Iterable{
    /**
     * Node is a helper class of the Array List
     */
    public class Node{
        private E data; 
        private Node link;
        //constructors
        public Node(){
            data=null;
            link=null;
        }
        public Node(E newItem, Node linkValue){
            link=linkValue;
            data=newItem;
        }
    }//end of Node Inner Class
    //Instance variables of Array List
    private Node head;
    private ArrayIterator itt;
    //Constructor
    public ArrayList(){
        head=null;
        itt=new ArrayIterator();
    }
    /**
     * Method: void insert(E item, int Index)
     * Pre-condition: Index does not exceed the size of the Array and newItem is not null
     * post-condition: the new Item wil be inserted at the specified index.
     */
    public void insert(E newItem, int index){
        if(index>= size() && index!=0)
                throw new NoSuchElementException();
        
        if(index==0)
                head=new Node(newItem, head);
        else{
            itt.current=head;
            itt.previous=null;
            
            for(int i=0; i<index+1; i++){
                itt.previous=itt.current;
                itt.current=itt.current.link;
            }
            if(itt.current==null && itt.previous!=null)//adding to the end of the list
                itt.previous.link=new Node(newItem, null);
            else{
                 Node temp=new Node(newItem, itt.current);
                 itt.previous.link=temp;
                 itt.previous=temp;
            }
        }
    }
    /**
     * Method: E remove(int index)
     * pre-condition: index is less than the size of the list and greater than 0.
     * post-condition: remove will remove and return the object data at the specified index
     */
    public E remove(int index){
        if(index>= size() || index<0)
            throw new NoSuchElementException();
                
        itt.current=head;
        itt.previous=null;
        
        for(int i=0; i<index; i++){
            itt.previous=itt.current;
            itt.current=itt.current.link;
        }
        E temp=itt.current.data;
        itt.remove();
        return temp;
    }
    /**
     * Method: int indexOf(E target)
     * Pre-Condition: target is not null and exists in the list
     * Post-condition: indexOf will return the index of the target item, provided it exists in the list
     */
    public int indexOf(E target){
        int index=0;
        itt.current=head;
        itt.previous=null;
        Bill find=new Bill((Bill)target);
        Bill itemAtPosition;
        while(itt.hasNext()){
            itemAtPosition=new Bill((Bill)itt.current.data);  
            if(find.compareTo(itemAtPosition)==0)
                return index;   
            itt.current=itt.current.link; //moves onto next node in the list
            index++;
        }
        return -1;// target was not found
    }
    /**
     * Method: E get(int index)
     * Pre-Condition: index is less than the size of the array and greater than 0
     * Post-Condition: get will return the object data at the specified index
     */
    public E get(int index){
        if(index>= size() || index<0)
            throw new NoSuchElementException();
            
        itt.current=head;
        itt.previous=head.link;
        for(int i=0; i<index; i++){ 
            itt.previous=itt.current;
            itt.current=itt.current.link;
        }
        return itt.current.data;
    }
    /**
     * size() following returns the number of nodes in the list
     */
    public int size(){
        int count=0;
        Node position=head;
        while(position!= null){
            count++;
            position=position.link;
        }
        return count;
    }
    /**
     * isEmpty() returns true iff head!=null;
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
            ArrayList otherList=(ArrayList)other;
            if(this.size()!=otherList.size())
                return false;
            Node position=this.head;
            Node otherPosition=otherList.head; 
            while(position!=null){
                if(!(position.data.equals(otherPosition.data)))
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
            return "List is empty";
            
        itt.current=head;
        itt.previous=null;
        while(itt.hasNext()){
            contents += itt.current.data.toString()+" %n";
            itt.current=itt.current.link;
        }
        return contents;
    }
    
    public Iterator iterator(){
        return itt;
    }
    /**
     * The ArrayIterator class is a private helper class specific to ArrayList
     * ArrayIterator helps to keep track of position within the list 
     * This helper method allows ArrayList to call by reference.
     */
    private class ArrayIterator implements Iterator{
        private Node current;
        private Node previous;
        ArrayIterator(){
            current=head;
        }
        /**
         * @Override:
         * Method: E next()
         * pre-condition: the list is not empty and there exists an element in the next position
         * post-condition: next() will return the object data located in the following index of the list
         */
        public E next(){
            if(!(hasNext()))
                throw new NoSuchElementException();
            previous=current;
            current=current.link;
            return previous.data;
        }
        /**
         * @Override:
         * Method: boolean hasNext()
         * returns true if current does not equal null
         */ 
        // (i realize it would make more sense if it read as current.link!=null but
        //   my while loops work this so, if it ain't broke...)
        public boolean hasNext(){
            return current!=null;
        }
        /**
         * @Override:
         * Method: void remove()
         * Pre-condition: the list is not null
         * postcondition: item at current will be removed from the list
         */
        public void remove(){
            if(current==null)
                throw new NoSuchElementException();
            else if(previous==null){
                head=head.link;
                current=head;
            }
            else{//previous current and current are both nodes
                previous.link=current.link;
                current=current.link;
            }
        }
    }
}
