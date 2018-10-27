
/**
 * Write a description of class testingStuff here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class testingStuff
{
    public static void main(String[] args){
        int a,b;
        a=6;
        b=a;
        System.out.println("a: "+a+"    b: "+b);
        b=4;
        System.out.println("a: "+a+"    b: "+b);
        int[] c={1,2,3};
        int[] d=c;
        d[1]=5;
        for (int i=0; i<3; i++)
            System.out.println("c["+i+"]: "+c[i]+"    d["+i+"]: "+d[i]);
    }
}
