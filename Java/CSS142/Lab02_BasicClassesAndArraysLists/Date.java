
/**
 * Write a description of class Date here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Date
{
    private int month;
    private int day;
    private int year;
    public Date(){
        this.month=1;
        this.day=2;
        this.year=2018;
    }
    public Date(int month, int day, int year){
        this.month=month;
        this.day=day;
        this.year=year;
    }
    public Date(String month, int day, int year){
        if(month.equalsIgnoreCase("January"))
            this.month=1;
        else if(month.equalsIgnoreCase("Febuary"))
            this.month=2;
        else if(month.equalsIgnoreCase("March"))
            this.month=3;
        else if(month.equalsIgnoreCase("April"))
            this.month=4;
        else if(month.equalsIgnoreCase("May"))
            this.month=5;
        else if(month.equalsIgnoreCase("June"))
            this.month=6;
        else if(month.equalsIgnoreCase("July"))
            this.month=7;
        else if(month.equalsIgnoreCase("August"))
            this.month=8;
        else if(month.equalsIgnoreCase("September"))
            this.month=9;
        else if(month.equalsIgnoreCase("October"))
            this.month=7;
        else if(month.equalsIgnoreCase("November"))
            this.month=8;
        else if(month.equalsIgnoreCase("December"))
            this.month=9;
        else
            System.out.println("Invalid input, month is set to January (1)");
        this.day=day;
        this.year=year;
    }
    public String toString(){
        if(month<10 && day<10)
            return("0"+month+"/0"+day+"/"+year);
        else if(month<10 && day>=10)
            return("0"+month+"/"+day+"/"+year);
        else if(month>=10 && day<10)
            return(+month+"/0"+day+"/"+year);
            
        return (month+"/"+day+"/"+year);
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int getYear(){
        return year;
    }
}
