import java.util.NoSuchElementException;
import java.util.Iterator;
/**
 * Write a description of class LinkedList2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedList2<T> implements Iterable
{
    private class Node{
        private String item;
        private Node link;
        public Node(){
            link=null;
            item=null;
        }
        public Node(String newItem, Node linkValue){
            link=linkValue;
            item=newItem;
        }
    }//end of Node Inner Class
    public Iterator iterator(){
        return new List2Iterator();
    }
    public class List2Iterator implements Iterator {
        private Node position;
        private Node previous;
        public List2Iterator(){
            position=head;
            previous=null;
        }
        public void restart(){
            position=head;
            previous=null;
        }
        public String next(){
            if(!(hasNext()))
                throw new NoSuchElementException();
            String toReturn=position.item; 
            previous=position;
            position=position.link;
            return toReturn;
        }
        public boolean hasNext(){
            return (position!=null);
        }
        public String peek(){
            if(!hasNext())
                throw new NoSuchElementException();
            return position.item;
        }
        /**
         * Adds a node before the node at the location position
         * "previous" is placed at the new node. If has next() is false then
         * the node is added to the end of the list.
         * if the list is empty the inserted node is the only node.
         */
        public void addHere(String newData){
            if(position==null && previous!=null)//adding to the end of the list
                previous.link=new Node(newData, null);
            else if(position==null ||previous==null)//list is empty or position is the head
                LinkedList2.this.addToStart(newData);
            else{
                Node temp=new Node(newData, position);
                previous.link=temp;
                previous=temp;
            }
        }
        /**
         * Changes the string in the node at location position
         * Throws and exception if the position is not a node.
         */
        public void changeHere(String newData){
            if(position==null)
                throw new NoSuchElementException();
            position.item=newData;
        }
        /**
         * Deletes the node at location position and moves position to 
         * the "next" node. Throws and exception if the list is empty
         */
        public void delete(){
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
        }        
    }
    //public List2Iterator iterator(){ 
     //       return new List2Iterator();
       // }
    
    private Node head;
    public LinkedList2(){
        head=null;
    }
    /**
     * The following adds a node at the start of the list with specified data.
     * The node will be the first node in the list.
     */
    public void addToStart(String itemName){
        head=new Node(itemName, head);
    }
    
    /**
     * The following removes the head node and makes the next node in the list the new head.
     * Will return true if there exists at least one node in the list and false otherwise.
     */
    public boolean deleteHeadNode(){
        if(head!=null){
            head=head.link; 
            return true;
        }
        else return false;
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
    
    /**
     * Finds the first Node containing the target Item and returns a reference to that Node
     * If target is not in the list the method returns null.
     */
    private Node find(String target){
        Node position=head;
        String itemAtPosition;
        
        while(position!=null){
            itemAtPosition=position.item; 
            if(itemAtPosition.equals(target))
                return position;
            position=position.link; //moves onto next node in the list
        }
        return null; //target was not found
    }
    public boolean contains(String item){
        return(find(item)!=null); //If null, item was not found
    }
    public void outputList(){
        Node position=head;
        while(position!=null){
            System.out.println(position.item);
            position=position.link;
        }
    }
    /**
     * The following determines if two lists are equal
     */
    public boolean equals(Object other){
        if(other==null)
            return false;
        else if(this.getClass()!=other.getClass())
            return false;
        else{
            LinkedList2 otherList=(LinkedList2)other;
            if(this.size()!=otherList.size())
                return false;
            Node position=this.head;
            Node otherPosition=otherList.head;
            while(position!=null){
                if(!(position.item.equals(otherPosition.item)))
                    return false;
                position=position.link;
                otherPosition=otherPosition.link;
            }
        }
        return true;//a mismatch was not found
    }
}
