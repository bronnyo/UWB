
/**
 * Pizza exception extends exception and delivers a message when 
 * an error occurs throughout the pizza simmulator
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018) 
 */
public class PizzaException extends Exception
{
    public PizzaException(){
        super("Pizza Error");
    }
    public PizzaException(String message){
        super(message);
    }
}
