import java.lang.Class;
/**
 * Date class holds and stores the Month, Day and Year of a given date, of the
 * years between the 2014-2024 only. The date can then be accessed and modified
 * useing the specifically allocated methods of which.
 *
 * @author (Krystle S Levin)
 * @version (February 1st, 2017)
 */
public class Date
{
    //Instance Variables:
    private int day;    
    private int month;
    private int year;
    
    //Constructors
    public Date(){ //Default Date: 1/1/2014
        this.day=1;
        this.month=1;
        this.year=2014;
    }
    /**
     * Pre-Condition: the parameter value for month is between 1 and 12
     *                the parameter value for day is between 1 and 31
     *                the parameter value for year is between 2014 and 2024
     *A violation of any of these conditions results in the entire date being set to the default 1/1/2014
     *
     * Post-Condition: The parameter values of month, day and year will be allocated accordingly 
     *                 to their associated instance variables of the class (month, day, year);
     */
    public Date(int month, int day, int year){
        try{//Checks if the parameters are in the required bounds
            if(day>31 || day<1){
                throw new DateException("("+day+" does not represent a day of the month)");
            }
            else
                this.day=day;
            if(month>12 || month<1){
                throw new DateException("("+month+" does not represent a month)");
            }
            else
                this.month=month;
            if(year>2024 || year<2014){
                throw new DateException("("+year+" is not an acceptable choice of year)");
            }
            else
                this.year=year;
            }
        catch(DateException e){
            System.err.println(e);
            System.out.println("1 or more Date errors: setting to default date (1/1/2014)");
            this.month=1;
            this.day=1;
            this.year=2014;
        }       
    }
    /**
     * Pre-Conditions: N/A since all precondition should have been met in the other Date object
     * Post-Conditions: the instance variables month, day, year of Date other will be assigned
     *                  to this month day and year.
     */
    public Date(Date other){
        this.month=other.month;
        this.day=other.day;
        this.year=other.year;
    }
    
    //Mutator Methods:
    /**
     * Pre-Conditions: N/A since all precondition should have been met in the other Date object
     * Post-Conditions: the instance variables month, day, year of Date other will be assigned
     *                  to this month day and year.
     */
    public void setDate(Date other){
        this.month=other.month;
        this.day=other.day;
        this.year=other.year;
    }
    /**
     * Pre-Condition: the parameter value for month is between 1 and 12
     *                the parameter value for day is between 1 and 31
     *                the parameter value for year is between 2014 and 2024
     *A violation of any of these conditions results in the entire date being set to the default 1/1/2014
     *
     * Post-Condition: The parameter values of month, day and year will be allocated accordingly 
     *                 to their associated instance variables of the class (month, day, year);
     */
    public void setDate(int month, int day, int year){
        try{//Checks if the parameters are in the required bounds
            if(day>31 || day<1){
                throw new DateException("("+day+" does not represent a day of the month)");
            }
            else
                this.day=day;
            if(month>12 || month<1){
                throw new DateException("("+month+" does not represent a month)");
            }
            else
                this.month=month;
            if(year>2024 || year<2014){
                throw new DateException("("+year+" is not an acceptable choice of year)");
            }
            else
                this.year=year;
            }
        catch(DateException e){
            System.err.println(e);
            System.out.println("1 or more Date errors: setting to default date (1/1/2014)");
            this.month=1;
            this.day=1;
            this.year=2014;
        }       
    }
    /**
     * Pre-Condition: The input for day is between 1 and 31
     *     Violation: Results in month being set to the default day of 1.
     *     
     * Post-Condition: If this criteria is met the parameter int day will be 
     *                 assigned to the day instance variable
     */
    public void setDay(int day){
        try{
            if(day>31 || day<1){ //Checks if the parameter is in the required bounds
                throw new DateException("("+day+" does not represent a day of the month)");
            }
            else
                this.day=day;
            }
        catch(DateException e){
            System.err.println(e);
            System.out.println("Error: setting day to default");
            this.day=1;
        }  
    }
    /**
     * Pre-Condition: The input for month is between 1 and 12
     *     Violation: Results in month being set to the default month of 1.
     *     
     * Post-Condition: If this criteria is met the parameter int month will be 
     *                 assigned to the month instance variable
     */
    public void setMonth(int month){
        try{
            if(month>12 || month<1)//Checks if the parameter is in the required bounds
                throw new DateException("("+month+" does not represent a month)");
            else
                this.month=month;
            }
        catch(DateException e){
            System.err.println(e);
            System.out.println("Error: setting month to default");
            this.month=1;
        }  
    }
    /**
     * Pre-Condition: The input for year is between 2014 and 2024
     *     Violation: Results in year being set to the default year of 2014.
     *     
     * Post-Condition: If this criteria is met the parameter int year will be 
     *                 assigned to the year instance variable
     */
    public void setYear(int year){
        try{
            if(year>2024 || year<2014){ //Checks year is within the required bounds
                throw new DateException("("+year+" is not an acceptable choice of year)");
            }
            else
                this.year=year;
            }
        catch(DateException e){
            System.err.println(e);
            System.out.println("Error: setting year to default");
            this.year=2014;
        }  
    }
    
    //Other Methods
    /**
     *  Pre-Condition: the object being compared in equals() is of the class Date
     *                 and the values of their instance variables, month, day, and
     *                 year are equal to the others month, day and year.
     * Post-Condition: If this criteria is met equals() will return True.
     */
    public boolean equals(Object toCompare){
        try{
            if(toCompare.getClass()!=(new Date()).getClass()){ //Makes sure object is a Date object
                throw new DateException("Trying to copare different entities");              
            }
            else{
                Date that=(Date)toCompare;
                if(this.month==that.month && this.day==that.day && this.year==that.year)
                    return true;  
            }
        }
        catch(DateException e){//Catches exception thrown by trying to compare a !Date object.
            System.err.println(e);
        }
        return false;
    }
    /**
     * toString complies the instance variables of the class into a single string value which 
     * is then returned to the calling location. There are no pre-conditions for this method.
     */
    public String toString(){ 
        return (month+"/"+day+"/"+year);
    }
    
    //Getter Methods
    /**
     * The following methods are "getter methods" for retreiving data held
     * in the class instance variables and return values accordingly.
     * There are no pre-conditions for these methods.
     */
    public int getMonth(){  
        return month;
    }
    public int getDay(){
        return day; 
    }
    public int getYear(){
        return year; 
    }
    
    /**
     * DateException handels any exceptions that the program may encounter.
     */
    public class DateException extends Exception{
        public DateException(){
            super("Invalid Date Entry");
        }
        public DateException(String message){
            super("Invalid Date Entry "+message);
        }
    }
}
