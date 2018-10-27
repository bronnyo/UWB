import java.io.*;;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver simply uses main in a usual way such that it drives findFile.
 * Caution: this is a linear search and may take some time if your starting 
 * path is to vauge in relation to the the file that you're searching for.
 * 
 * Also: unless your name is the same as mine i am sure you will want to
 * change the directory file object.
 * 
 * @author (Krystle S Levin)
 * @version (February 16th, 2018)
 */
public class Driver
{
    public static void main(String[] args){
        String lookFor=null;;
        FindFile file=null;
        try{
            file= new FindFile();
            File directory=new File("C:/Users/Krystle/Desktop/");
            lookFor="FindMe.txt";
            file.directorySearch(directory, lookFor);
        }
        catch (ItemNotFoundException e){
            System.out.println(e);
        }
        System.out.println(lookFor+" appears "+file.getCount()+" times:");
        System.out.println(file.toString());
        
        
        
        
    }
}
