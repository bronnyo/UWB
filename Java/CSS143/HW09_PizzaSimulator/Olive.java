import java.awt.Color;
/**
 * Olive extends Vegetable and allocates price thereof
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Olive extends Vegetable
{
    private final PizzaException ERROR=new PizzaException("Marinara Error");
    private final Color oliveColor=new Color(0,0,0);
    private Shape circle;
    
    public Olive(){
        super("Olive", 5, new Money(0,25));
        circle=new Circle(1,1,1);
    }
    /**
     * The following constructor allows yo to input the area of the pizza
     * so that an accurate number of calories may be calculated.
     */
    public Olive(int servings)throws PizzaException{
        super("Olive", 5, new Money(0,25));
        if(servings<0.00){
            System.out.println(ERROR);
            return;
        }
        
        super.setCalories(servings*5);
        super.setCost(new Money(0,servings*25));
        circle=new Circle(1,1,1);
    } 
    /**
     * Pre-conditions: the int parameter for number of servings is greater than 0
     * Post-condition: the cost and number of calories will be updated accordingly
     */
    public void changeServings(int servings){
        if(servings<=0){
            System.out.println(ERROR);
            return;
        }
        super.setCalories(servings*5);
        super.setCost(new Money(0, 25*servings));        
    }
    /**
     * The following are "getter" methods for color and shape
     */
    public Color getOliveColor(){
        return oliveColor;
    }
    public Shape getShape(){
        return circle;
    }
}
