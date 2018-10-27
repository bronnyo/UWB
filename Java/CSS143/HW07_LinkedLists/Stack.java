
/**
 * Write a description of class Stack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stack extends List
{
    public Stack(){
        super();
    }
    public Stack(Stack other){
        super(other);
    }
    /**
     * push adds a new element to the top of the stack
     */
    public void push(Object next){
        if(super.size()==0)
            append(next);
        else
            super.insert(next,0);
    }
    /**
     * The following method returns the object from the "top" of the stack
     * provided that the stack is not null
     */
    public Object pop(){
        
        return super.remove(0);
    }
   
 }
