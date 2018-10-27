import java.util.Iterator;
/**
 * Write a description of class ArrayList_TestDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayList_TestDriver
{
    public static void main(String[] args){
        System.out.println("ArrayList test:");
        
        ArrayList a=new ArrayList();
        a.insert('a', 0); 
        System.out.println(a.size());
        System.out.println(a.toString());
        
        a.insert('B',0);
        System.out.println(a.size());
        System.out.println(a.toString());
        
        a.insert('t',1);
        System.out.println(a.size());
        System.out.println(a.toString());
        System.out.println("Removing: "+a.remove(2));
        a.insert('G',a.size()-1);
        System.out.println(a.toString());
        while(!a.isEmpty()) {
            System.out.println(a.remove(0));
        }
        
        System.out.println();
        
    }
}
