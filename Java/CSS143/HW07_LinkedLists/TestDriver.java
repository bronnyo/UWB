
/**
 * Write a description of class TestDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestDriver
{
    public static void main(String[] args){
        listTestDriver();
        StackTestDriver();
        queueTestDriver();
    }
    public static void queueTestDriver(){
        System.out.println();
        System.out.println("**** Queue Test ****");
        System.out.println();
        
        Queue Q1= new Queue();
        Q1.enqueue("First in,");
        Q1.enqueue("Second,");
        Q1.enqueue("Last,");
        
        Queue Q2=new Queue(Q1);
        
        System.out.println("Queue 1: "+Q1.toString());
        System.out.println("Queue 2: "+Q2.toString());
        System.out.println("Queue 1 = Queue 2: "+Q1.equals(Q2));
        
        System.out.println("De-Queue "+Q2.dequeue()+" from Queue 2");
        Q2.enqueue("Third,");
        Q2.enqueue("Fourth");
        
        System.out.println("New Queue 2: "+Q2.toString());
        System.out.println("Queue 1 = New Queue 2: "+Q1.equals(Q2));
    }
    public static void StackTestDriver(){
        System.out.println();
        System.out.println("**** Stack Test ****");
        System.out.println();
        
        Stack S1= new Stack();
        S1.push("First in,");
        S1.push("Second,");
        S1.push("Last");
        
        Stack S2= new Stack(S1);
        System.out.println("Stack 1: "+S1.toString());
        System.out.println("Stack 2: "+S2.toString());
        System.out.println("Stack 1 = Stack 2: "+S1.equals(S2));
        
        System.out.println("Popping "+S2.pop()+" from Stack 2");
        S2.push("Third,");
        S2.push("Fourth");
        
        System.out.println("New Stack 2: "+S2.toString());
        System.out.println("Stack 1 = New Stack 2: "+S1.equals(S2));
    }
    public static void listTestDriver(){
        System.out.println();
        System.out.println("**** List Test ****");
        System.out.println();
        
        List L1= new List();
        L1.append(1);
        L1.append(2);
        L1.append(3);
        List L2= new List(L1);
        
        System.out.println("List 1: "+L1.toString());
        System.out.println("List 2: "+L2.toString());
        System.out.println("List 1 = List 2 : "+L1.equals(L2));
        System.out.println();
        
        System.out.println("Removing : "+L2.remove(0)+" from index 0 of list 2");
        System.out.println("Adding: apples, bananas, amd 3.0 to list 2");
        System.out.println();
        
        L2.insert(3.0, 3);
        L2.insert("apples", 0);
        L2.insert("bananas",2);
        L2.insert(5,L2.size()-1);
        
        System.out.println();
        System.out.println("List 2: "+L2.toString());
        System.out.println("List 1 = New List 2 : "+L1.equals(L2));
    }
}
