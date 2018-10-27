
/**
 * Write a description of class Array here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Array
{
    public static void main(String[] args){
        int[] myArray={5,16,27,38,42};
        myArray[2]++;
        myArray[0]=myArray[myArray.length-1];
        int[] a2=myArray;
        System.out.println(a2[1]+" "+myArray[1]);
        a2[1]=24;
        System.out.println(a2[1]+" "+myArray[1]);
        for(int j=0; j<5; j++){
            System.out.print(myArray[j]+" ");
        }
    }
}
