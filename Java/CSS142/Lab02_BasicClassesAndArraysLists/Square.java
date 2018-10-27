
/**
 * Write a description of class theSquareClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square
{
    private int x;
    private int y;
    private double sideLength;
    private double width;
    private double height;
    private String shape;
    public Square(){
        // initialise instance variables
        x=0;
        y=0;
        sideLength=1.0;
        shape="[]";
        width=1.0;
        height=1.0;
    }
    public Square(int x, int y){
        this.x=x;
        this.y=y;
        shape="[]";
        width=1.0;
        height=1.0;
        sideLength=1.0;
    }
    public Square(int x, int y, double sideLength){
        this.x=x;
        this.y=y;
        this.sideLength=sideLength;
        this.width=sideLength;
        height=1.0;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setSideLength(double sideLength){
        this.sideLength=sideLength;
    }
    public void setWidth(double w){
        this.width=w;
    }
    public void setHeight(double h){
        this.height=h;
    }
    public boolean equals(Square that){
        if((this.x==that.x) && (this.y==that.y) && (this.sideLength==that.sideLength))
            return true;
        return false;
    }
    public String toString(){
        return (shape);
    }
    public String dimentions(){
        return (" "+sideLength+" x "+width+" x "+height);
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
    public double getSideLength(){
        return sideLength;
    }
    public double getArea(){
        return sideLength*width*height;
    }
    
}
