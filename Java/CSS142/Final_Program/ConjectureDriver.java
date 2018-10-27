
/**
 * ConjectureDriver is a class that contains the main method.
 * Here, the order of what is to be printed is specified.
 * Moreover, the commands lie within a loop that allows 
 * the user to repeat the program as many times as he or 
 * she desires.
 * 
 * ConjectureDriver calls upon the class Print Stats to print
 * data that has been collection in the class CalcStas.
 *
 * @author (Krystle S Levin)
 * @version (December 8th, 2017)
 */
public class ConjectureDriver
{
    public static void main(String[] args){
        //Conjecture_Tester_Class test=new Conjecture_Tester_Class();
        //test.test();
                                //Note: Conjecture_Tester_Class was made and is called to check the
                                //accuracy of the programmed sequence and asses possible bugs easier
                                
        //Program begins now:
        PrintStats print=new PrintStats();      //wakes up PrintStats
        print.conjectureDefinition();           //intro to what the program is
        
        boolean again= true;                    //allows for repitition to users liking
        while (again){
            print.newConjectureTest();          //prompts for user input 
            print.selectedNum();                //reiterates the integer being tested      
            print.conjectureModifications();    //prints number of times the integer is modified
            print.pathway();                    //prints the power of 2 the int uses to get to 1
            
            System.out.println("***********************************************");
            System.out.println();               //this just creates a nice division between trials
            
            System.out.println(); 
            
            System.out.println("Would you like to enter another conjecture?");
            again=print.anotherConjecture();    //Takes in and checks users reponse to the prompt and
                                                //then returns a boolean value to assign to "again"
            System.out.println();    
        }
        
        System.out.println("Thank you for using the Conjecture Tester");//end of program
    }
}
