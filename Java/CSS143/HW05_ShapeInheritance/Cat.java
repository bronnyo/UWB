import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * The class Cat draws a Cat graphic with two eyes
 * The cat's fur and eye color are randomly selected
 * you must love your adopted cat regaurdless.
 *
 * @author (Krystle S Levin)
 * @version (February 10th 2018)
 */
public class Cat extends Shape
{
    //There are no additional instance variables needed for this class
    
    //Constructor:
    public Cat(int x, int y){
        super(x,y);//sending to parent class
    }
    //Getter Methods
    public int getX(){//returns x start point coordinate
        return super.getX();
    }
    public int getY(){//returns y start point coordinate
        return super.getY();
    }
    //Draw methods:
    /**
     * No pre-conditions other than initialization of the class
     * Will draw a Cat that is either black, white, orange, gray
     * or light grey, with either yellow, red, blue or green eyes
     */
    public void draw(Graphics g){
        //Stores the original x and y start point
        int x=super.getX();
        int y=super.getY();
        
        //Array for the coordinates of the cat head polygon:
        int[] xArray={x, x, x+60, x+60, x+40, x+20 };
        int[] yArray={y,y+60, y+60, y, y+20, y+20};
        //Cat Head and Color:
        g.setColor( getRandCatColor() );
        g.fillPolygon(xArray,yArray, 6);  
        
        //Cat Body:
        g.fillRect(x+40, y+70, 80, 50);
        //Cat Legs:
        g.fillRect(x+20,y+60, 20, 100);
        g.fillRect(x+50, y+120, 20, 40);
        g.fillRect(x+90, y+120, 20, 40);
        g.fillRect(x+120, y+20, 20, 140);
        //Cat Tail:
        g.fillRect(x+80, y+20, 40, 20);
        g.fillRect(x+80, y+40, 20, 20);
        //Cat Eyes
        g.setColor( getRandEyeColor() );
        g.fillOval(x+10, y+30, 10, 15);
        g.fillOval(x+30, y+30, 10, 15);
                    
    }
    /**
     * Random color generator for your new cat
     * returns a random color for cat body
     * no preconditions
     */
    public Color getRandCatColor(){
        switch( ( int )(Math.random() * 4) ) {//picks a random number and returns an associated color
           case 0: return Color.BLACK; 

           case 1: return Color.ORANGE; 
 
           case 2: return Color.WHITE;

           case 3: return Color.LIGHT_GRAY;                
 
           case 4: return Color.GRAY;           
            }
        return Color.BLUE;//to keep the compiler happy
    }
    /**
     * Random color generator for the color of your cats eyes
     * returns a random color for the cat eyes
     * no preconditions
     */
    public Color getRandEyeColor(){
        switch( ( int )(Math.random() * 3) ) {//picks a random number and returns an associated color
           case 0: return Color.CYAN; 

           case 1: return Color.YELLOW; 
 
           case 2: return Color.GREEN;

           case 3: return Color.RED;                           
            }
        return Color.BLUE;//to keep the compiler happy
    }
}
