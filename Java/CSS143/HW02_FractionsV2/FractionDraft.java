import java.util.ArrayList;
/**
 * Write a description of class Fraction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FractionDraft
{
    private ArrayList<Integer>numerator;
    private ArrayList<Integer>denominator;
    private ArrayList<Integer>frequency;
    private int index;
    public FractionDraft(){
        numerator=new ArrayList<Integer>();
        denominator=new ArrayList<Integer>();
        frequency=new ArrayList<Integer>();
        index=0;
    }
    /*public void addNew(int n, int d){
        numerator.add(index, reduce(n,d)[0]);
        denominator.add(index, reduce(n,d)[1]);
        frequency.add(index, 1);
        index++;
    }*/
    public void addNew(String n, String d){
        int nNum=reduce(Integer.parseInt(n), Integer.parseInt(d))[0];
        int dNum=reduce(Integer.parseInt(n), Integer.parseInt(d))[0];
        if(compare(nNum, dNum)){
            numerator.set(index, nNum);
            denominator.set(index,dNum);
            frequency.set(index, 1);
            index++;
        }
    }
    //***Check if fraction values already exists before adding it to associated lists***
    public int[] reduce(int n, int d){
       int[] temp= {n,d};
       for (int i=2; i<=10; i++){
           if(temp[0]%i==0 && temp[1]%i==0){
               temp[0]/=i;
               temp[1]/=i;
            }
        }
       return temp;
    }
    public boolean compare(int n, int d){
        for(int i=0; i<index; i++){
            if (numerator.get(i)==n && denominator.get(i)==d){
                    frequency.add(i, frequency.get(i)+1);
                    return false;
            }
        }
        return true;
        }
    public ArrayList getNumerators(){
        return numerator;
    }
    public ArrayList getDenominators(){
        return denominator;
    }
    public ArrayList getFrequency(){
        return frequency;
    }
}
