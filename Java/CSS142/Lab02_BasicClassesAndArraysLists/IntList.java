
/**
 * Write a description of class IntList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntList
{
    private int data[];
    private int elements;
    private int sum;
    public IntList(){
        elements=0;
        data=new int[100];
        sum=0;
    }
    public void add(int n){
        data[elements]=n;
        elements++;
        sum+=n;
    }
    public int indexOf(int n){
        int index=0;
        for(int i=0; i<elements; i++){
            if (data[i]==n){
                index=i;
                break;
            }
            if(i==elements-1 && data[i]!=n){
                System.out.println("Number is not found in data");
                index=000;
            }
        }
        return index;
    }
    public String toString(){
        String ofData="";
        for (int i=0; i<elements; i++)
            ofData+=(data[i]+", ");
        return ofData;
    }
    public int[] getData(){
        return data;
    }
    public int getElements(){
        return elements;
    }
    public int getSum(){
        return sum;
    }
}
