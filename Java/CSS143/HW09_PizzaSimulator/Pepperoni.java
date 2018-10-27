import java.awt.Color;
/**
 * Pepperoni extends Meat and allocates price thereof
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Pepperoni extends Meat
{
    private final PizzaException ERROR=new PizzaException("Pepperoni Error");
    private final Color pepperoniColor=new Color(204,0,0);
    
    public Pepperoni(){
        super("Pepperoni", 200, new Money(3,50));
    }
    /**
     * The following constructor allows yo to input the area of the pizza
     * so that an accurate number of calories may be calculated.
     */
    public Pepperoni(int servings){
        super("Pepperoni", 200, new Money(3,50));
        if(servings<0.00){
            System.out.println(ERROR);
            return;
        }
        super.setCalories(servings*200);
        super.setCost(new Money(3.5+(servings*.5)));
    }    
    public Color getPepperoniColor(){
        return pepperoniColor;
    }
}
