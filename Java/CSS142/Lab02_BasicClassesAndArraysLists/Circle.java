
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle
{
    private int x;
    private int y;
    private double radius;
    private String shape;
    public Circle(){
        // initialise instance variables
        x=0;
        y=0;
        radius=1.0;
        shape="O";
    }
    public Circle(int x, int y){
        this.x=x;
        this.y=y;
        radius=1.0;
        shape="O";
    }
    public Circle(int x, int y, double radius){
        this.x=x;
        this.y=y;
        this.radius=radius;
        shape="O";
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setradius(double radius){
        this.radius=radius;
    }
    public boolean equals(Circle that){
        if((this.x==that.x) && (this.y==that.y) && (this.radius==that.radius))
            return true;
        return false;
    }
    public String toString(){
        return (shape);
    }
    public String dimentions(){
        return (" Centered at: ("+x+", "+y+") w/ Radius: "+radius);
    }
    public String draw(){
        return shape;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public double getradius(){
        return radius;
    }
    public double getArea(){
        return radius*radius*3.14;
    }
}