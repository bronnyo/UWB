
/**
 * This is a sample from the text book pertaining to Nodes
 * 
 * Note: this example is that of a node consisting of two froms of data
 * both count and item are data of the node, count in no way is actually a counter
 * and can be ommitted in single data linked lists.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Node1
{
    private String item;
    private Node1 link;
    private int count;
    public Node1(){//initializes instace variables
        item=null;
        link=null;//this allows the last link to point to null
        count=0;
    }
    public Node1(String newItem, Node1 linkValue, int newCount){
        setData(newItem, newCount);
        link=linkValue;
    }
    public void setData(String newItem, int newCount){
        item=newItem;
        count=newCount;
    }
    public int getCount(){
        return count;
    }
    public Node1 getLink(){
        return link;
    }
    public String getItem(){
        return item;
    }
}
