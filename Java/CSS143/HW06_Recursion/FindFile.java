import java.io.*;;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * FindFile searches through files and directories to find a target file.
 * Caution: this is a linear search and may take some time if your starting 
 * path is to vauge in relation to the the file that you're searching for.
 *
 * @author (Krystle S Levin)
 * @version (February 16th, 2018)
 */
public class FindFile
{
    //Instance varables:
    public static final int MAX_NUMBER_OF_FILES=10;
    private int userMax;
    private int count;
    private String[] files;
    //Default Constructor
    public FindFile(){
        files= new String[MAX_NUMBER_OF_FILES];
        count=0;
    }
    //User specified constructor:
    public FindFile(int maxFiles) throws ItemNotFoundException{
        if(maxFiles>0){//Checks for valid input
            userMax=maxFiles;
            files= new String[userMax];
            count=0;
        }
        else
            throw new ItemNotFoundException("Cannot search for 0 or less than 0 files");
    }
    /**
     * Method: directorySearch
     * Pre-Condition: File dir is not null and can be read, target file is also a non null string
     * post condition: String[] files will be updates with the path of each individual file
     *                 found according to the start position. If there is only one file under
     *                 the starting directory then the array will only be filled with one String.
     */
    public void directorySearch(File dir, String target)throws ItemNotFoundException{
        File[] fileFolder= dir.listFiles();//fills array with the files names in the directory
        int i=0;
        if (count == files.length-1)//ensures that the array is not full
            throw new ItemNotFoundException("Max number of files to find has been reached");
            
        if(fileFolder!=null){//ensures that file exists
            while(i<fileFolder.length) { //goes through and checks each file in the directory
                if(target.equals(fileFolder[i].getName())){
                    files[count]=fileFolder[i].getPath();//adds file path to the array
                    count++;//updates available index in the array
                }
                else if(fileFolder[i].isDirectory()){//if file is a directory starts new recursion
                    directorySearch(fileFolder[i], target);
                }
                i++;
            }
            return;
        }
       
        // throw new ItemNotFoundException();
    }
    /**
     * GetterMethods:
     * toString: returns one string of al file paths
     * 
     * getCount: returns the number of files paths there are for the target file
     * 
     * getFiles: returns a copy of the array containing the file paths of the target file.
     */
    public int getCount(){
        return this.count;
    }
    public String toString(){
        String allPaths="";
        for(int i=0; i<count; i++)
            allPaths+=(files[i]+" \n");
        return allPaths;
    }
    public String[] getFiles(){
        return Arrays.copyOf(files, files.length);
    }
}
