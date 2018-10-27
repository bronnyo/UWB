import java.util.*;
import java.io.*;

/**
 * Write a description of class LevinKrystle_HW_Arrays here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class hw_draft
{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        
        System.out.print("Enter the mass of the skydiver (kg): ");
        double mass=input.nextInt();
        
        System.out.print("Enter the cross-sectional area of the skydiver (m^2): ");
        double area=input.nextDouble();
        
        System.out.print("Enter the drag coefficient of the skydiver (kg): ");
        double drag=input.nextDouble();
        
        System.out.print("Enter the ending time (sec): ");
        int totalTime=input.nextInt();
        
        System.out.print("Enter the time step (sec): ");
        double deltaT=input.nextDouble();        
        
        System.out.print("Enter the output filename: ");
        String file=input.next();
        
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
        
        System.out.println("Writing out file. Here are the first few lines:");
        double[] time=timeArray(totalTime, deltaT);
        double[] v=velocity(time, mass, area, drag,deltaT); 
        
        for(int i=1; i<time.length; i++){
            output.printf("%.2f, %.4f %n", time[i],v[i]);
            if(i<10){
                System.out.printf("%.2f , %.4f %n", time[i],v[i]);
            }
        }
        
        output.close();
    }
    
    public static double[] timeArray(int totalTime, double deltaT){
        int length=(int)(totalTime/deltaT);
        double[] time=new double[length];
        
        time[0]=0;
        for(int i=1;i<length;i++){
            time[i]= deltaT*(i);
        }
        
        return time;
    }
    
    public static double[] velocity(double[] time, double mass, double area, double drag, double deltaT){
        double[] v=new double[time.length];
        
        v[0]=0;

        for(int i=1; i<time.length; i++){
            v[i] = v[i-1] + (9.81 - (((drag * area * 1.14)/(2 * mass)) * v[i-1] * v[i-1])) * deltaT;
        }
        
        return v;
    }
}