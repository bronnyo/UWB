import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Write a description of class ArrayListV1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayListV1<E> implements Iterable{
    public class Node{
        private E data; 
        private Node link;
        public Node(){
            data=null;
            link=null;
        }
        public Node(E newItem, Node linkValue){
            link=linkValue;
            data=newItem;
        }
    }//end of Node Inner Class
    private Node head;
    private ArrayIterator itt;
    public ArrayListV1(){
        head=null;
        itt=new ArrayIterator();
    }
    /**
     * The following returns the number of nodes in the list
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
    public boolean isEmpty(){
        return (head==null);
    }
    public boolean equals(Object other){
        if((other==null && this!=null) || other!=null && this==null)
            return false;
        else if(this.getClass()!= other.getClass())
            return false;
        else{
            ArrayListV1 otherList=(ArrayListV1)other;
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
            contents += itt.current.data+" ";
            itt.current=itt.current.link;
        }
        return contents;
    }
    
    public Iterator iterator(){
        return itt;
    }
    public class ArrayIterator implements Iterator{
        private Node current;
        private Node previous;
        ArrayIterator(){
            current=head;
        }
        //@Override:
        public E next(){
            if(!(hasNext()))
                throw new NoSuchElementException();
            previous=current;
            current=current.link;
            return previous.data;
        }
        //@Override:
        public boolean hasNext(){
            return current!=null;
        }
        //@Override:
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
        public void remove(int index){
            if(isEmpty() || index>=size())
            throw new NoSuchElementException();
            current=head;
            previous=null;
            for(int i=0; i<index; i++){ 
                previous=current;
                current=current.link;
            }
            
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
        public E atIndex(int index){
            current=head;
            previous=null;
            for(int i=0; i<index; i++){ 
                previous=current;
                current=current.link;
            }
            return current.data;
        }
        public int indexOf(E target){
            int index=0;
            current=head;
            previous=null;
            E itemAtPosition;
            while(hasNext()){
                itemAtPosition=current.data;  
                if(itemAtPosition.equals(target))
                    return index;   
                current=current.link; //moves onto next node in the list
                index++;
            }
            return -1;// target was not found
        }
        public void add(int index, E newData){
            if(index>= ArrayListV1.this.size())
                throw new NoSuchElementException();
            
            if(index==0)
                head=new Node(newData, head);
            else{
                E garbage;
                for(int i=0; i<index+1; i++){
                    garbage=next();
                }
                current=head;
                previous=null;
                
                if(current==null && previous!=null)//adding to the end of the list
                    previous.link=new Node(newData, null);   
                else{
                    Node temp=new Node(newData, current);
                    previous.link=temp;
                    previous=temp;
                }
            }
        }
        public void change(E replaceWith){
            if(current==null)
                throw new NoSuchElementException();
            current.data=replaceWith;
        }
    }
    
}
