
/**
 * Pizza holds a list of toppings which in turn determine
 * the total cost and calorie count of each individual pizza
 * which is then stored in the instance variables
 * 
 * all pizzas are 16" diameter circles.
 *
 * @author (Krystle S Levin)
 * @version (03/09/2018) 
 */
public class Pizza implements PizzaComparable
{
    private final PizzaException ERROR=new PizzaException("Pizza Error");
    private ArrayList<Ingredient> toppings;
    private final int PIZZA_RADIUS= 8;
    private final Shape pie=new Circle(1,1, PIZZA_RADIUS);;
    
    private Money totalCost;
    private int totalCalories;
    private Fraction size;
    private double area;
    
    
    public Pizza(){
        toppings=new ArrayList();
        totalCost=new Money(3,50);
        totalCalories=672; //calories in Pizza crust
        size=new Fraction(8,8);
        area= PIZZA_RADIUS*PIZZA_RADIUS*3.14;
        
    }
    /**
     * Pre-conditions: int d is >0
     * post-condition: a new fraction will be allocated to represent the amount of pizza left
     */
    public void setRemaining(Fraction f){
        size=f.clone();        
    }
    
    /**
     * The following methods are "getter" methods and have not preconditions
     * the methods will return a value according to its specified type
     */
    public int getCalories(){   return totalCalories;}
    public Money getCost(){     return (Money)totalCost.clone(); }
    public double getRemainingArea(){
        return area;
    }
    public Shape getShape(){    return (Shape)pie.clone();}
    
    
    
    /**
     * Pre-Condition: the other object is a non-null ingredient object
     * Postcondition: the ingrdient will be added to the list of ingrdients for this pizza
     */
    public void addIngredient(Object other){
        if(!(other instanceof Ingredient) || other==null){
            System.out.println(ERROR+" Sorry you can't add non-ingredients to Pizzas");
            return;
        }
        Ingredient that=(Ingredient)other;
        
        totalCost.add(that.getCost().getDollars(), that.getCost().getCents());
        totalCalories+=(that.getCalories());
        
        toppings.add(that); 
    }
    /**
     * eatSomePizza
     * pre-condition: Fraction amt is a non null fraction and f is not greater than the amount left
     * postcondition: The size of the pizza will be updated according to the amount deducted
     */
    public void eatSomePizza(Fraction amt){
        if(amt.compareTo(new Fraction(1,1))==0){
            size=new Fraction(); //this makes size 0;
            area=0;
        }
        else if(size.compareTo(amt)<=0){
            System.out.println(ERROR);
            size=new Fraction();
            area=0;
        }
        else{
            int sizeDen=size.getDenominator();
            int amtDen=amt.getDenominator();
            if(sizeDen==amtDen){
                size.setNumerator(size.getNumerator()-amt.getNumerator());               
            }
            else{
                int sizeNum=size.getNumerator();
                int amtNum=amt.getNumerator();
                size=new Fraction(amtDen*sizeNum-sizeDen*amtNum, amtDen*sizeDen);
                area=area*((1.0*size.getNumerator())/(1.0*size.getDenominator()));
            }
        }
    }
    /**
     * toString
     * returns a string value with the price, total calories, remaining fractional amount
     * and total remaining area.
     */
    public String toString(){
        String description= ("Pizza has a price of: "+totalCost+" and a calorie count of: "
                              +totalCalories+ ", Fraction remaining: "+size.toString()+
                              " and area left "+area+" and Shape: Circular\n"+toppings.toString());
        
        return description;
    }
    /**
     * CompareTo
     * PreCondition: other is an instance of Pizza and is not null
     * Postcondition: will return -1 if other cost is less than this cost
     *                will return 1 if other cost is greater than this cost
     *                will return 0 if other cost equals this cost
     */
    @Override
    public int compareTo(Object other){ 
        if(!(other instanceof Pizza)){
            System.out.println(ERROR+" Sorry you can't compare Pizzas with non Pizzas");
            return 0;
        }
        Pizza that=(Pizza)other;
        return this.totalCost.compareTo(that.totalCost);
    }
    /**
     * CompareToBySize
     * PreCondition: other is an instance of Pizza and is not null
     * Postcondition: will return -1 if other size is less than this size
     *                will return 1 if other size is greater than this size
     *                will return 0 if other size equals this size
     */
    public int compareToBySize(Object other){   //a.k.a. compareToByAreaLeft
        if(!(other instanceof Pizza)){
            System.out.println(ERROR+" Sorry you can't compare Pizzas with non Pizzas");
            return 0;
        }
        Pizza that=(Pizza)other;
        
        return this.size.compareTo(that.size);
    }
    /**
     * CompareToByCalories
     * PreCondition: other is an instance of Pizza and is not null
     * Postcondition: will return -1 if other total calories is less than this total calories
     *                will return 1 if other total calories is greater than this total calories
     *                will return 0 if other total calories equals this total calories
     */
    public int compareToByCalories(Object other){
        if(!(other instanceof Pizza)){
            System.out.println(ERROR+" Sorry you can't compare Pizzas with non Pizzas");
            return 0;
        }
        Pizza that=(Pizza)other;
        if(this.totalCalories<that.totalCalories)
            return -1;
        else if(this.totalCalories>that.totalCalories)
            return 1;
        else
            return 0;
    }
}
