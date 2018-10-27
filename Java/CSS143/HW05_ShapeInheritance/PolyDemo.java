import java.util.*;
import javax.swing.*;
import java.awt.*;

/*
 * Class PolyDemo (is a JFrame) and PolyDemoPanel (is a JPanel)
 * 
 * Author: Rob Nash
 * 
 * Edited by: Krystle S Levin 2/10/2018
 */


class PolyDemo extends JFrame {
     public PolyDemo() { 
        getContentPane().add( new PolyDemoPanel() );
        //just some windowing stuff that must happen for all Frames
        setSize( 400,400 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    } 
    
    
    public static void main( String args[] ) {
        PolyDemo myApp = new PolyDemo();
    }
    
    
    //this is our first "inner" or internal class 
    //the purpose of this class is solely to support the JFrame class above, and 
    //I don't want it reused in arbitrary contexts, so by nesting this class here
    //I can indicate the intent a bit more clearly that this class "goes with" the class above it
    //In general, each class is a separate entity that should be contained in a separate file
    public class PolyDemoPanel extends JPanel {     
        Shape[] myShapes= new Shape[4];
        
        public PolyDemoPanel() {
            /************************************************************
            * Code for populating our myShapes changes minimally when   *
            * new classes are introduced (only in getRandShape())       *
            *************************************************************/
            for( int i = 0; i < 4; i++ ) {
                myShapes[i] =  getShape(i);
            }
        }
        
        /************************************************************************
         * Code for drawing our shapes doesn't change at all! Since we intended *
         * to take advantage of polymorphism, we coded this "in general" with   *
         * respect to the superclass, and not specific to any subclass.         *
         ************************************************************************/
        public void paint( Graphics g ) {
            super.paint(g);  //don't remove - required for GUI widgets to draw correctly
            /************************
             * Late Binding Demo
             ************************/
            for( int i = 0; i < myShapes.length; i++ ){
                //which draw method is invoked here? There are many forms of the method 
                //(polymorphic), so which is chosen? 
                // *the draw method found in the associated shape located at myShapes[i]*
                //Java has RTTI about every object, and it uses this info to choose the 
                //correct method to invoke!
                myShapes[i].draw( g );  
            } 

        }
        /**
         *  Pre-Condition: the int parameter is a int between 0 and 3
         * Post-Condition: getShape will return either a cube shape a Cat shape, 
         *                 a HanoiTower, or a cylinder shape, depending on the 
         *                 value of the int parameter 
         */
        public Shape getShape(int i){
            Shape toPaint=null;

            int x, y;
            if(i==0)
                toPaint=new Cube( 10, 10, 100, 100, 30 );
            else if(i==1)
                toPaint=new Cat( 200, 10); 
            else if(i==2)
                toPaint=new HanoiTower(10,150,(int)( Math.random()*10+1));
            else if(i==3)
                toPaint= new Cylinder(210,210, 50, 70 );
                            
            return toPaint;
        }
    }   
    
}




