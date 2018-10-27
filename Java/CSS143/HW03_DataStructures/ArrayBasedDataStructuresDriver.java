
/**
 * ArrayBasedDataStructuresDriver executes tests methods for the
 * ArrayList, Queue, and Stack classes to ensure that
 * the methods structure of which run as expected.
 *
 * @author (Krystle S Levin)
 * @version (January 25th 2018)
 */
public class ArrayBasedDataStructuresDriver
{
    public static void main(String[] args) {
        System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        System.out.println();
        
        System.out.println("Stack Tests:");
        System.out.println();
        stackTests();
        
        System.out.println();
        System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        System.out.println();
        
        System.out.println("Queue Tests:");
        System.out.println();
        queueTests();
        
        System.out.println();
        System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        System.out.println();
        
        System.out.println("Array List Tests:");
        System.out.println();
        arrayListTests();
        
        System.out.println();
        System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
    }
    private static void arrayListTests() {
        //Char Tests:
        ArrayList a = new ArrayList();
        a.insert('B', 0); 
        a.insert('a',0);
        a.insert('t',1);
        System.out.println(a.toString());
        a.remove(2);
        a.insert('B',0);
        System.out.println(a.toString());
        while(a.empty() == false) {
            System.out.println(a.remove(0));
        }
        
        System.out.println();
        
        //String Tests:
        ArrayList stringTest1= new ArrayList(1);
        stringTest1.insert("The ",0);
        stringTest1.insert("fat ",1);
        stringTest1.insert("dog ",2);
        System.out.println("String Test 1: "+stringTest1.toString());
        System.out.println("The index of \"fat\": "+stringTest1.indexOf("fat "));
        System.out.println("---------------------------");
        ArrayList stringTest2= new ArrayList(1);
        stringTest2.insert("The ",0);
        stringTest2.insert("fat ",1);
        stringTest2.insert("dog ",2);
        System.out.println("String Test 2: "+stringTest2.toString());
        System.out.println("The index of \"cat\": "+stringTest2.indexOf("cat"));
        System.out.println("---------------------------");
        ArrayList stringTest3= new ArrayList(2);
        stringTest3.insert("likes ",0);
        stringTest3.insert("eating ",1);
        stringTest3.insert("treats ",2);
        System.out.println("String Test 3: "+stringTest3.toString());
        System.out.println("The index of \"treats\": "+stringTest3.indexOf("treats "));
        System.out.println("---------------------------");
        ArrayList merged=new ArrayList(6);
        for(int i=0; i<merged.length(); i++){
            if (i<stringTest1.size())
                merged.insert(stringTest1.get(i), i);
            else
                merged.insert(stringTest3.get(i-stringTest1.size()), i);
        }
        System.out.println();        
        System.out.println("String Test Merged: "+merged.toString());
        merged.remove(1);
        merged.replace("pizza ", merged.size()-1);
        merged.replace("Frank's ",0);
        System.out.println("String Test Merged (modified): "+merged.toString());
        
        System.out.println();
        if(stringTest2.equals(stringTest1))
            System.out.println("The string lists 1 and 2 are equal");
        else
            System.out.println("The string lists 1 and 2 are not equal");
        if(stringTest3.equals(stringTest1))
            System.out.println("The string lists 1 and 3 are equal");
        else
            System.out.println("The string lists 1 and 3 are not equal");    
        while(stringTest1.empty() == false) {
            System.out.println(stringTest1.remove(0));
        }
    }
    private static void queueTests() {
        //todo: make more tests here
        Queue a = new Queue();
        a.enqueue('b'); 
        a.enqueue('a');
        a.enqueue('t');
        System.out.println("Queue \"a\": "+a.toString());
        
        Queue b=new Queue(3);
        b.enqueue('b');
        b.enqueue('a');
        b.enqueue('t');
        System.out.println("Queue \"b\": "+b.toString());
        
        Queue c=new Queue(3);
        c.enqueue('t');
        c.enqueue('a');
        c.enqueue('b');
        System.out.println("Queue \"c\": "+c.toString());
        System.out.println();
        if(b.equals(a))
            System.out.println("a and b are equal");
        else
            System.out.println("a and b are not equal");
        if(c.equals(a))
            System.out.println("a and c are equal");
        else
            System.out.println("a and c are not equal");
        System.out.println();
        c.dequeue();
        c.enqueue('o');
        c.enqueue('u');
        c.enqueue('t');
        System.out.println("Queue \"c\" (modified): "+c.toString());
        while(c.empty() == false) {
            System.out.println(c.dequeue());
        }
    }
    private static void stackTests() {
        Stack a = new Stack();
        a.push('B');
        a.push('a');
        a.push('t');
        System.out.println("First Stack: "+a.toString());
        
        Stack exceedsLength=new Stack(1);
        exceedsLength.push('B');
        exceedsLength.push('a');
        exceedsLength.push('t');
        System.out.println("Second Stack: "+exceedsLength.toString());
        
        if(exceedsLength.equals(a))
            System.out.println("The two Stacks are equal");
        else
            System.out.println("The two Stacks are not equal");
        System.out.println();
        
        System.out.println("a is located at position "+a.search('a'));
        System.out.println("z is located at position "+a.search('z'));
        System.out.println();
        
        a.restack();
        System.out.println("Restacked: "+a.toString());
        if(exceedsLength.equals(a))
            System.out.println("Restack equals original");
        else
            System.out.println("Restack does not equal original");
        
        a.restack();
        while(a.empty() == false) {
            System.out.println(a.pop());
        }
    }
}
