import java.awt.Color;
/**
 * Pepper extends Vegetable and allocates price thereof
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Pepper extends Vegetable
{
    private final PizzaException ERROR=new PizzaException("Pepper Error");
    private final Color pepperColor=new Color(0,0,0);
    private Shape square;
    
    public Pepper(){
        super("Pepper", 24, new Money(0,50));
        square=new Square(1,1,1,2);
    }
    /**
     * The following constructor allows yo to input the area of the pizza
     * so that an accurate number of calories may be calculated.
     */
    public Pepper(int servings)throws PizzaException{
        super("Pepper", 24, new Money(0,25));
        if(servings<0.00){
            System.out.println(ERROR);
            return;
        }
        
        super.setCalories(servings*24);
        super.setCost(new Money(servings*.25));
        square=new Square(1,1,1,2);
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
            
        super.setCalories(servings*24);
        super.setCost(new Money(0, 25*servings));        
    }
    /**
     * The following are "getter" methods for color and shape
     */
    public Color getPepperColor(){
        return pepperColor;
    }
    public Shape getShape(){
        return square;
    }
}
