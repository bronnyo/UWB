
/**
 * Write a description of class Conjecture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Conjecture_Test
{
    private Collatz_Conjecture relevant=new Collatz_Conjecture();
    public void printStuff(){
        
        int[][] conjecture=relevant.setConjectureArray();
        
        for(int i=0; i<20; i++){
            String power=relevant.powerToString(conjecture[i][4]);
            
            System.out.print("The conjecture of "+conjecture[i][0]);
            System.out.println(" has "+conjecture[i][1]+" modifications");
            System.out.print("With "+conjecture[i][2]+" divisions by two and ");
            System.out.println(conjecture[i][3]+" modifications 1 more than its multiple of 3");
            System.out.println("The conjecture approaches 1 through "+power);
            System.out.println();
        }
    }
    public static void test(){
         int[] naturalNums= new int[100];
            int i;
            for(i=0; i<naturalNums.length; i++){
                naturalNums[i]=i+1;
                System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                System.out.println("Conjecture for: "+naturalNums[i]);
                int count=0;
                while(naturalNums[i]!=1){
                    if(naturalNums[i]%2==0){
                        System.out.print(naturalNums[i]+"(/2) = ");
                        naturalNums[i]/=2;
                        System.out.print(naturalNums[i]+" :: ");
                        count++;
                        if(count%5==0)
                            System.out.println();
                    }
                    else{
                        System.out.print(naturalNums[i]+"(*3+1) = ");
                        naturalNums[i]= ((naturalNums[i]*3) + 1);
                        System.out.print(naturalNums[i]+" :: ");
                        count++;
                        if(count%5==0)
                            System.out.println();
                    }
                }
                System.out.println();
                System.out.println("Conjecture count= "+count);
            }
        }
}
