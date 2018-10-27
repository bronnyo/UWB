import java.util.Iterator;
/**
 * Write a description of class ImpelementingIterator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ImpelementingIterator implements Iterable<Object>
{
    public Iterator<Object> iterator(){
        Iterator<Object> it =new Iterator<Object>(){
            private int currentIndex=0;
            
            public boolean hasNext(){
                return false;
            }
            public Object next(){
                return 0;
            }
            public void remove(){
                
            }
        };
        return it;
    }
}
