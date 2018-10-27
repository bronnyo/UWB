import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Square is the parent for Cube and the child of Shape. 
 * Square adds the instance variables of height and width
 * to this specific shape and may draw it accordingly as well as 
 * calculate the area of the specific Square. 
 *
 * @author (Krystle S Levin)
 * @version (February 10th 2018)
 */
public class Square extends Shape
{
    //Instance variables specific to square
    private int height;
    private int width;
    
    //Constructors:
    public Square(int x, int y){ 
        super(x,y);             //sends start point to the parent class
        this.height=100;        //sets default height to 100
        this.width=100;         //sets default width to 100
    }
    public Square(int x, int y, int sides){//Assumes for desired square: height=width
        super(x,y);             //sends start point to the parent class
        this.height=sides;      //sets height to user specified int value
        this.width=sides;       //sets width to user specified int value
    }
    public Square(int x, int y, int height, int width){
        super(x,y);             //sends start point to the parent class
        this.height=height;     //sets height to user specified int value
        this.width=width;       //sets width to user specified int value
    }
    
    //Setter Methods
    public void setHeight(int height){  //Changes the value of height
        this.height=height;
    }
    public void setWidth(int width){    //Changes the value of width
        this.width=width;
    }
    
    //Getter Methods:
    public int getHeight(){         //returns the int value of height
        return height;
    }    
    public int getWidth(){          //returns the int value of width
        return width;
    }
    public double getArea(){        //Returns the calculated area of the square
        return this.height*this.width;
    }
    public int getX(){              //returns the x coordinate start point
        return super.getX();
    }
    public int getY(){              //returns the y coordinate start point
        return super.getY();
    }
    
    /**
     * No pre-conditions other than initialization of the class
     * Will draw a blue filled square according the the specified
     * height and width. Will also draw a black outline of the square.
     */
    public void draw(Graphics g){ 
        
        g.setColor( Color.BLUE );
        g.fill3DRect(super.getX(), super.getY(), height, width, true);
        
        g.setColor(Color.BLACK);
        g.draw3DRect(super.getX(), super.getY(), height, width, true);
    }
}
