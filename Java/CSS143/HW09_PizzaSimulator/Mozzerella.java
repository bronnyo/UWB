import java.awt.Color;
/**
 * Mozerella extends Cheese and allocates price thereof
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Mozzerella extends Cheese
{
    private final PizzaException ERROR=new PizzaException("Mozzerella Error");
    public Mozzerella(){
        super("Mozerella", 7, new Money(3,00));
    }
    /**
     * The following constructor allows yo to input the area of the pizza
     * so that an accurate number of calories may be calculated.
     */
    public Mozzerella(double area){
        super("Mozzerella", 7, new Money(3,00));
        if(area<0.00){
            System.out.println(ERROR);
            return;
        }
        super.setAreaOfCheese(Math.sqrt(area));
    }

    
}
