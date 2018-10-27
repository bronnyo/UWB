
/**
 * USE A DOUBLY LINKED LIST (pg 852)...maybe
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Queue extends List
{
    public Queue(){
        super();
    }
    public Queue(Queue other){
        super(other);
    }
    /**
     * Method: enqueue(Object next)
     * precondition: next is not null
     * posCondition: next will be inserted at position 0
     */
    public void enqueue(Object next){
        append(next);

    }
    /**
     * Method: dequeue()
     * precondition: the Queue is not null
     * postCondition: the element at the "back of the line" will be removed 
     *                from the queue and returned.
     */
    public Object dequeue(){
        return super.remove(super.size()-1);
    }
    
}
