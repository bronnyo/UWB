import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Circle is the parent for Cylinder and the child of Shape. 
 * Circle adds the instance variable radius to this specific 
 * shape and may draw it accordingly as well as calculate the
 * area of the specific circle.
 *
 * @author (Krystle S Levin)
 * @version (February 10th 2018)
 */
public class Circle extends Shape
{
    //Added instance variable specific to this class:
    private int radius;
    
    //Constructors:
    public Circle(int x, int y){ 
        super(x,y);                 //sends start point to the parent
        this.radius=200;            //sets default radius to 200
    }
    public Circle(int x, int y, int radius){
        super(x,y);                 //sends start point to the parent
        this.radius=radius;         //Sets radius to user specified value
    }
    
    //Setter Methods:
    public void setRadius(int radius){//Changes the value of the radius
        this.radius=radius;
    }
    
    //Getter Methods
    public int getRadius(){         //returns the int value of the radius
        return radius;
    }
    public double getArea(){        //returns the calculated area of the circle
        return 3.14*radius*radius;
    }
    public int getX(){              //returns the x coordinate start point
        return super.getX();
    }
    public int getY(){              //returns the y coordinate start point
        return super.getY();
    }
    
    /**
     * No pre-conditions other than initialization of the class
     * Will draw an red filled circle according the the specified
     * radius and will also draw a black outline of the circle.
     */
    public void draw(Graphics g){ 
        //Drawing filled circle:
        g.setColor( Color.RED );
        g.fillOval(super.getX(), super.getY(), radius, radius);
        
        //Drawing outline of circle:
        g.setColor(Color.BLACK);
        g.drawOval(super.getX(), super.getY(), radius, radius);
        
    }
}
