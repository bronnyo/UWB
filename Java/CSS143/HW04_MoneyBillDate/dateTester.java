
/**
 * Write a description of class dateTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class dateTester
{
    public static void main(String[] args){
        Date a= new Date( 13,13,13);
        System.out.println(a.toString());
        a.setDay(-1);
        a.setMonth(13);
        System.out.println(a.toString());
        a.setDay(20);
        a.setMonth(-12);
        a.setYear(2012);
        System.out.println(a.toString());
        a.setDay(33);
        a.setMonth(12);
        a.setYear(2030);
        System.out.println(a.toString());
        a.setDay(12);
        a.setYear(2017);
        System.out.println(a.toString());
        
        Date b= new Date(12, 12, 2014);
        System.out.println(b.toString());
        System.out.println("a = b: "+b.equals(a));
        b.setYear(2017);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println("a = b: "+b.equals(a));
        
    }
}
