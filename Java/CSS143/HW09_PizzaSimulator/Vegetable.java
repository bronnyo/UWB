
/**
 * Vegetable class extends ingredient and is covers vegetable ingredients
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Vegetable extends Ingredient
{
    //private instance variables:
    private final PizzaException ERROR=new PizzaException("Vegetable Error");
    
    //Constructors:
    public Vegetable(){
        super();
    }
    public Vegetable(String description, int calories, Money cost){
        super(description, calories, cost);
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
        super.setCalories(servings);
        super.setCost(new Money(0, 25*servings));        
    }
}
