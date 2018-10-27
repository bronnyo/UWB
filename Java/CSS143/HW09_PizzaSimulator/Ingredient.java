
/**
 * Ingredient is the superclass for all other toppings in pizza
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018)
 */
public class Ingredient implements Comparable
{
    private final PizzaException ERROR=new PizzaException("Mozzerella Error");
    private String description;
    private int calories;
    private Money cost;
    
    //Constructor:
    public Ingredient(){
        description="";
        calories=0;
        cost=new Money(0,0);
    }
    //Constructor:
    public Ingredient(String newItem, int calories, Money cost){
        this.description=newItem;
        this.calories=calories;
        this.cost=cost;
    }
    /**
     * Change ingredient:
     * Pre-condition: newItem is not null, calories>0, and cost>0
     * postcondition: the indrediant will be changes according to the specifications
     */
    public void changeIngredient(String newItem, int calories, Money cost){
        this.description=newItem;
        this.calories=calories;
        this.cost=cost;
    }
    /**
     * Set desciption
     * pre-condition: the description parameter must be non null
     * postcondition: the description  for the ingrdient will be changed
     */
    public void setDescription(String description){
        if(description==null){
            System.out.println(ERROR);
            return;
        }
        this.description=description;
    }
    /**
     * Set Calories
     * Pre-condition: the calories parameter must be an int greater than 0
     * Postcondition: the number of calories will be changed to the specified amount
     */
    public void setCalories(int calories){
        this.calories=calories;
    }
    /**
     * Set Cost
     * Pre-condition: cost is not null and is greater than 0
     * Postcondition: the cost f the ingredient will be changed to the specifies amount
     */
    public void setCost(Money newCost){
        this.cost=new Money(newCost);
    }
    /**
     * The following three methods are "getter methods for retrieving the data
     * stored in the instance variables and non have any preconditions.
     */
    public String getDescription(){
        return this.description;
    }
    public int getCalories(){
        return this.calories;
    }
    public Money getCost(){
        return cost.clone();
    }
    /**
     * toString
     * Returns a string containing a full disclosure of the information about the ingredient
     */
    public String toString(){
        return (this.description+":  "+calories+" calories at a cost of "+cost.toString());
    }
    /**
     * Is equals compares to ingrdients and returns true if the
     * ingredient name, calorie count, and cost are all the same.
     */
    public boolean isEqual(Ingredient that){
        if(this.description.equalsIgnoreCase(that.description) &&
                this.calories==that.calories && this.cost.equals(that.cost))
                    return true;
        return false;  
    }
    /**
     * CompareTo
     * PreCondition: other is an instance of ingredient and is not null
     * Postcondition: will return -1 if other cost is less than this cost
     *                will return 1 if other cost is greater than this cost
     *                will return 0 if other cost equals this cost
     */
    public int compareTo(Object other){
        if(!(other instanceof Ingredient)){
            System.out.println("Sorry ou can't compare ingredients with non ingredients");
            return 0;
        }
        return cost.compareTo(other);
    }
}
