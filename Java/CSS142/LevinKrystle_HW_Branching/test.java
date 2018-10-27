
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    public static void main(String[] args){
     System.out.println("The times are: " +a+" "+b+" "+c);
     System.out.println("First Place is: " +minTime());
     System.out.println("Second Place is: " +midTime());
     System.out.println("Third Place is: " +maxTime());
     System.out.println();
     System.out.println("The range of the race times, in seconds, are: " +rangeOfTimes());  
     System.out.println("The average race time, in seconds, is: " +averageTime());  
     System.out.println("Test: " +Math.max(Math.max(a,b),c)+ " is the looser");
       
    }
    
    //the following are race times
    public static final double a= 1.32;
    public static final double b= 2.04;
    public static final double c= 3.57;
    
    //the following are calculation processes
     public static double minTime(){
            double mn1= Math.min (a,b);
            double mn2= Math.min(b,c);
            double mnT= Math.min(mn1,mn2);
            return mnT;
        }
     public static double maxTime(){ 
        double mx1= Math.max(a,b);
        double mx2= Math.max(b,c);
        double mxT= Math.max(mx1,mx2);
        return mxT;
        }
       public static double midTime(){
         double midT= (a+b+c-maxTime()-minTime());
         return midT;
        }
    public static double rangeOfTimes(){
        double range= (maxTime() - minTime());
        return range;
    }
    public static double averageTime(){
    double avg=((a+b+c)/3.00);
    return avg;
    }
    }


