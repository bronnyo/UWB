
/**
 * Expense Account extends ArrayList
 * Expense account keeps track of a list of bills
 * the bills are then automatically stored  in order
 * the order determined as:
 *   Top of the List
 *      Next unpaid due
 *          if two due dates are equal the bill will a larger
 *          amount will be placed before the lesser amount bill
 *      Last paid bill
 *          the bills are then sorted from the most recent paid to the
 *          first payment received at the bottom of the list.
 *
 * @author (Krystle S Levin)
 * @version (March 1st, 2018)
 */
public class ExpenseAccount extends ArrayList
{
    //instance Variables
    private Bill lastBillPaid;
    private Bill largestAccountDebt;
    private Bill firstBillPaid;
    //default constructor
    public ExpenseAccount(){
        super();
        lastBillPaid=null;
        largestAccountDebt=null;
        firstBillPaid=null;
    }
    /**
     * Method: addNew(Object newAccount)
     * Pre-Condition: the new account Object is a Bill
     * Post-condiition: the new account bill will be stored to the list according to the
     *                  specification stated in the decription of the class.
     */
    public void addNew(Object newAccount) throws ExpenseAccountException{
        try{
            if(newAccount.getClass()!=(new Bill()).getClass()) //Makes sure New acoount is a bill 
                    throw new ExpenseAccountException("Sorry, expense account is for storing bills"); 
            Bill that=new Bill((Bill)newAccount);
            
            if(super.size()==0){ //checks if list is empty
                super.insert(newAccount, 0);
                if(that.getPaidDate()!=null){//checks if the bill has been paid0
                    setLastBillPaid(that);
                    setFirstBillPaid(that);
                }
                else
                    setLargestAccountDebt(that);
            }
            else if(that.getPaidDate()!=null){//checks if the bill has been paid0
                setLastBillPaid(that);
                setFirstBillPaid(that);
                if(that.compareTo(super.get(super.size()-1))>=0) 
                    super.insert(newAccount, super.size()-1);
                else if(that.compareTo(super.indexOf(lastBillPaid))<0)
                    super.insert(newAccount, super.indexOf(lastBillPaid));
                else{
                    int i=super.indexOf(lastBillPaid);
                    while(that.compareTo(super.get(i))>0){
                        i++;
                    }
                    super.insert(newAccount, i);
                }
                }
            else{
                setLargestAccountDebt(that);//if bill has not been paid it is checked for largest list debt 
                
                if(that.compareTo(super.get(0)) > 0)
                    super.insert(newAccount, 0);
                    // ^is checking if bill should be added at the beginning
                    
                else{//finds middle posisition where the bill belongs
                    int i=0;
                    while(that.compareTo(super.get(i))>0){
                        i++;
                    }
                    super.insert(newAccount, i);
                }
            } 
            //if(super.size()==0) //checks if list is empty
                //super.insert(newAccount, 0);
            //else{ //if list is not empty
        }
        catch(ExpenseAccountException e){
            System.err.println(e);
        }
    }    
    /**
     * @ Override:
     * Method: indexOf(Object Target)
     * Pre-condition: the list in a non-empty list and the target object is in the list
     * Post-condition: the index of the target item will be returned
     */
    public int indexOf(Object target){
        try{
            if(target.getClass()!=(new Bill()).getClass()) //Makes sure comparing same class 
                throw new ExpenseAccountException("Sorry, expense account is for storing bills");
            Bill copy=(Bill)target;
            Bill listElement;
            int i=0;
            int maxLength=super.size();
            while(i<maxLength){
                listElement=(Bill)super.get(i);
                if(copy.compareTo(listElement)==0)
                    return i;
                i++;
            }
        }catch(ExpenseAccountException e){
            System.err.println(e);
        }
        //if element doesnt exists in the list        
        System.err.println("Sorry the target could not be found");
        return -1;
    }
    public Object remove(int index){
        if(lastBillPaid.compareTo(super.get(index))==0)
            lastBillPaid= (Bill)super.get(super.indexOf(lastBillPaid)+1);
        else if(largestAccountDebt.compareTo(super.get(index))==0){
            findNextLargestDebt();
        }
        return super.remove(index);
    }
    public Bill findNextLargestDebt(){
        int iTemp=super.indexOf(largestAccountDebt);
        //System.out.println(super.get(0).toString());
        for(int i=0; i< super.indexOf(firstBillPaid); i++){
            if(i==iTemp){}
            else if(i==0)
                largestAccountDebt= (Bill)super.get(0);
            else if(largestAccountDebt.compareTo((Bill)super.get(i))>0)
                largestAccountDebt=(Bill)super.get(i);
            //System.out.println(largestAccountDebt.toString()+" @i: "+i);
        }
        return lastBillPaid;
    }
    /**
     * Method(private): void setLastBillPaid(Bill paidBill)
     * Pre-Condition: the parameter only accepts bill objects
     * post-condition: if lastPaidBill is null then it is set
     *                 if last paid bill returns -1 when compared to the parameter paidBill
     *                 then the instance variable is reset to the new bill value.
     */
    private void setLastBillPaid(Bill paidBill){
        if(lastBillPaid==null)
            lastBillPaid=paidBill;
        else if(lastBillPaid.compareTo(paidBill)==-1)
            lastBillPaid=paidBill;
        else{}//lastBillPaid has not been altered    
    }
    /**
     * Method: Bill getLastBillPaid()
     *         returns a copy of the bill stored in the instance vairable lastBillPaid
     */
    public Bill getLastBillPaid(){
        return lastBillPaid.clone(); 
    }
    /**
     * Method: String viewLastBillPaid()
     *         returns a string value of the last bill that paid to the expense account
     */
    public String viewLastBillPaid(){
        return lastBillPaid.toString();
    }
    
