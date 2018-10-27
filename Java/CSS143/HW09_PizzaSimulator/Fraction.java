import java.util.*;
/**
 * Fraction takes in a fraction and then finds
 * its most reduced form before being sent to
 * Fraction counter where it is stored and
 * its frequency can be accounted for.
 *
 * @author (Krystle S Levin)
 * @version (January 18th 2018)
 */
public class Fraction implements Comparable, Cloneable
{
   //Instance variables:
   private int numerator;
   private int denominator;
   
   //Constructors:
   public Fraction(){//default
       numerator=0;
       denominator=1;
    }
   public Fraction(int n, int d){//input
       numerator=reduce(n,d)[0];
       denominator=reduce(n,d)[1];
    }
    
   //The following are individual setter for each the numerator and denominator
   public void setNumerator(int n){
       numerator=reduce(n,denominator)[0]; 
       //sent to reduce, in case the pre-existing denominator and n ave a GCD
    }
   public void setDenominator(int d){
       denominator=reduce(numerator,d)[0];
       //sent to reduce, in case the pre-existing numerator and d ave a GCD
    }
   //The following reduced the fraction
   public int[] reduce(int n, int d){
       int[] temp={n,d};
       for(int i=2; i<=Math.max(n,d)/2; i++){//reduces fraction
           if(temp[1]%i==0 && temp[0]%i==0){
               temp[0]/=i;
               temp[1]/=i;
               i=1;
           }
       }
       return temp; 
       //returns and array to reduce numerator and denominator together
    }
   //toString  is a standard required class
   public String toString(){
       return (numerator+"/"+denominator);
    }
   //getter methods: 
   public int getNumerator(){
       return numerator;
    }
   public int getDenominator(){
       return denominator;
    }
   /**
    * Method: clone()
    * Returns a copy of this Money to whereever it is being called.
    */
   public Fraction clone(){
        try{
            Fraction copy= (Fraction)super.clone();
            copy.numerator=(int)numerator; 
            copy.denominator=(int)denominator;
            return copy;
        }
        catch(CloneNotSupportedException e){
            return null;
        }
    }
   public int compareTo(Object other){
       if(!(other instanceof Fraction)){
            System.out.println("Sorry you can't compare Pizzas with non Pizzas");
            return 0;
        }
       Fraction that=(Fraction)other;
       if(this.denominator==that.denominator){
           if(this.numerator<that.numerator)
                return 1;
           if (this.numerator>that.numerator){
               return -1;
            }
           return 0; //the fractions are equal
        }
       double thisFrac=((1.0*this.numerator)/(1.0*this.denominator));
       double thatFrac=((1.0*that.numerator)/(1.0*that.denominator));
       if(thisFrac<thatFrac)
            return -1;
       if(thisFrac>thatFrac)
            return 1;
       return 0;
    }
}
