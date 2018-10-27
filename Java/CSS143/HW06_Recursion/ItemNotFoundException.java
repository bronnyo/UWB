
/**
 * ItemNotFoundException extends the exception class
 * and is used as a catch for when items are not found.
 *
 * @author (Krystle S Levin)
 * @version (February 16th, 2018)
 */
public class ItemNotFoundException extends Exception
{
    public ItemNotFoundException(){
        super("Item not found");
    }
    public ItemNotFoundException(String message){
        super(message);
    }
}