    private void setFirstBillPaid(Bill paidBill){
        if(firstBillPaid==null)
            firstBillPaid=paidBill;
        else if(firstBillPaid.compareTo(paidBill)==1)
            firstBillPaid=paidBill;
        else{}//lastBillPaid has not been altered 
    }
    /**
     * Method: Bill getLastBillPaid()
     *         returns a copy of the bill stored in the instance vairable lastBillPaid
     */
    public Bill getFirstBillPaid(){
        return firstBillPaid.clone(); 
    }
    /**
     * Method: String viewLastBillPaid()
     *         returns a string value of the last bill that paid to the expense account
     */
    public String viewFirstBillPaid(){
        return firstBillPaid.toString();
    }
    
    /**
     * Method(private): void setLastBillPaid(Bill paidBill)
     * Pre-Condition: the parameter only accepts bill objects
     * post-condition: if lastPaidBill is null then it is set
     *                 if last paid bill returns -1 when compared to the parameter paidBill
     *                 then the instance variable is reset to the new bill value.
     */
    private void setLargestAccountDebt(Bill unpaidBill){
        Money toTest=new Money(unpaidBill.getAmount()); 
        
        if(largestAccountDebt==null)
            largestAccountDebt=unpaidBill;
        else if(largestAccountDebt.getAmount().compareTo(toTest)==-1)
            largestAccountDebt=unpaidBill;
        else{}//largetsAccountDebt has not been altered    
    }
    /**
     * Method: Bill getLargestAccountDebt()
     *         returns a copy of the bill stored in the instance vairable largestAccountDebt
     */
    public Bill getLargestAccountDebt(){
        return largestAccountDebt.clone();
    }
    /**
     * Method: String viewLargestAccountDebt()
     *         returns a string value of the open bill with the largest balance stored in expense account
     */
    public String viewLargestAccountDebt(){
        return largestAccountDebt.toString();
    }
    
    /**
     * Method: Bill getNextPaymentDue()
     *         returns a copy of the bill stored in the instance vairable nextPaymentDue
     */
    public Bill getNextPaymentDue(){
        Bill temp=(Bill)super.get(0);
        return temp.clone();
    }
    /**
     * Method: String viewLastBillPaid()
     *         returns a string value of the the next bill that is due in the expense account
     */
    public String viewNextPaymentDue(){
        return ""+super.get(0)+"";
    }
    
    /**
     * BillException handels any exceptions that the program may encounter.
     */
    public class ExpenseAccountException extends Exception{ 
        public ExpenseAccountException(){
            super("Invalid Expense Entry");
        }
        public ExpenseAccountException(String message){
            super("Invalid Expense Entry "+message);
        }
    }
}
