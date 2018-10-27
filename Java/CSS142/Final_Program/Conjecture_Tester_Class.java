
/**
 * The following class was made soley to check
 * the accuracy and validity of my programmed
 * conjecture sequence with various int values
 * in which the conjecture sequence is known
 * or easily deduced.
 *
 * @author (Krystle S Levin)
 * @version (December 8th, 2017)
 */
public class Conjecture_Tester_Class
{
    public void test(){
        System.out.println("Test 1:");
        Stats(2);
        vSpace();
        System.out.println("Test 2:");
        Stats(5);
        vSpace();
        System.out.println("Test 3:");
        Stats(10);
        vSpace();
        System.out.println("Test 4:");
        Stats(3);
        vSpace();
        System.out.println("Test 5:");
        Stats(6);
        vSpace();
        System.out.println("Test 6:");
        Stats(11);
        vSpace();
        System.out.println("Test 7:");
        Stats(31);
        vSpace();
        System.out.println("Test 8:");
        Stats(33);
        vSpace();
        System.out.println("Test 9:");
        Stats(32);
        vSpace();
        System.out.println("Test:10");
        Stats(1);
        vSpace();
    }
    public void vSpace(){
        System.out.println();
    }
    public void Stats(int original){
        int temp=original;
        
        int totalModifications=0;
        int numOfDivides=0;
        int numOfMultiplies=0;
        int power=0;
        
        int[] powersOfTwo=new int[10];
        System.out.println("Powers of Two Array:");
        for(int i=0; i<powersOfTwo.length;i++){
            if(i==0){
                powersOfTwo[i]=1;
                System.out.print(powersOfTwo[i]+" ");
            }
            else{
                powersOfTwo[i]=powersOfTwo[i-1]*2;
                System.out.print(powersOfTwo[i]+" ");
            }
        }
        System.out.println();
        //System.out.println("Powers-of-two Loop Complete");
        System.out.println();
        int count=0;
        System.out.print(temp+" --> ");
        while(temp>1){
            if(temp%2==0){
                for(int j=0; j<powersOfTwo.length; j++){
                    if((power==0)&&(temp==powersOfTwo[j]))
                        power=powersOfTwo[j];
                }
                temp=temp/2;
                numOfDivides++;
                totalModifications++;
                System.out.print(temp+" --> ");
                count++;
            }
            else{
                temp=(temp*3)+1;
                numOfMultiplies++;
                totalModifications++;
                System.out.print(temp+" --> ");
                count++;
            }
            if (count%10==0)
                System.out.println();
        }
        System.out.println();
        //System.out.println("Conjecture Loop Complete");
        System.out.println("The number "+original+" has "+totalModifications+" modifications");
        System.out.println("Is divided "+numOfDivides+" times, and is multiplied "+numOfMultiplies+" times.");
        
        int raisedTo=0;
        while (power>1){
            //System.out.print(power+" ");
            power/=2;
            raisedTo++;
        }
        //System.out.println("Find Power Loop Complete");
        if (original==1)
            raisedTo=0;
        System.out.println("The path to one is through "+powersOfTwo[raisedTo]+" = 2^"+raisedTo);
    }   
}
