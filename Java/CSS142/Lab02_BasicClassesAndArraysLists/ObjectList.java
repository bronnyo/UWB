
/**
 * Write a description of class ObjectList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ObjectList
{
    private Object[] myShapes;
    private int elements;
    public ObjectList(){
        myShapes=new Object[100];
        int elements=0;
    }
    public void add(Object shape){
        this.myShapes[elements]=shape;
        this.elements++;
    }
    public String toString(){
        String stuff="";
        for (int i=0; i<elements; i++)
            stuff+=(myShapes[i]+" ");
        return stuff;
    }
    public Object[] getMyShapes(){
        return myShapes;
    }
    public int getNumOfElements(){
        return elements;
    }
}
