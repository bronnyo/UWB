import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Cylinder is a child of circle and draws an orange 
 * 3D cylinder of specified height and radius, as 
 * well as calculating the are of the cylinder.
 *
 * @author (Krystle S Levin)
 * @version (February 10th 2018)
 */
public class Cylinder extends Circle
{
    //New instance variables unique to the class:
    private int diameter;
    private int height;
    
    //Constructors:
    public Cylinder(int x, int y){ //default constructor
        super(x,y);                         //sends start point to parent
        this.diameter=super.getRadius()*2;  //uses parents default radius constructor
        this.height=10;                     //sets default height to 10
    }
    public Cylinder(int x, int y, int height){
        super(x,y);                         //sends start point to parent
        this.diameter=super.getRadius()*2;  //uses parents default radius constructor
        this.height=height;                 //Assigns user defined height to the instance variable
    }
    public Cylinder(int x, int y, int radius, int height){
        super(x,y,radius);                  //sends start point and radius to parent
        this.diameter=super.getRadius()*2;  //generates a value for diam
        this.height=height;                 //Assigns user defined height to the instance variable
    }
    
    //Set Methods
    public void setHeight(int height){//Allows user to adjust height of the Cylinder
        this.height=height;
    }
    
    //Getter Methods:
    public int getHeight(){     //returns the height of the Cylinder
        return this.height;
    }
    public int getDiameter(){   //returns the diameter of the Cylinder
        return this.diameter;
    }
    public int getX(){          //returns x start point coordinate
        return super.getX();
    }
    public int getY(){          //returns y start point coordinate
        return super.getY();
    }
    public double getArea(){    //returns the calculated area of the cylinder
        return super.getArea()*height;
    }
    
    /**
     * No pre-conditions other than initialization of the class
     * Will draw an orange Cylinder according the the specified
     * height and by using the radius as the height of the oval
     * in addition to using the diameter as the length of the 
     * oval to provide a sense of dimention to the 2-D object.
     */
    public void draw(Graphics g){ 
        //Sets the color of the Cylinder:
        g.setColor( Color.ORANGE );
        
        //Draws the filled shaoe of the Cylinder:
        g.fillOval(super.getX(), super.getY(), this.diameter, super.getRadius());
        g.fillOval(super.getX(), super.getY()+this.height, this.diameter, super.getRadius());
        g.fillRect(super.getX(), super.getY()+(super.getRadius()/2), this.diameter, this.height);
        
        //Sets the color for the outline of the Cylinder
        g.setColor(Color.BLACK);
        
        //Draws the top and bottom of the Cylinder
        g.drawOval(super.getX(), super.getY(), this.diameter, super.getRadius());
        g.drawArc(super.getX(), super.getY()+this.height, this.diameter, super.getRadius(),180, 180);
        
        //Draws the side lines for the Cylinder:
        g.drawLine(super.getX(), super.getY()+(super.getRadius()/2), 
                   super.getX(), super.getY()+height+(super.getRadius()/2));
        g.drawLine(super.getX()+diameter, super.getY()+(super.getRadius()/2), 
                   super.getX()+diameter, super.getY()+height+(super.getRadius()/2));

    }
}
