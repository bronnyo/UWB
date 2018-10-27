import java.util.*;
import java.io.*;
/**
 * Write a description of class LevinKrystle_FractionsV1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FirstDraft
{
    public static void main(String[] args){
        Scanner inputStream= null;
        int[][] fileFractions=new int[50][3];
        int count=0;
        double[] asDecimal=new double[50];
        try{
            inputStream= new Scanner(new FileInputStream ("fractions.txt")); 
            
            while(inputStream.hasNextLine()){
                String newFraction=inputStream.nextLine();
                String[] splitFraction=newFraction.split("/");
                fileFractions[count][0]=Integer.parseInt(splitFraction[0]);
                fileFractions[count][1]=Integer.parseInt(splitFraction[1]);
                asDecimal[count]=((1.000*fileFractions[count][0]) / (1.000*fileFractions[count][1]));
                
                //testPrint(fileFractions[count][0],fileFractions[count][1],asDecimal[count]);
                count++;
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        
        findCommon(fileFractions, asDecimal, count);
        System.out.println(count);
    }
    public static void findCommon(int[][] array, double[] decimals, int size){
        Arrays.sort(decimals);
        
        
        for(int i=0; i<decimals.length; i++){
            double temp=decimals[i];
            int count=1;
            for(int j=i+1;j<decimals.length-1; j++){
                if(temp==decimals[j]){
                    //System.out.println(temp+" : "+decimals[j]);
                    count++;
                    //System.out.println(count);
                    decimals[j]=-1;
                    i++;
                    
                }
            }
            
                        for(int k=0; k<size; k++){
                            if(temp==((array[k][0]*1.000)/(array[k][1]*1.000))){
                                if(i!=1 && decimals[i]!=decimals[i-1]){
                                System.out.print("There are "+count+" versions of ");
                                System.out.println(array[k][0]+"/"+array[k][1]);
                            }
                        }
                    }
        }
    }
    public static void testPrint(int numerator, int denominator, double decimal){
        System.out.print("Numerator: "+numerator+"  /  Denominator: "+denominator);
        System.out.printf("  Decimal Value: %.5f %n",decimal);
    }
}
