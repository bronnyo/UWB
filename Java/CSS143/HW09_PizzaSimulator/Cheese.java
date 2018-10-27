import java.awt.Color;
/**
 * Cheese class extends ingredient and is covers Cheese ingredients
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Cheese extends Ingredient
{
    //private instance variables:
    private final PizzaException ERROR=new PizzaException("Cheese Error");
    private final Color color= new Color(255,255,255); //Goat and Mozzerella are both white cheeses
    private final int CaloriesPerInch= 7; //average calories of cheese per aquare inch;
    
    private Shape areaOfTopping;
    
    //Constructors:
    public Cheese(){
        super();
        areaOfTopping=new Circle(1,1,1);
    }
    public Cheese(String description, int calories, Money cost){
        super(description, calories, cost);
    }
    /**
     *  SetArea
     *  Pre-Condition: Area >0
     *  Postcondition: the size of circle of cheese will be updated as well as 
     *                 the number of calories accordingly
     */
    public void setAreaOfCheese(double area){
        if(area<=0.00){
            System.out.println(ERROR);
            return;
        }
        areaOfTopping=new Circle(1,1,(int)(Math.sqrt(area/3.14)));
        super.setCalories((int)(area*7));
    }
    /**
     * the following two methods are retrieval methods for the shape of the
     * Mozzerella, as well as the color of the Mozzerella.
     */
    
    public Color getColor(){
        return color;
    }
    public Shape getShape(){
        return areaOfTopping;
    }
}
