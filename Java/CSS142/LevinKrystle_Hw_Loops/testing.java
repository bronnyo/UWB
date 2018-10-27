import java.util.Scanner;
/**
 * Write a description of class testing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class testing
{
    public static void main(String[] args){
     Scanner sc=new Scanner(System.in);
     System.out.println("please enter stuff");
     while(!sc.hasNext("[A,a,c,C,t,T,g,G]+")){
         System.out.println("Nope, re-try");
         sc.next();
        }
     String sequence=sc.next();
     System.out.println("Thanks!");
    }
}
