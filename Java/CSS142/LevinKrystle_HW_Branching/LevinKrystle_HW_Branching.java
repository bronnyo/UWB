import java.util.Scanner;
/**
 * Branching Race Winners and their times
 *
 * @author (Krystle S. Levin)
 * @version (October 17, 2017)
 */
public class LevinKrystle_HW_Branching
{
public static void main(String[] args){
   System.out.println("The program will loop four times as a way for convienience");
   System.out.println("of assessing different possible outcomes.");
    
   for(int a=1; a<=4; a++){
    lnSpace();
    System.out.println("............");
    lnSpace();
    System.out.println("Begin Race number" +a+ ".");
    introAndSort();
   }
    thanks();
}
   
 
    public static void lnSpace(){//because I was tired of println
    System.out.println();    
    } 
        
    public static void raceRange(double range){//prints range
      lnSpace();
      System.out.printf("The range of time throughout the race is %4.2f", range);  
    }
    public static void average(double avg){ //prints average 
     System.out.printf("\nThe average time between the three racers is %4.2f", avg);   
    }
    public static void thanks(){//end of program statement
     lnSpace();
     System.out.println("............");
     lnSpace();
     System.out.println("Thank you for joining us at the races.");
    }

    
  public static void introAndSort(){// handles: keyboard input and race outcomes.
     Scanner keyboard= new Scanner(System.in);
     System.out.println("Hello, what are the names of your three racers?");
     String R1=keyboard.next();
     String R2=keyboard.next();
     String R3=keyboard.next();
     
     System.out.println("Please enter their race times, in seconds.");
     double T1=keyboard.nextDouble();
     double T2=keyboard.nextDouble();
     double T3=keyboard.nextDouble();
     
     double range= ((Math.max(Math.max(T1,T2),T3))-(Math.min(Math.min(T1,T2),T3)));
     double avg=((T1+T2+T3)/3);
    
     //if-else for possible outcomes
        if((T1==T3)&&(T1==T2)){
            lnSpace();
            System.out.println("Tied Race: " +R1+ ", " +R2+", and "+R3+" all share first place!");
        }
        else if (((T1==T2)&&T1>T3)||((T1==T3)&&T1>T2)||((T2==T3)&&T2>T1)){
            lnSpace();
            tieForSecond(T1,T2,T3,R1,R2,R3);
            //determines tie for second   
        }
        else if (((T1==T2)&&T1<T3)||((T1==T3)&&T1<T2)||((T2==T3)&&T2<T1)){
            lnSpace();
            tieForFirst(T1,T2,T3,R1,R2,R3);
            //Determines tie for first
        }
        else{//determines no-tie ordering
            lnSpace();
            noTie(T1,T2,T3,R1,R2,R3);
        }
     raceRange(range);
     average(avg);
     
}

//**** processes for sorting ****
    //Tie for first possibility
    public static void tieForFirst(double T1, double T2, double T3, String R1,String R2, String R3){
        double max= (Math.max(Math.max(T1,T2),T3));
             if (T1!=max && T2!=max){
                System.out.println(R1+" and "+R2+" Tie for first with "+T1+" seconds!");
                System.out.println(R3+" takes second at "+T3+" seconds.");
               }
               else if (T1!=max && T3!=max){
                System.out.println(R1+" and "+R3+" Tie for first with "+T1+" seconds!");
                System.out.println(R2+" takes second at "+T2+" seconds.");
               }
               else{
                System.out.println(R2+" and "+R3+" Tie for first with "+T2+" seconds!");
                System.out.println(R1+" takes second at "+T1+" seconds." );
               }   
    }
  
    //tie for second possibility
    public static void tieForSecond(double T1, double T2, double T3, String R1,String R2, String R3){
        double min= Math.min(Math.min(T1,T2),T3);
               if (T1!=min && T2!=min){
                System.out.println(R3+" takes first at "+T3+" seconds." );   
                System.out.println(R1+" and "+R2+" Tie for second with "+T2+" seconds!");
               }
               else if (T1!=min && T3!=min){
                System.out.println(R2+" takes first at "+T2+" seconds." );   
                System.out.println(R1+" and "+R3+" Tie for second with "+T1+" seconds!");
               }
               else{ 
                System.out.println(R1+" takes first at "+T1+" seconds.");   
                System.out.println(R2+" and "+R3+" Tie for second with "+T2+" seconds!");
               }   
    }
    //No tie possibility (1st, 2nd, third)    
    public static void noTie(double T1, double T2, double T3, String R1,String R2, String R3){
     double first=Math.min(Math.min(T1,T2),T3);
            double third=Math.max(Math.max(T1,T2),T3);
            double two= (T1+T2+T3-first-third);
                if(T1==first){
                  if(third==T2){ 
                  System.out.println(R1+" takes first place at "+T1+" seconds.");
                  System.out.println(R2+" takes second place at "+T2+" seconds."); 
                  System.out.println(R3+" takes third place at "+T3+" seconds."); 
                  }
                  else{
                  System.out.println(R1+" takes first place at "+T1+" seconds.");
                  System.out.println(R2+" takes second place at "+T2+" seconds."); 
                  System.out.println(R3+" takes third place at "+T3+" seconds.");    
                  }
                }
                else if(T2==first){
                if(third==T3){ 
                  System.out.println(R2+" takes first place at "+T2+" seconds.");
                  System.out.println(R1+" takes second place at "+T1+" seconds."); 
                  System.out.println(R3+" takes third place at "+T3+" seconds."); 
                  }
                  else{
                  System.out.println(R2+" takes first place at "+T2+" seconds.");
                  System.out.println(R3+" takes second place at "+T3+" seconds."); 
                  System.out.println(R1+" takes third place at "+T1+" seconds.");    
                  }    
                }
                else{
                if(third==T1){ 
                  System.out.println(R3+" takes first place at "+T3+" seconds.");
                  System.out.println(R2+" takes second place at "+T2+" seconds."); 
                  System.out.println(R1+" takes third place at "+T1+" seconds."); 
                  }
                  else{
                  System.out.println(R3+" takes first place at "+T3+" seconds.");
                  System.out.println(R1+" takes second place at "+T1+" seconds."); 
                  System.out.println(R2+" takes third place at "+T2+" seconds.");    
                  }    
                }   
    }
//**** end sorting process ****
}
