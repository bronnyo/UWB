
/**
 * Write a description of class Ex6_copyingArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ex6_copyingArray
{
    public static void main(String[] args){
        int answerOne[]=new int[16];
        for(int index=0; index<answerOne.length; index++){
           answerOne[index]=42;
           System.out.println(answerOne[index]);
           
        }
        
        int answerTwo[]= new int[answerOne.length];
        double total=0.0;
        for(int index=0; index<answerTwo.length; index++){
            if(index%2==0){
                answerTwo[index]=answerOne[index]+index;
                total+=answerTwo[index];
            }
            else{
                answerTwo[index]=answerOne[index];
                total+=answerTwo[index];
            }
        }
        double average=total/answerTwo.length;
        System.out.printf("Average of the elements in answer two: %.2f %n", average);
        
        System.out.println("Answer Three:");
        int answerThree[]=new int[answerTwo.length];
        for(int index=0; index<answerThree.length; index++){
            answerThree[index]=answerTwo[answerTwo.length-1-index];
            System.out.printf("Index %3s: %3s %n", index, answerThree[index]);
            
            //OR (without array answerThree):
            //System.out.printf("Index %3s: %3s %n", index, answerTwo[answerTwo.length-1-index]);
        }
    }
}
