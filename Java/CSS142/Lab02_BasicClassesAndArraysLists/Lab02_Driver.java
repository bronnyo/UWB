
/**
 * 1) Why did we do so much copying and pasting in our software above?
 *      to become more aware of the issues that some with doing so
 *      such as syntax errors and wrongly named methods within their classes
 *      
 *(2)Are there obvious improvements that could be made here with respect the software 
 *   design for Squares and Circles?
 *      The could be put into the same class, as essentially their class definitions 
 *      are nearly identical.
 *      
 * 3)What programming constructs were you familiar with, and which did you need to look up?
 *      Considering the last 3 weeks of 142 last quarter was all about classes, i was pretty familiar
 *      with all of these constructs and didnt have to look up a single thing.
 *      
 * 4) Assume we used a separate array for Squares and for Circles rather than one unifying Object array.
 *    How would this complicate the task of adding a new Shape (say, a Triangle) to our ObjectListclass?
 *      you would then have to go back through your program and create yet 
 *      another array just for triangles.
 *   
 * @author (Krystle S Levin)
 * @version (Lab 02 1/15/2018)
 */
public class Lab02_Driver
{
    public static void main(String[] args){
        System.out.println("Due Date of assignment:");
        Date today=new Date("January", 15, 2018);
        System.out.println(today.toString());
        lnBreak();
        
        System.out.println("Point 2D Exercise:");
        point2Ddriver();
        lnBreak();
        
        System.out.println("Int List Exercise:");
        intListDriver();
        lnBreak();
        
        System.out.println("Circles and Squares Exercise:");
        shapesPictureDriver();
        lnBreak();
    }
    public static void lnBreak(){
        System.out.println();
    }
    public static void point2Ddriver(){
        Point2D a = new Point2D();
        a.setX(5);
        a.setY(2);
        System.out.println("Point at (" + a.getX() + ", " + a.getY() );
        a.translate(-1,-1);
        System.out.println("Point at (" + a.getX() + ", " + a.getY() );
        a.resetToOrigin();
        System.out.println("Point at (" + a.getX() + ", " + a.getY() );
        Point2D b = new Point2D();
        Point2D c = new Point2D();
        System.out.println(b.toString());
        System.out.println(c);  //Question: why don’t I need c.toString() here?
        //Java automatically calls the method that returns a string value.
        System.out.println("Are b and c equal:" + b.equals(c));
    }
    public static void intListDriver(){
        IntList a = new IntList();
        a.add(95);
        a.add(100);
        a.add(58);
        System.out.println(a.toString() );
        System.out.println("Sum: "+a.getSum());
        System.out.println("Index of 100: "+a.indexOf(100));
        System.out.println(a.indexOf(20));
    }
    //precondition: assumes {Square, Circle, Picture} all exist in the same working directory
    //postcondition: 2 Squares, 2 Circles, and 1 Picture are constructed and manipulated, then reclaimed  once main exits
    public static void shapesPictureDriver(){
        Square firstSquare = new Square();
        Square secondSquare = new Square(10,20);
        firstSquare.setX(3);
        firstSquare.setY(4);
        System.out.print( "Drawing the first square : " + firstSquare.toString());
        System.out.println(firstSquare.dimentions());
        firstSquare.draw();
        secondSquare.setWidth(30);
        secondSquare.setHeight(30);
        System.out.print( "Drawing the next square with area : " + secondSquare.getArea());
        System.out.println(secondSquare.dimentions());
        secondSquare.draw();
        lnBreak();
        
        //now for some circles
        Circle firstCircle = new Circle();
        Circle secondCircle = new Circle(5,5);
        firstCircle.setX(1);
        firstCircle.setY(5);
        firstCircle.setradius(3);
        System.out.println( "Drawing the first circle : " + firstCircle.toString());
        System.out.println(firstCircle.dimentions()); 
        firstCircle.draw();
        secondCircle.setX(2);
        secondCircle.setY(10);
        secondCircle.setradius(6);
        System.out.println( "Drawing the second circle with area " + secondCircle.getArea());
        secondCircle.draw();
        lnBreak();
        
        //now, lets see the bigger picture
        ObjectList picture = new ObjectList();
        picture.add( firstSquare );
        picture.add( secondSquare );
        picture.add( firstCircle );
        picture.add( secondCircle );
        System.out.println( "Drawing a Picture with Circles and Squares:\n" );
        System.out.println(picture.toString());
    }
}
