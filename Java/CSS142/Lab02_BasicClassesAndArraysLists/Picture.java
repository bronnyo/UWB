
/**
 * Write a description of class Picture here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Picture  {
    private Circle[] myCircles = new Circle[100];
    private int numCircles;
    private Square[] mySquares = new Square[100];
    private int numSquares;
    public Picture(){
      numCircles=0;
      numSquares=0;
    }
    public void addCircle(Circle next) { 
        myCircles[numCircles++] = next;
        numCircles++;
    }
    public void addSquare(Square next)   {
        mySquares[numSquares++] = next;
        numSquares++;
    }
    public String toString() {
        String both="";
        int i;
        for(i=0; i<numCircles; i++)
            both+=(myCircles[i]+" ");
        for(i=0; i<numSquares; i++)
            both+=(mySquares[i]+" ");    
        return both;
    }
}
