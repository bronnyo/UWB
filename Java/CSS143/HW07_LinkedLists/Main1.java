import java.util.Iterator;
/**
 * Write a description of class Main1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main1
{
    public static void main(String[] args){
        System.out.println("Linked List 1 Demo:");
        LinkedList1 test=new LinkedList1();
        
        test.addToStart("Moo", 4);
        test.addToStart("haha", 8);
        test.deleteHeadNode();
        test.addToStart("Cow",9);
        test.addToStart("Chocolate", 3);
        test.addToStart("Milk", 126);
        
        System.out.println("Contains haha: "+test.contains("haha"));
        System.out.println("Size of List: "+test.size());
        test.outputList();
        
        System.out.println();
        
        System.out.println("Linked List 2 Demo:");
        
        LinkedList2 list=new LinkedList2();
        Iterator i=list.iterator();  
        
        list.addToStart("shoes");
        list.addToStart("hats");
        list.addToStart("pants");
        
        System.out.println("List contains:");
        //i.restart(); 
        while(i.hasNext())
            System.out.println(i.next());
        System.out.println();
        
        //i.restart();
        i.next();
        System.out.println("Deleting: ");//+i.peek());
        //i.delete();
        System.out.println("List now contains:");
        //i.restart();
        while(i.hasNext())
            System.out.println(i.next());
        System.out.println();
        
        //i.restart();
        i.next();
        System.out.println("Addind a node before ");//+i.peek());
        //i.addHere("shirt");
        System.out.println("List now contains:");
        //i.restart();
        while(i.hasNext())
            System.out.println(i.next());
        System.out.println();
        
        
        System.out.println("Now changing all items to diamonds:");
        //i.restart();
        while(i.hasNext()){
            //i.changeHere("Diamonds");
            i.next();
        }
        System.out.println();
        System.out.println("List now contains:");
        //i.restart();
        while(i.hasNext())
            System.out.println(i.next());
        System.out.println();
        
    }
}
