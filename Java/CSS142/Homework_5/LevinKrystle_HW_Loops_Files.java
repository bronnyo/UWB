import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.*;

/**
 * This program imports a file "courseData.txt"
 * It then sorts the data into catagories per class
 * the program also computes:
 * Weighted Average per student, the Average for the class
 * and determines if each student passes or fails.
 * 
 * The program is also functional for
 * any size file or amount of data
 *
 * @author (Krystle S Levin)
 * @version (November 1st, 2017)
 */
public class LevinKrystle_HW_Loops_Files
{
    public static void main(String[] args){
       Scanner inputStream=null;
        try{//file input
           inputStream= new Scanner(new FileInputStream("courseData.txt"));
        }catch(FileNotFoundException e){
            System.out.print("File \"courseData.txt\" was not found");
            System.out.println("or could not be opened.");
            System.exit(0);
        }
        
        //variable initialization:
        double programWeight= inputStream.nextDouble();        
        double midtermWeight= inputStream.nextDouble(); 
        double finalWeight= inputStream.nextDouble();
        //for idividual grades:
        double gradeTotal=0;
        double studentAverage=0;
        //for cummulative grades:
        double studentCount=0;
        double cummulativeAverage=0;
        
        while(inputStream.hasNext()){//loops for totality of file
          double number=inputStream.nextDouble();
           
           if(number==161||number==162||number==263){ //records and prints class number and data catagories
                double classNumber= number;
                System.out.println();
                System.out.printf("Grade Data For Class %.0f: %n", classNumber);
                
                System.out.println(" ID   Programs  Midterm  Final  Weighted Average  Programs grade");
                System.out.println(" --   --------  -------  -----  ----------------  --------------");
                studentCount=0;
                cummulativeAverage=0;
            }
            else if(number!=0&&number!=161&&number!=162&&number!=263){
                //sorts and formats data, as well as computing or storing selected data   
                double programGrade=0.0;
                double midtermGrade=0.0;
                double finalGrade=0.0;
                
               for(int columns=1; columns<=7; columns++){
                  switch (columns){
                      case 1://ID
                          System.out.printf("%.0f", number);
                          break;
                          
                      case 2://Grade for programs and update for total grade
                          programGrade=inputStream.nextDouble();
                          System.out.printf("%7.0f", programGrade);
                          gradeTotal+=programGrade*programWeight;
                          //testWeightForPrograms(programWeight,programGrade);
                          break;
                          
                      case 3://Midterm grade and update for total grade   
                          midtermGrade=inputStream.nextDouble();
                          System.out.printf("%9.0f", midtermGrade);
                          gradeTotal+=midtermGrade*midtermWeight;
                          //testWeightForMidterm(midtermGrade,midtermWeight);
                          break;
                          
                      case 4://Final grade and update for total grade
                          finalGrade=inputStream.nextDouble();
                          System.out.printf("%9.0f", finalGrade);
                          gradeTotal+=finalGrade*finalWeight;
                          //testWeightForFinal(finalWeight, finalGrade);
                          break;
                          
                      case 5://Prints Total grade, adds score to cummulative average and add +1 studemt
                          System.out.printf("%13.2f         ", gradeTotal);
                          studentCount++;
                          cummulativeAverage+=gradeTotal;
                          //testFinalGrade(testWeightForPrograms(programWeight,programGrade),testWeightForMidterm(midtermWeight, midtermGrade),testWeightForFinal(finalWeight,finalGrade));
                          break;
                          
                      case 6://Determines pass or fail
                          if(gradeTotal>=70.00){
                            System.out.println("Pass");  
                            }
                          else System.out.println("Fail");
                          break;
                          
                      default://resets total grade for the next student entry
                           gradeTotal=0;
                           break;
                           
                    }
                  
                }
            }
            else if(number==0){//computes and prints class average
                double classAverage=(cummulativeAverage/studentCount);
                System.out.printf("Class Average: %.2f %n", classAverage);
            }
        
       }
       inputStream.close();
    }    
     public static double testWeightForPrograms(double programWeight, double programGrade){
         double weightOfPrograms=programWeight*programGrade;
         
         System.out.println();
         System.out.printf("The score of %.0f awards to %.0f percent", programGrade, weightOfPrograms);
         System.out.println(" of the students final average.");
         
         return weightOfPrograms;
        }
        
     public static double testWeightForMidterm(double midtermWeight, double midtermGrade){
         double weightOfMidterm=midtermWeight*midtermGrade;
         System.out.println();
         System.out.printf("The score of %.0f awards %.0f percent", midtermGrade, weightOfMidterm);
         System.out.println(" of the students final average.");
         
         return weightOfMidterm;
        }
        
     public static double testWeightForFinal(double finalWeight, double finalGrade){
         double weightOfFinal=finalWeight*finalGrade;
         System.out.println();
         System.out.printf("The score of %.0f awards to %.0f percent", finalGrade, weightOfFinal);
         System.out.println(" of the students final average.");
         
         return weightOfFinal;
        }
        
      public static void testFinalGrade(double weightOfPrograms,double weightOfMidterm, double weightOfFinal){
          double testFinalGrade=weightOfPrograms+weightOfMidterm+weightOfFinal;
          System.out.printf("The students final grade is %.2f %n",testFinalGrade);
          
        }
    //End of Program :)
}
