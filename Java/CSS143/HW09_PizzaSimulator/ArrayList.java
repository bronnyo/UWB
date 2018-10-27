import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Array ArrayList is a call by reference ArrayList
 * that is composed of nodes as such it has
 * no definite size and grows as what is needed
 * by the method calling it.
 *
 * @author (Krystle S Levin) 
 * @version (March 1st 2018  (updated: 03/09/2018)
 */
public class ArrayList<E> implements Iterable{
    /**
     * Node is a helper class of the Array ArrayList
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
    //Instance variables of Array ArrayList
    private Node head;
    private ArrayIterator itt;
    //Constructor
    public ArrayList(){
        head=null;
        itt=new ArrayIterator();
    }
    /**
     * Method: add(E item)
     * Pre-condition: item is not null
     * Post-Condition: Item will be added at "start" of the ArrayList
     */
    public void add(E item){
        if(item==null){
            throw new NoSuchElementException();
        }
        head=new Node(item, head);    
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
            if(itt.current==null && itt.previous!=null)//adding to the end of the ArrayList
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
     * pre-condition: index is less than the size of the ArrayList and greater than 0.
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
     * Pre-Condition: target is not null and exists in the ArrayList
     * Post-condition: indexOf will return the index of the target item, provided it exists in the ArrayList
     */
    public int indexOf(E target){
        int index=0;
        itt.current=head;
        itt.previous=null;
        E find=((E)target);
        E itemAtPosition;
        while(itt.hasNext()){
            itemAtPosition=((E)itt.current.data);  
            if(find.equals(itemAtPosition))
                return index;   
            itt.current=itt.current.link; //moves onto next node in the ArrayList
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
     * Change Item changes the data value of the node at the given index.
     */
    public void changeItem(int index, E newData){
        itt.current=head;
        itt.previous=head.link;
        for(int i=0; i<index; i++){ 
            itt.previous=itt.current;
            itt.current=itt.current.link;
        }
        itt.current.data=newData;
    }
    /**
     * size() following returns the number of nodes in the ArrayList
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
     * pre-condition: The other Object is of the type ArrayList and contains 
     *                the same elements in the same order
     * postcondition: Wil return true if preconditions are met and false otherwise.
     */
    public boolean equals(Object other){
        if((other==null && this!=null) || other!=null && this==null)
            return false;
        else if(this.getClass()!= other.getClass())
            return false;
        else{
            ArrayList otherArrayList=(ArrayList)other;
            if(this.size()!=otherArrayList.size())
                return false;
            Node position=this.head;
            Node otherPosition=otherArrayList.head; 
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
     * pre-condition: the ArrayList is non-empty
     * postcondition: a String containing all elements of the ArrayList will be returned.
     */
    public String toString(){ 
        String contents="";
        if(isEmpty())
            return "ArrayList is empty";
            
        itt.current=head;
        itt.previous=null;
        while(itt.hasNext()){
            contents += itt.current.data.toString()+" \n";
            itt.current=itt.current.link;
        }
        return contents;
    }
    
    public Iterator iterator(){
        return itt;
    }
    /**
     * The ArrayIterator class is a private helper class specific to ArrayList
     * ArrayIterator helps to keep track of position within the ArrayList 
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
         * pre-condition: the ArrayList is not empty and there exists an element in the next position
         * post-condition: next() will return the object data located in the following index of the ArrayList
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
         * Pre-condition: the ArrayList is not null
         * postcondition: item at current will be removed from the ArrayList
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
