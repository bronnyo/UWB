import java.io.Serializable;
/**
 * Money class holds and stores the Dollars and Cents of a monetary value. 
 * The monetary value can then be accessed and modified
 * using the specificified methods there of.
 *
 * @author (Krystle S Levin)
 * @version (February 1st, 2018)
 */
public class Money implements Serializable, Comparable, Cloneable
{
    //instance variables:
    private int dollars;
    private int cents;
    
    //For the constructors I called their associated set methods
    //to avoid excessively repetitive code as their method bodies
    //would have been exactly the same.
    public Money(){
        this.dollars=0;
        this.cents=0;
    }
    public Money(int dollars){
        this.dollars=0;//ensured that dollars and cents are not null at any point.
        this.cents=0;
        setDollars(dollars); //Sends to setDollars to be initialized to avoid code repitition
    }
    public Money(int dollars, int cents){ //Sends to setDollars  and setCents to be initialized 
        this.dollars=0;//ensured that dollars and cents are not null at any point.
        this.cents=0;
        setDollars(dollars);              //to avoid code repitition
        setCents(cents);
    }
    public Money(Money other){//Assumes any preconditions were met in Money Other
        this.dollars=other.dollars;
        this.cents=other.cents;
    }
    public Money(double amount){ //Sends to setMoney with double param to be initialized 
         this.dollars=0;//ensured that dollars and cents are not null at any point.
         this.cents=0;
         setMoney(amount);         //to avoid code repitition
    }
    
    //The following are set methods that handle any exceptions
    /**
     * Pre-Condition: Neither of the Dollars or Cents parameters are negative.
     * Post-Condition: The parameter values of Dollars and Cents will sent to set methods
     *                  To be checked be set to the instace variables.
     */
    public void setMoney(int dollars, int cents){
        this.dollars=0;//ensured that dollars and cents are not null at any point.
        this.cents=0;
        setDollars(dollars);
        setCents(cents);
    }
    /**
     * Pre-Condition: The double amount parameter is not negative.
     * Post-Condition: The value of the amount parameter will be split and properly allocated
     *                 to the Dollars and Cents instance variables accordingly.
     */
    public void setMoney(double amount){
        dollars=0;
        cents=0;
        try{ //check if the parameter value is legal
            if(amount>=0.00){
                if(amount>=1){
                   while(amount>1.00){ //Allocates dollar value accordingly
                       dollars++;
                       amount-=1.00;
                    }
                   cents+=(int)(amount*100);//Allocates cent value accordingly
                }
                else
                    cents+=(int)(amount*100);
                }
            else
                throw new MoneyException("Cannot set balance to a negative amount");
        }
        catch(MoneyException e){
            System.err.println(e);
            System.out.println("Error: Setting Balance to $0.00");
            this.dollars=0;
            this.cents=0;
        }
    }
    /**
     * Pre-Condition: The int Dollar parameter is not negative.
     * Post-Condition: The value of the dollar parameter will be properly allocated
     *                 to the Dollar instance variable.
     */
    public void setDollars(int dollars){
        try{//check if the parameter value is legal
            if(dollars<0)
                throw new MoneyException("Cannot set dollars to negative amount");
            else{ 
                this.dollars=dollars;
            }
        }
        catch(MoneyException e){
            System.err.println(e);
            System.out.println("Error: Initializing dollars to $0");
            this.dollars=0;
        }
    }
    /**
     * Pre-Condition: The int Dollar parameter is not negative.
     * Post-Condition: The value of the dollar parameter will be properly allocated
     *                 to the Dollar instance variable.
     */
    public void setCents(int cents){
        try{//check if the parameter value is legal
            if(dollars+cents<0)
                throw new MoneyException("Cannot set cents to negative amount");
            if(cents>=100){
                while(cents>100){
                    dollars++;
                    cents-=100;
                }
                this.cents=cents;
            }
            else if(cents<0 && dollars>1){
                dollars--;
                this.cents=this.cents+100+cents;
            }
            else{
                this.cents=cents;
            } 
        }
        catch(MoneyException e){
            System.err.println(e);
            System.out.println("Error: Initializing cents .00");
            this.cents=0;
        }
    }
    /**
     * Pre-Condition: When the int dollar parameter is added to the dollar instance variable,
     *                their sum is not less than 0.
     * Post-Condition: The value of the dollar instance variable will update to the sum of itself
     *                 and the given value of the parameter
     */
    public void add(int dollars){
        try{//check if the parameter value is legal
            if(this.dollars+dollars<0){
                throw new MoneyException("Adding $"+dollars+" results in a negative balance");
            }
            else{ 
                this.dollars+=dollars;
            }
        }
        catch(MoneyException e){
            System.err.println(e);
            System.out.println("Error: Balance is now at $0.00 keep your change");
            this.dollars=0;
            this.cents=0;
        }
    }
    /**
     * Pre-Condition: When the int dollar parameter is added to the dollar instance variable,
     *                their sum is not less than 0, with similar conditions for cents and 
     *                the total possible value of dollars and cents.
     * Post-Condition: The value of the dollar and cents instance variables will update to the 
     *                 sum of themselves and the given value of the according parameters.
     */
    public void add(int dollars, int cents){
        try{//Makes sure values for dollars and cents are within their allowed bounds
            if(dollars>0 && cents>0){ 
                this.dollars=dollars;
                this.cents=cents;
            }
            else if (this.cents+cents<0 && dollars==0)
                throw new MoneyException("Adding $"+toString()+" results in a negative balance");
                
            else if((this.dollars+dollars)*100+(this.cents+cents)<0)
                throw new MoneyException("Adding $"+toString()+" results in a negative balance");
                
            else{
                this.dollars+=dollars;
                if(this.cents+cents>=100){
                    dollars++;
                    this.cents+=(cents-100);
                }
            }
        }
        catch(MoneyException e){
            System.err.println(e);
            System.out.println("Error: Balance is now at $0.00 keep your change");
            this.dollars=0;
            this.cents=0;
        }
    }
    /**
     * Pre-conditions: N/A since they should have been met in Money other.
     * Post-Conditions: Dollars and cents of Money Other are allocated to 
     * dollars and cents of this money class object.
     */
    public void add(Money other){
        this.dollars+=other.dollars;
        this.cents+=other.cents;
    }
    /**
     * Pre-Condition: The amount is a positive value or if amount is a negative value, 
     * the magnitude is less than or equal to the total amount. 
     * 
     * Post-Condition: If the above condition is met the amount will be allocated accordingly
     * to the dollars and cents instance variables. If pre-condition is violated dollars and
     * cents will be set to 0.
     * 
     */
    public void add(double amount){
        try{
            if((amount*-1)>getMoney())//Makes sure amount will not result in negative balance.
                throw new MoneyException("Adding $"+amount+" results in a negative balance");
            else{
                if(amount>=1){ //Allocates dollars and cents accordingly
                    while(amount>=1.00){//allocating dollar value
                       dollars++;
                       amount=amount-1.00;
                    }
                   
                    this.cents=(int)Math.round(amount* 100); //cents becomes the remaining decimal
                    if(this.cents>=100){//ensures cents<100
                       cents-=100;
                       dollars++;
                    }
                }
                else
                    cents+=(int)(amount*100);
            }
        }
        catch(MoneyException e){ 
            System.err.println(e);
            System.out.println("Error: Balance is now at $0.00 keep your change");
            this.dollars=0;
            this.cents=0;
        }
    }
    
