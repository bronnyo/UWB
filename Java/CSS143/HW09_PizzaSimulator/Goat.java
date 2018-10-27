
/**
 * Goat extends Cheese and allocates price thereof
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Goat extends Cheese
{
    private final PizzaException ERROR=new PizzaException("Goat Cheese Error");
    public Goat(){
        super("Goat Cheese", 7, new Money(4,25));
    }
    /**
     * The following constructor allows yo to input the area of the pizza
     * so that an accurate number of calories may be calculated.
     */
    public Goat(double area){
        super("Goat Cheese", 7, new Money(4,25));
        if(area<0.00){
            System.out.println(ERROR);
            return;
        }
        super.setAreaOfCheese(Math.sqrt(area));
    }
}
