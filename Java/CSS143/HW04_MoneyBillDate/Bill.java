
/**
 * Bill Class stores and modifies a bills amount, when it is due
 * when it has been paid, if at all, and the originator to which
 * the bill must be paid to. Bills cannot be paid after the due date
 * has passed and will suggest you contact the bill collector if you
 * attempt doing so.
 *
 * @author (Krystle S Levin)
 * @version (February 1st 2018)
 */
public class Bill
{
    //Instance Variables
    private Money amount;
    private Date dueDate;
    private Date paidDate;
    private String originator;
    //Constructors
    public Bill(){
        this.amount= new Money();
        this.dueDate=new Date();
        this.paidDate=null;
        this.originator="The Master of Coin";
    }
    /**
     * Pre-Condition None
     * Post-Condition: The values of objects in the Parameter are assigned to their associated
     *                  instance variables of this Bill ie the money object is assigned to amount,
     *                  Date object is assigned to dueDate, A string name is assigned to the originator,
     *                  and paidDate is left null until its value is added later.
     */
    public Bill(Money amount, Date dueDate, String originator){
        this.amount= new Money(amount);
        this.dueDate=new Date(dueDate); 
        this.paidDate=null;
        this.originator=originator;
    }
    /**
     * Pre-Condition None
     * Post-Condition: The values of the Date Object Parameter are assigned to the instance variables
     *                 Of this Bill, ie the amount, dueDate, paidDate, and originator
     */
    public Bill(Bill toCopy){
        this.amount= new Money(toCopy.amount);
        this.dueDate=new Date(toCopy.dueDate);
        if(toCopy.paidDate!=null)
            this.paidDate=new Date(toCopy.paidDate);
        else
            this.paidDate=null;
        this.originator=(toCopy.originator);
    }
    /**
     * Pre-Condition NA
     * Post-Condition: Due Date is set to the Parameter of the Date Object.
     */
    public void setDueDate(Date dueDate){
        this.dueDate=dueDate;
        this.paidDate=null;
        System.err.println("New due Date, paid Date has been set to null");
    }
    /**
     * Pre-Condition PaidDate is not assigned to a day after the Due Date of the bill
     * Post-Condition: Paid Date is set to the Parameter of the Date Object.
     */
    public void setPaidDate(Date paidDate){
        try{
            if(paidDate.getYear()>this.dueDate.getYear())
                throw new BillException("Cannot make late payments");
                
            else if(paidDate.getYear()==this.dueDate.getYear()){
                if(paidDate.getMonth() >this.dueDate.getMonth())
                    throw new BillException("Cannot make late payments");
                    
                else if(paidDate.getMonth()==this.dueDate.getMonth()){
                    if(paidDate.getDay()> this.dueDate.getDay())
                        throw new BillException("Cannot make late payments");
                }
                else
                    this.paidDate=paidDate;
            } 
            else
                this.paidDate=paidDate;
        }
        catch(BillException e){
            System.err.println(e);
            System.out.println("Error: Please contact the collection agency about paying your bill");
        }
    }
    /**
     * Pre-Condition NA
     * Post-Condition: paidDate is set to null
     */
    public void setUnpaid(){
        this.paidDate=null;
    }
    /**
     * Pre-Condition NA
     * Post-Condition: Amount is set to an initialized Money Object
     */
    public void setAmount(Money amount){
        this.amount=amount;
    }
    /**
     * Pre-Condition NA
     * Post-Condition: Originator is assigned a string value
     */
    public void setOriginator(String originator){
        this.originator=originator;
    }
    
    /**
     * toString complies the instance variables of the class into a single string value which 
     * is then returned to the calling location. There are no pre-conditions for this method.
     */
    public String toString(){
        String words=("The bill due on "+dueDate.toString()+" of the amount : "+amount.toString());
        if(paidDate==null)
            words+=("has not yet been paid to "+originator);
        else
            words+=("was paid to "+originator+" on the day of "+paidDate.toString());
        return words;
    }
    
    /**
     * The following methods are "getter methods" for retreiving data held
     * in the class instance variables and return values accordingly.
     * There are no pre-conditions for these methods.
     */
    public Money getAmount(){
        return this.amount;
    }
    public Date getDueDate(){
        //return this.dueDate; <<This creates a Privacy Leak
        return new Date(this.dueDate);//<<this is safe
    }
    public Date getPaidDate(){
        return this.paidDate;
    }
    public String getOriginator(){
        return this.originator;
    }
    /**
     *  Pre-Condition: the object being compared in equals() is of the class Bill
     *                 and the object instance variables are equal by the method 
     *                 definition equals() within their own classes.
     * Post-Condition: If this criteria is met equals() will return True.
     */
    public boolean equals(Object o){
        try{
            if(o.getClass()!=(new Bill()).getClass()){ //Makes sure comparing same class 
                throw new BillException("Trying to compare different entities");              
            }
            else{
                Bill that=(Bill) o;
                if(this.amount.equals(that.amount)&&this.dueDate.equals(that.dueDate)
                    && this.originator.equals(that.originator)){
                    if(this.paidDate==null && that.paidDate==null)
                        return true;  
                    else if((this.paidDate!=null && that.paidDate!=null)&&this.dueDate.equals(that.dueDate))
                        return true;
                }
            }
        }
        catch(BillException e){
            System.err.println(e);
            System.out.println("Can only compare Bill objects with other Bill objects");
        }
        return false;
    }
    
    /**
     * BillException handels any exceptions that the program may encounter.
     */
    public class BillException extends Exception{
        public BillException(){
            super("Invalid Bill Entry");
        }
        public BillException(String message){
            super("Invalid Bill Entry "+message);
        }
    }
}