    /**
     *  Pre-Condition: the object being compared in isEqual() is of the class Money
     *                 and the values of their instance variables are equal.
     * Post-Condition: If this criteria is met isEqual() will return True.
     */
    public boolean isEqual(Object o){
        try{
            if(o.getClass()!=(new Money()).getClass()){ //Makes sure comparing same class 
                throw new MoneyException("Trying to compare different entities");              
            }
            else{ 
                Money that=new Money((Money)(o));
                if(this.dollars==that.dollars && this.cents==that.cents)
                    return true;  
            }
        }
        catch(MoneyException e){
            System.err.println(e);
            System.out.println("Can only compare Money objects with other Money objects");
        }
        return false;
    }
    
    /**
     * toString complies the instance variables of the class into a single string value which 
     * is then returned to the calling location. There are no pre-conditions for this method.
     */
    public String toString(){//returns the data as a logical string.
        if(cents<10)//Prints properly if cents<0
            return ("$"+this.dollars+".0"+this.cents+" ");
        else
            return ("$"+this.dollars+"."+this.cents+" ");
    }
    
    /**
     * The following methods are "getter methods" for retreiving data held
     * in the class instance variables and return values accordingly.
     * There are no pre-conditions for these methods.
     */
    public double getMoney(){
        double amount=((this.dollars*1.00)/(this.cents/100));
        return amount;
    }
    public int getDollars(){
        return dollars;
    }
    public int getCents(){
        return cents;
    }
    //**Implemented interface overrides**/
    /**
     * Method: clone()
     * Returns a copy of this Money to whereever it is being called.
     */
    public Money clone(){
        try{
            Money copy= (Money)super.clone();
            copy.dollars=(int)dollars; 
            copy.cents=(int)cents;
            return copy;
        }
        catch(CloneNotSupportedException e){
            return null;
        }
    }
    /**
     * Method: comapreTo(Object compare)
     * Pre-condition: the object to be compared must also be of the class Money
     * Post-Condition: will return an int value of which will be 0 if the two
     *                 objects are equal. The method will return a -1 if the 
     *                 calling Object is less than the paramater compare and 
     *                 returns 1 if the calling object comes after.
     */
    public int compareTo(Object compare){
        try{
            if(compare.getClass()!=(new Money()).getClass()) //Makes sure comparing same class 
                throw new MoneyException("Trying to compare different entities");              
            
            if(isEqual(compare))
                return 0;
            Money that= new Money((Money)compare);
            if(this.dollars<that.dollars)
                return -1;
            else if(this.dollars>that.dollars)
                return 1;
            else{//this.dollars==that.dollars
                if(this.cents<that.cents)
                    return -1;
                else if(this.cents>that.cents)
                    return 1;
                else //the two amounts are totally equal(should bnever ge here)
                    return 0;
            }
        }
        catch(MoneyException e){
            System.err.println(e);
            System.out.println("Can only compare Money objects with other Money objects");
        }
        return 9;
     }

    /**
     * MoneyException handels any exceptions that the program may encounter.
     */
    public class MoneyException extends Exception{
        public MoneyException(){
            super("Invalid Date Entry");
        }
        public MoneyException(String message){
            super("Invalid Money Entry "+message);
        }
    }
}
