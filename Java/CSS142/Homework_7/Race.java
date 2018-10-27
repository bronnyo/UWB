import java.util.*;

/**
 * This class, Race, records, mainupulates, and
 * calculates stats for the race times provided
 * by the user. The constructor initializes the
 * instance variables to a time of 0 seconds
 * a mutator method is then called to assign new
 * values to the instance variables where they are
 * sent to be properly sorted from least to greatest.
 * 
 * From there the values are then 
 * used in assesor methods that then return a
 * tie value, both for first and last, in 
 * addition to those that return an average
 * and range of the given race times.
 * 
 * The class also contains methods that allow
 * the class instance variables to be referenced
 * ouside of this given class.
 *
 * @author (Krystle S Levin)
 * @version (November 24th 2017)
 */
public class Race
{
    //Instance Variables:
    private double firstPlace;
    private double secondPlace;
    private double thirdPlace;
    
    //Contructor: (default set to 0 seconds)
    public Race(){
        firstPlace=0;
        secondPlace=0;
        thirdPlace=0;
     }
    //Mutator methods for updating the default values:
    public void readInput(double input1, double input2, double input3){
        firstPlace=input1;
        secondPlace=input2;
        thirdPlace=input3;
        //testMethod(firstPlace, secondPlace, thirdPlace);
        sortOrder();
     }
    public void sortOrder(){
        double temp1=firstPlace;
        double temp2=secondPlace;
        double temp3=thirdPlace;
        
        firstPlace=Math.min(Math.min(temp1,temp2),temp3);
        thirdPlace=Math.max(Math.max(temp1,temp2),temp3);
        secondPlace=(temp1+temp2+temp3)-(firstPlace+thirdPlace);
        //testMethod(firstPlace, secondPlace, thirdPlace);
     }
     
    //Tie assesor methods:
    public int findTiesForFirst(){
        if((firstPlace==secondPlace)&&(firstPlace==thirdPlace))
           return 3;
        else if ((firstPlace==secondPlace)&&(firstPlace!=thirdPlace))  
           return 2;
        else
           return 0;   
     }
    public int findTiesForLast(){
        if((secondPlace==thirdPlace)&&(firstPlace!=secondPlace))
           return 2;
        else   
           return 0;
     } 
    //Range and average assessor methods:
    public double getRange(){
        double range=(thirdPlace-firstPlace);
        ////System.out.printf("%.4f %n", range);
        return range;
     }
    public double getAverage(){
        double average= ((firstPlace + secondPlace + thirdPlace)/3);
        //System.out.printf("%.4f %n", average);
        return average;
     }
     
    //Methods for accessing the Instance Variables outside the class:
    public double getFirst(){
        //System.out.println(firstPlace); 
        return firstPlace;
     }
    public double getSecond(){
        //System.out.println(secondPlace);
        return secondPlace;
     } 
    public double getThird(){
        //System.out.println(thirdPlace);
        return thirdPlace;
     }  
     
     /*public void testMethod(double test1, double test2, double test3){
        System.out.print("Test Value 1: "+test1+"; ");
        System.out.print("Test Value 2: "+test2+"; ");
        System.out.print("Test Value 3: "+test3+"; ");
      }*/
      
}
