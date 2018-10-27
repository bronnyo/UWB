import java.util.*;
import java.io.*;

/**
 * This program asks the user to input values for:
 * Mass, cross-sectional area, drag coefficiant, 
 * total time of the dive, and the desired time interval
 * of the Skydiver. In addition to the desired file
 * that the user wishes to use to store the data.
 * 
 * The program then takes the user's input and uses it
 * to compute the diver's velocity in respect to T.
 * Once computed the data is then imported into the user's
 * desired file and printed in such a way that data can 
 * be sorted in a csv or excel file.
 * 
 * The program will repeat as many times as the user desires.
 *
 * @author (Krystle S Levin)
 * @version (Novemeber 9th, 2017)
 */
public class LevinKrystle_HW_Arrays
{
    //Declaration of Scanner input to be used in multiple methods:
    public static final Scanner INPUT=new Scanner(System.in);
    
    public static void main(String[] args){
     double[] variables=introAndInput(); 
     double[] time=timeArray();
     PrintWriter data=outputFile();
  
     velocity(variables, time);
     double[] v=velocity(variables,time);
     
     System.out.println("Writing out file. Here are the first few lines:");
     for(int i=1; i<time.length; i++){
         data.printf("%.2f, %.4f %n", time[i],v[i]);
         //TEST: System.out,printf("%.2f, %.4f %n", time[i],v[i]);
         if(i<10){
             System.out.printf("%.2f , %.4f %n", time[i],v[i]);
         }
     } 
     
     //equationTest(variables,time);
     //^checks for proper computation
     
     data.close();//end first entry
     
     
     
     //Prompt for additional unlimited entries:
     System.out.println();
     System.out.println("Would you like to enter another Skydiver?");
     String answer=INPUT.next();
     while(answer.equalsIgnoreCase("y")){
         variables=introAndInput(); 
         time=timeArray();
         data=outputFile();
      
         velocity(variables, time);
         v=velocity(variables,time);
         
         System.out.println("Writing out file. Here are the first few lines:");         
         for(int i=1; i<time.length; i++){
             data.printf("%.2f, %.4f %n", time[i],v[i]);
             if(i<10){
                 System.out.printf("%.2f , %.4f %n", time[i],v[i]);
             }
         }            
         data.close();
         
         System.out.println();
         System.out.println("Would you like to enter another Skydiver?");
         answer=INPUT.next();
        }
     System.out.println("Thank you for using this program.");
     System.out.println("Happy Diving!");
     
    }
    
    //The following records input values as an array to be passed through main.
    public static double[] introAndInput(){
      double[] massAreaDrag=new double[3];
        
      System.out.print("Enter the mass of the skydiver (kg): ");
      massAreaDrag[0]=INPUT.nextInt();
        
      System.out.print("Enter the cross-sectional area of the skydiver (m^2): ");
      massAreaDrag[1]=INPUT.nextDouble();
        
      System.out.print("Enter the drag coefficient of the skydiver (kg): ");
      massAreaDrag[2]=INPUT.nextDouble();
      
      return massAreaDrag;
    }
    
    //The following creates an array of time intervals.
    public static double[] timeArray(){
      System.out.print("Enter the ending time (sec): ");
      int totalTime=INPUT.nextInt();
        
      System.out.print("Enter the time step (sec): ");
      double deltaT=INPUT.nextDouble(); 
      
      int length=(int)(1+(totalTime/deltaT));
      double[] time=new double[length];
        
      time[0]=0;
      for(int i=1;i<length;i++){
          time[i]= deltaT*(i);
          //TEST: System.out.printf("%.2f %n",time[i]);
      }
      
      return time;
    }
    
    //The following attempts to find output file and returns location for printwriter
    public static PrintWriter outputFile(){
      System.out.print("Enter the output filename: ");
      String file=INPUT.next();
        
      FileOutputStream fileOutput= null;
      PrintWriter output=null;
      try{
        fileOutput= new FileOutputStream(file);
        output=new PrintWriter(fileOutput);
      }
      catch(FileNotFoundException e){
          System.out.println("File Could not be reached");
          System.exit(0);
      }
        
      return output;
    }
    
    //The following records and returns an array representing velocity in respect to time.
    public static double[] velocity(double[] variables, double[] time){  
      double mass=variables[0];
      double area=variables[1];
      double drag=variables[2];
      double deltaT=time[1];
      
      double[] v=new double[time.length];
      v[0]=0;
      for(int i=1; i<time.length; i++){
         v[i] = v[i-1] + (9.81 - (((drag * area * 1.14)/(2 * mass)) * v[i-1] * v[i-1])) * deltaT;
         //TEST: System.out.printf("%.2f %n",v[i]);
      }
      
      return v;
    }
    
    //The following method is used to test and print sequence of computed values.
    public static void equationTest(double[] variables, double[] time){
      double mass=variables[0];
      double area=variables[1];
      double drag=variables[2];
      double deltaT=time[1]; 
      
      double[] testV=new double[5];
      testV[0]=0;
      for(int i=1; i<5; i++){
          testV[i] = testV[i-1] + (9.81 - (((drag * area * 1.14)/(2 * mass)) * testV[i-1] * testV[i-1])) * deltaT;
          double p1=(drag * area * 1.14);
          double mass2=(2 * mass);
          double vt2=(testV[i-1]*testV[i-1]);
          
          System.out.printf("Velocity at %.2f seconds=",time[i]);
          System.out.printf(" %.2f + ((9.81 - [(%.2f / %.2f)*%.4f]) * %.2f) %n", testV[i-1],p1,mass2,vt2,deltaT);
          
          Double tEv=(p1/mass2);
          System.out.print  ("                       =");
          System.out.printf("%.2f + ((9.81 - [%.4f * %.4f]) * %.2f) %n", testV[i-1],tEv,vt2,deltaT);
          
          double allP= (tEv*vt2);
          System.out.print  ("                       =");
          System.out.printf("%.f + ((9.81 - %.4) * %.2f) %n", testV[i-1],allP,deltaT);
          System.out.printf("                    = %.2f %n", testV[i]);
          
          
      }
    }
}

