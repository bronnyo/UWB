import java.util.*;
/**
 * Write a description of class Race here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RaceTest
{
    private double firstPlace;
    private double secondPlace;
    private double thirdPlace;
   
    public void readInput(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter three race times (in seconds): ");
        double racer1=input.nextDouble();
        double racer2=input.nextDouble();
        double racer3=input.nextDouble();
        
        sortOrder(racer1, racer2, racer3);
     }
    public void sortOrder(double temp1, double temp2, double temp3){
        this.firstPlace=Math.max(Math.max(temp1,temp2),temp3);
        this.thirdPlace=Math.min(Math.min(temp1,temp2),temp3);
        this.secondPlace=(temp1+temp2+temp3)-(firstPlace+thirdPlace);
    }
    public RaceTest(double racer1, double racer2, double racer3){
        sortOrder(racer1, racer2, racer3);
    }
    
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
    
    public double getFirst(){
         return firstPlace;
     }
    public double getSecond(){
         return secondPlace;
     } 
    public double getThird(){
         return thirdPlace;
     }  
   
    public double getRange(){
       double range=(firstPlace-secondPlace);
       return range;
     }
    public double getAverage(){
        double average= ((firstPlace + secondPlace + thirdPlace)/3);
        return average;
     }
}
    

