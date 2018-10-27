
/**
 * Write a description of class LinkedList1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedList1
{
    private Node1 head;
    public LinkedList1(){
        head=null;
    }
    
    /**
     * The following adds a node at the start of the list with specified data.
     * The node will be the first node in the list.
     */
    public void addToStart(String itemName, int itemCount){
        head=new Node1(itemName, head, itemCount);
    }
    
    /**
     * The following removes the head node and makes the next node in the list the new head.
     * Will return true if there exists at least one node in the list and false otherwise.
     */
    public boolean deleteHeadNode(){
        if(head!=null){
            head=head.getLink(); 
            return true;
        }
        else return false;
    }
    
    /**
     * The following returns the number of nodes in the list
     */
    public int size(){
        int count=0;
        Node1 position=head;
        while(position!= null){
            count++;
            position=position.getLink();
        }
        return count;
    }
    
    /**
     * Finds the first Node containing the target Item and returns a reference to that Node
     * If target is not in the list the method returns null.
     */
    private Node1 find(String target){
        Node1 position=head;
        String itemAtPosition;
        
        while(position!=null){
            itemAtPosition=position.getItem(); 
            if(itemAtPosition.equals(target))
                return position;
            position=position.getLink(); //moves onto next node in the list
        }
        return null; //target was not found
    }
    public boolean contains(String item){
        return(find(item)!=null); //If null, item was not found
    }
    public void outputList(){
        Node1 position=head;
        while(position!=null){
            System.out.println(position.getItem()+" "+position.getCount());
            position=position.getLink();
        }
    }
}
