
/**
 * Write a description of class Collatz_Conjecture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Collatz_Conjecture
{
    private int[][] conjectureArray;
    private int[] powersOfTwo;
    /**
     * Constructor for objects of class Collatz_Conjecture
     */
    public Collatz_Conjecture()
    {
        conjectureArray= new int [100][5];
        powersOfTwo=new int[20]; 
        int result=1;
        int i;
        for(i=0; i<powersOfTwo.length; i++){
            powersOfTwo[i]=result;
            result*=2;
        }
    }
    public int[][] setConjectureArray(){
        int i;
        for(i=0; i<conjectureArray.length; i++){
            conjectureArray[i][0]=i+1;
            int count=0;
            int numOfDivides=0;
            int numOfMultiplies=0;
            while(conjectureArray[i][1]!=1){
                if(conjectureArray[i][1]%2==0){
                    numOfDivides++;
                    count++;
                    for(int j=0; j<powersOfTwo.length; j++){
                        if(conjectureArray[i][1]==powersOfTwo[j])
                            conjectureArray[i][4]=powersOfTwo[j];
                    }
                }
                else{
                    numOfMultiplies++;
                    count++;
                    for(int j=0; j<powersOfTwo.length; j++){
                        if(conjectureArray[i][1]==powersOfTwo[j])
                            conjectureArray[i][4]=powersOfTwo[j];
                    }
                    }
                conjectureArray[i][2]=numOfDivides;
                conjectureArray[i][3]=numOfMultiplies;
                }
            } 
        return conjectureArray;    
    }
    public String powerToString(int number){
        int power=0;
        do{
            number/=2;
            power++;
        }while(number>=1);
        String twoRaisedTo=("2^"+power);
        return twoRaisedTo;
    }
} 
