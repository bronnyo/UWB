
/**
 * Base class extends ingredient and is covers sauce ingredients
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Base extends Ingredient
{
    //private instance variables:
    private final PizzaException ERROR=new PizzaException("Base Error");
    private final int CaloriesPerInch= 4; //average calories of base per aquare inch;
    
    private Shape areaOfTopping;
    
    //Constructors:
    public Base(){
        super();
        areaOfTopping=new Circle(1,1,1);
    }
    public Base(String description, int calories, Money cost){
        super(description, calories, cost);
    }
    /**
     *  SetArea
     *  Pre-Condition: Area >0
     *  Postcondition: the size of circle of base will be updated as well as 
     *                 the number of calories accordingly
     */
    public void setAreaOfBase(double area){
        if(area<=0.00){
            System.out.println(ERROR); 
            return;
        }
        areaOfTopping=new Circle(1,1,(int)(Math.sqrt(area/3.14)));
        super.setCalories((int)(area*4));
    }
    /**
     * the following two methods are retrieval methods for the shape of the
     * Mozzerella, as well as the color of the Mozzerella.
     */
    
    public Shape getShape(){
        return areaOfTopping;
    }
}
