
/**
 * Meat class extends ingredient and is covers Meat ingredients
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Meat extends Ingredient
{
    //private instance variables:
    private final PizzaException ERROR=new PizzaException("Meat Error");
    private Shape meatShape;
    
    //Constructors:
    public Meat(){
        super();
        meatShape=new Circle(1,1,1);
    }
    public Meat(String description, int calories, Money cost){
        super(description, calories, cost);
    }
    public void changeServings(int servings){
        if(servings<=0){
            System.out.println(ERROR);
            return;
        }
        super.setCalories(servings*200);
        super.setCost(new Money(3.50+(.5*(servings-1))));         
    }
    /**
     * the following two methods are retrieval methods for the shape of the
     * Mozzerella, as well as the color of the Mozzerella.
     */
    public Shape getShape(){
        return meatShape;
    }
}
