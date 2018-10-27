import java.awt.Color;
/**
 * Sausage extends Meat and allocates price thereof
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Sausage extends Meat
{
    private final PizzaException ERROR=new PizzaException("Sausage Error");
    private final Color sausageColor=new Color(153,76,0);
    
    public Sausage(){
        super("Sausage", 200, new Money(3,50));
    }
    /**
     * The following constructor allows yo to input the area of the pizza
     * so that an accurate number of calories may be calculated.
     */
    public Sausage(int servings){
        super("Sausage", 200, new Money(3,50));
        if(servings<0.00){
            System.out.println(ERROR);
            return;
        }
        super.setCalories(servings*200);
        super.setCost(new Money(3.5+(servings*.5)));
    }    
    public Color getSausageColor(){
        return sausageColor;
    }
}
