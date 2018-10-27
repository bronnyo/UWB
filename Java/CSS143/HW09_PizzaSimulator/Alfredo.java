import java.awt.Color;
/**
 * Marinara extends base and allocates price thereof
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Alfredo extends Base
{
    private final PizzaException ERROR=new PizzaException("Alfredo Error");
    private final Color color= new Color(255,255,255);
    
    public Alfredo(){
        super("Alfredo Cheese", 7, new Money(3,75));
    }
    /**
     * The following constructor allows yo to input the area of the pizza
     * so that an accurate number of calories may be calculated.
     */
    public Alfredo(double area) {
        super("Alfredo", 7, new Money(3,75));
        if(area<0.00){
            System.out.println(ERROR);
            return;
        } 
        super.setAreaOfBase(Math.sqrt(area));  
    }
    public Color getColor(){
        return color;
    }
}
