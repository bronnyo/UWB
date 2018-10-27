import java.awt.Color;
/**
 * Marinara extends base and allocates price thereof
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Marinara extends Base
{
    private final PizzaException ERROR=new PizzaException("Marinara Error");
    private final Color color= new Color(255,0,0);
    
    public Marinara(){
        super("Marinara", 7, new Money(3,00));
    }
    /**
     * The following constructor allows yo to input the area of the pizza
     * so that an accurate number of calories may be calculated.
     */
    public Marinara(double area){
        super("Marinara", 7, new Money(5,50));
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
