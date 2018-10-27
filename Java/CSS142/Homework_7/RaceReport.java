import java.util.*;
/**
 * RaceReport contains methods that print out results 
 * of the race by making extracting data from the assessor 
 * and mutator methods located in the class Race.
 * 
 * This class is simply a write-output type of class
 * with one assessor method to determine if the user
 * would like to continue with the program.
 *
 * @author (Krystle S Levin)
 * @version (November 24th 2017)
 */
public class RaceReport
{
    private Race racers=new Race();//"wakes up" the Race class processes.
    public void newRace(){
        System.out.println("Enter three race times (in seconds): ");
        Scanner input=new Scanner(System.in);
        double racer1=0;
        double racer2=0;
        double racer3=0;
        //the folowing checks for valid input without ending the program
        boolean done=false;
        while(!done){
            try{
                racer1=input.nextDouble();
                racer2=input.nextDouble();
                racer3=input.nextDouble();
                done=true;
            }
            catch(InputMismatchException e){
                input.nextLine();
                System.out.println("Invalid Input please try again.");
            }
        }
        racers.readInput(racer1, racer2, racer3);
    }
    public void placement(){
        double first=racers.getFirst();
        double second=racers.getSecond();
        double third=racers.getThird();
        System.out.printf("First Place (time in seconds): %.2f %n", first);
        System.out.printf("Second Place (time in seconds): %.2f %n", second);
        System.out.printf("Third Place (time in seconds): %.2f %n", third);
    }
    public void ties(){
        int firstPlaceTie=racers.findTiesForFirst();
        int lastPlaceTie=racers.findTiesForLast();
        if(firstPlaceTie==3)
            System.out.println("*** All racers share first place ***");
        else if(firstPlaceTie==2)
            System.out.println("*** Two racers share first place ***");
        else if(lastPlaceTie==2)
            System.out.println("*** Two racers share second place ***");
        System.out.println();
    }
    public void stats(){
        double range=racers.getRange();
        double average=racers.getAverage();
        System.out.printf("The range of race times (in seconds): %.2f %n",range);
        System.out.printf("The average of all racers (in seconds): %.2f %n", average);
        System.out.println();
    }
    
    //The following are the assessor methods to determine if user would like to continue:
    public String getAnswer(){
        System.out.println(); 
        System.out.println("Would you like to enter another Race?");
        Scanner input=new Scanner(System.in);
        String answer=input.next();
        
        return answer;
    }
    public boolean moreRaces(){
        boolean done=false;
        while(!done){     
            String userAnswer=getAnswer();
            if(userAnswer.equalsIgnoreCase("yes")||userAnswer.equalsIgnoreCase("y")){
                //System.out.println("Y = T");
                done=true;
                return true;
            }
            else if (userAnswer.equalsIgnoreCase("no")||userAnswer.equalsIgnoreCase("n")){
                //System.out.println("N = F");
                done=true;
                return false;
            }
            else{
                System.out.println("Sorry not a valid answer.");
            }
        }
        return false;
    }
}
