import java.util.*;
/**
 * PrintStats contains methods that print out results 
 * of the conjecture by extracting data from the assessor 
 * and mutator methods located in the class C.
 * 
 * This class is simply a write-output type of class
 * with one assessor method to determine if the user
 * would like to continue with the program.
 *
 * @author (Krystle S Levin)
 * @version (December 8th 2017)
 */
public class PrintStats
{
    private CalcStats stats=new CalcStats(); //wakes up use of CalcStats class
    
    //The following is an intro to the user what the program does
    public void conjectureDefinition(){ 
        System.out.println("Welcome to the Collatz Conjecture Tester!");
        System.out.println();
        System.out.println("By definition, the Collatz Conjecture states that:");
        System.out.println("If an integer \"n\", is repeatedly: ");
        System.out.println("divided by 2 (if the result is even)");
        System.out.println("or if the result is odd result=3n+1");
        System.out.println("Then the result will eventually reach 1");
        System.out.println();
        System.out.println("This test will give you various stats of your desired test number.");
        System.out.println();
    }    
    //The following promts user input and sends it to readInput in CalcStats to be assessed
    public void newConjectureTest(){ 
        System.out.println("Please enter an integer between 1 and 100");
        Scanner input=new Scanner(System.in);
        int number=0;
        boolean done=false;
        while(!done){
            try{
                number=input.nextInt();
                if(number > 100 || number < 1)
                    System.out.println("Please enter a valid number");   
                else 
                     done=true;
            }
            catch(InputMismatchException e){
                input.nextLine();
                System.out.println("Invalid Input please try again.");
            }
        }
        stats.readInput(number);
    }
    //The following reiterates the number that is being tested
    public void selectedNum(){ 
        //Variables being retrieved:
        int test=stats.getOriginal();
        //Printing of the variables (with formatting):
        System.out.println();
        System.out.println();
        System.out.println("***********************************************");
        System.out.println();
        System.out.println("The stats for the Collatz Conjecture of "+test+":");
        System.out.println("-----------------------------------------------");
        
    }    
    //The following prints the modification stats of the conjecture
    public void conjectureModifications(){
        //Variables being retrieved:
        int total=stats.getTotalModifications();
        int divisions=stats.getNumOfDivides();
        int multiplies=stats.getNumOfMultiplies();
        int sum=stats.getSum();
        //Printing of the variables:
        System.out.println("There are "+total+" total modifications:");
        System.out.println(divisions+" divisions by two");
        System.out.println(multiplies+" increases of one more than 3 times the result.");
        System.out.println("The sum of all modifications is: "+sum);
        System.out.println("-----------------------------------------------");
    }
    //The following prints which power of two the number uses to get to 1
    public void pathway(){ 
        //Variables being retrieved:
        int power=stats.getPathToOne();
        int max=stats.getMaxNumber();
        //Printing of the variables:
        System.out.println("Your number approaches 1 through 2^"+power);
        System.out.println("The highest number reached was "+max);
        System.out.println();
    }
    //The following takes in the users answer for running another conjecture
    public String getAnswer(){ 
        Scanner input=new Scanner(System.in);
        String answer=input.next();
        return answer; //answer is returned to be used in method to check validity
    }    
    //The following checks validity of the string produced in the previous method
    //and then returns boolean to Driver to determine if program loops again
    public boolean anotherConjecture(){
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
                System.out.println("Sorry not a valid answer, please respond yes or no");
            }
        }
        return false;
    }
}
