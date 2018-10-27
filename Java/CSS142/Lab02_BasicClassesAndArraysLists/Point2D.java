
/**
 * Write a description of class Point2D here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point2D
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    /**
     * Constructor for objects of class Point2D
     */
    public Point2D(){
        // initialise instance variables
        x = 0;
        y=0;
    }
    public Point2D(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void resetToOrigin(){
        this.x=0;
        this.y=0;
    }
    public void translate(int x, int y){
        this.x+=x;
        this.y+=y;
    }
    public String toString(){
        return ("("+x+","+y+")");
    }
    public boolean equals(Point2D that){
        if(this.x==that.x && this.y==that.y)
            return true;
        return false;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
