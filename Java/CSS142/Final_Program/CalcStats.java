
/**
 * This class, CalcStats, records, mainupulates, and
 * calculates stats pertaining to the conjecture of
 * the users desired number to be tested.
 * The constructor initializes the
 * instance variables to base numbers
 * a mutator method is then called to assign
 * user input to the the main instance variable
 * which is then used to calculate the stats of
 * that specific number.
 * 
 * The class also contains methods that allow
 * the class instance variables to be referenced
 * ouside of this given class.
 *
 * @author (Krystle S Levin)
 * @version (November 24th 2017)
 */
public class CalcStats
{
    private int original;
    private int totalModifications;
    private int numOfDivides;
    private int numOfMultiplies;
    private int sum;
    private int powerOfTwoPath;
    private int maxNumber;
    
    //contsuctor of default values for the instance variables:
    public CalcStats(){
        original=1;
        totalModifications=0;
        numOfDivides=0;
        numOfMultiplies=0;
        sum=0;
        powerOfTwoPath=0;
        maxNumber=1;
    }
    //Takes in user input as argument and sets value for orginal, sum and maxNumber:
    public void readInput(int numberToApply){
        original=numberToApply;  
        sum=numberToApply;
        maxNumber=numberToApply;
        
        setStats(setPowersOfTwoArray());//calls methods to fil other variables
        //System.out.println("Original: "+original+", Sum: "+sum+", Max: "+maxNumber);
    }    
    //The following creates an array of powers of two:
    public int[] setPowersOfTwoArray(){
        int[] powersOfTwo=new int[10];
        for(int i=0; i<powersOfTwo.length;i++){
            if(i==0){
                powersOfTwo[i]=1;
                //System.out.print(powersOfTwo[i]+" ");
            }
            else{
                powersOfTwo[i]=powersOfTwo[i-1]*2;
                //System.out.print(powersOfTwo[i]+" ");
            }
            //testEndOfLoop();
        }
        return powersOfTwo;
    }    
    //The following modifies sum and maxNumber and fills the remaining instance variables
    public void setStats(int[] array){
        int temp=original; //temp used to leave original unaltered
        int power=0;
        int[] powersOfTwo=array;
        
        //Application Of Conjecture to Users Number:
        while(temp>1){
            if(temp%2==0){
                for(int j=0; j<powersOfTwo.length; j++){
                    if((power==0)&&(temp==powersOfTwo[j])){
                        power=powersOfTwo[j];
                        //testChaseElement(power);
                    }   
                }
                //testEndOfLoop();                 
                temp=temp/2;
                numOfDivides++;
                totalModifications++;
                sum+=temp;
            }
            else{
                temp=(temp*3)+1;
                if(temp>maxNumber){
                    maxNumber=temp;
                    //testChaseElement(maxNumber);
                }
                numOfMultiplies++;
                totalModifications++;
                sum+=temp;
            }
            //testChaseElement(numOfMultiplies);
            //testChaseElement(totalModifications);
            //testChaseElement(temp);
        }
        //testEndOfLoop();
        
        setPathToOne(power);
    } 
    //The following method finds which power of two the int value pass through to get to 1
    public void setPathToOne(int power){
        int twoToThe=0;
        do{
            //testChaseElement(power);
            power/=2;
            twoToThe++;
        }while (power>1);
        //testEndOfLoop();
        if (original==1)
            twoToThe=0;
        powerOfTwoPath=twoToThe;
    }    
    //The following two methods are for element chasing and finding the end of a loop
    //what I call my game of "duck, duck, goose" within my program :)
    public void testChaseElement(int element){
        System.out.print("Duck: "+element+" ");
    }
    public void testEndOfLoop(){
        System.out.println("Goose: End Of Loop");
    }
    
    //the following are "get" methods for retrieving the instance variables
    public int getOriginal(){
        return original;
    }
    public int getTotalModifications(){
        return totalModifications;
    }
    public int getNumOfDivides(){
        return numOfDivides;
    }
    public int getNumOfMultiplies(){
        return numOfMultiplies;
    }
    public int getSum(){
        return sum;
    }
    public int getPathToOne(){
        return powerOfTwoPath;
    }
    public int getMaxNumber(){
        return maxNumber;
    }
}

