import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * HanoiTower draws a post with either 3 or a specified amount of
 * rings to sit on it. The rings are then colored with a random
 * color generator, of which are semi transparent as to veiw the
 * post upon which they sit.
 *
 * @author (Krystle S Levin)
 * @version (February 10th 2018)
 */
public class HanoiTower extends Shape
{
    //Added instance variable:
    private int numberOfRings;
    
    //Constructors:
    public HanoiTower(int x, int y){
        super(x,y);
        this.numberOfRings=3;//sets default numberOfRings to 3
    }
    public HanoiTower(int x, int y, int numberOfRings){
        super(x,y);
        this.numberOfRings=numberOfRings;//user specified amount of rings
    }
    
    //Setter methods:
    /**
     *  Pre-Condition: the int parameter must be less than 16
     * Post-Condition: the number of rings for the tower will
     *                 be set to the specified parameter value
     */
    public void setNumberOfRings(int numberOfRings){
        if(numberOfRings>15)
            this.numberOfRings=15;
        else
            this.numberOfRings=numberOfRings;
    }
    
    //getter methods:
    public int getNumberOfRings(){//returns the number of rings
        return this.numberOfRings;
    }
    public int getX(){//returns x start point coordinate
        return super.getX();
    }
    public int getY(){//returns y start point coordinate
        return super.getY();
    }
    
    /**
     * No pre-conditions other than initialization of the class
     * Will draw a gray Hanoi post and then populate it with
     * semi transparent rings whose color is randomly selected
     * from the getRandColor method.
     */
    public void draw(Graphics g){
        //Sets boundaries for the size of the tower
        int towerHeight=180;
        int ringSize=(180/(this.numberOfRings+2));
        if(ringSize%2!=0)//ensures that the first can be centered
            ringSize++;
        
        //Draws the post that the rings sit on
        g.setColor(Color.GRAY);
        g.fillRect(super.getX()+80,super.getY(),20, towerHeight);
        
        //Draws the rings
        int bottom= super.getY()+towerHeight-ringSize;//sets the coordinates for the first ring
        for(int i=0; i<numberOfRings; i++){  
            //Loop draws the rings
            
            //draws a ring filled with a random transparent color:
            g.setColor(getRandColor());
            g.fillRoundRect(super.getX()+(5*i), bottom, 180-(10*i), ringSize, 20, (ringSize-2/2));
            
            //draws the outline of the ring:
            g.setColor(Color.BLACK);
            g.drawRoundRect(super.getX()+(5*i), bottom, 180-(10*i), ringSize, 20, (ringSize-2/2));
            
            //resets the coordinates for the next ring to be drawn:
            bottom-=ringSize;
        }
        
    }
    
    /**
     * Random color generator for your Hanoi Rings
     * returns a random color for each ring
     * no preconditions
     */
    public Color getRandColor(){
        switch( ( int )(Math.random() * 8) ) { //picks a random number and returns an associated color
           case 0: return new Color(204, 51, 0,100); 

           case 1: return new Color(255, 191, 0, 100); 
 
           case 2: return new Color(225, 255, 0, 100);

           case 3: return new Color(0, 255, 0, 100);                
 
           case 4: return new Color(0, 191, 255, 100);
           
           case 5: return new Color(191, 0, 255, 100); 

           case 6: return new Color(255, 0, 191, 100); 
 
           case 7: return new Color(255, 225, 225, 100); 

           case 8: return new Color(0, 0, 0, 100);                     
           
            }
        return Color.BLUE;//to keep the compiler happy
    }
}
