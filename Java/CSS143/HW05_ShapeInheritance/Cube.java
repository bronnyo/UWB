import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * Cube is a child of square and draws a cyan 3D 
 * cuboid of specified height, width, and length 
 * in addition to calculating the are of the cuboid.
 * 
 *
 * @author (Krystle S Levin)
 * @version (February 10th 2018)
 */
public class Cube extends Square
{
    //Instance variables specific to Cube
    private int depth;
    
    //Constructors:
    public Cube(int x, int y){
        super(x,y);             //uses parents default constructor for side lengths
        this.depth=30;          //sets default depth to 30
    }
    public Cube(int x, int y, int sides){ //sets height width and depth to the same value (perfect cube)
        super(x,y, sides, sides);
        this.depth=sides;
    }
    public Cube(int x, int y, int height, int width, int depth){ //sets all sides to different lengths
        super(x,y, height, width);
        this.depth=depth;
    }  
    
    //Setter Methods:
    public void setdepth(int depth){    //Sets new int value to depth of the cube
        this.depth=depth;
    }
    public void setHeight(int height){  //sends height int value to super to be reset
        super.setHeight(height);
    }
    public void setWidth(int width){    //sends width int value to super to be reset
        super.setWidth(width); 
    }
    
    //Getter Methods
    public int getdepth(){          //returns the depth of the cube
        return this.depth;
    }
    public int getHeight(){         //returns the height of the cube
        return super.getHeight();
    }
    public int getWidth(){          //returns the width of the cube
        return super.getWidth();
    }
    public double getArea(){        //returns the calculated area
        return super.getArea() * depth; 
    }
    public int getX(){              //returns the x coordinate start point
        return super.getX();
    }
    public int getY(){              //returns the y coordinate start point
        return super.getY();
    }
    
    /**
     * No pre-conditions other than initialization of the class
     * Will draw an cyan Cube according the the specified
     * height, width and depth using 1/2 depth as perspective
     * for the cube provide a sense of dimention to the 2-D object.
     */
    public void draw(Graphics g){ 
        int orgX=super.getX();
        int orgY=super.getY();
        
        int[] x={orgX, orgX+super.getWidth(), orgX+super.getWidth()+(depth),
                 orgX+super.getWidth()+(depth),orgX+(depth), orgX};
                 
        int[] y={orgY, orgY, orgY+(depth/2),orgY+super.getHeight()+(depth/2),
                 orgY+super.getHeight()+(depth/2),orgY+super.getHeight()};
                 
        g.setColor( Color.CYAN );
        g.fillPolygon(x,y, 6);
        
        g.setColor(Color.BLACK);
        g.drawPolygon(x,y,6);
        g.drawLine(orgX,orgY+super.getHeight(), orgX+super.getWidth(),orgY+super.getHeight());
        g.drawLine(orgX+super.getWidth(),orgY, orgX+super.getWidth(),orgY+super.getHeight());
        g.drawLine(orgX+super.getWidth(),orgY+super.getHeight(),orgX+super.getWidth()+(depth),
                    orgY+super.getHeight()+(depth/2));
        
    }
}
