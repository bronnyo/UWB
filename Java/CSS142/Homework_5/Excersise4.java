
/**
 * Write a description of class Excersise4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Excersise4
{
   public static void main(String[] args){
    int[] testArray={5, 6, 7, 8, 9};
    
    System.out.print("{ ");
    for(int i=0; i<testArray.length; i++){
        testArray[i]+=i;
        System.out.print(testArray[i]+" ");
    }
    System.out.println("}");
    
    
    int testArray2[]= new int[testArray.length];
    System.out.print("{ ");
    for(int i=0; i<testArray2.length; i++){
        testArray2[i]=testArray[i]-i;
        System.out.print(testArray2[i]+" ");
    }
    System.out.println("}");
    }
}
