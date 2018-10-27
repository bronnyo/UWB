
/**
 * Write a description of class Ingredient_TestDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ingredient_TestDriver
{
    public static void main(String[] args){
        
        System.out.println("** Base Sauces ** ** fixed rate **\n");
        
        Base A1=new Alfredo();
        System.out.println(A1.toString());
        A1.setAreaOfBase(452); 
        System.out.println(A1.toString()+"\n ");
        
        Base Ma1=new Alfredo();
        System.out.println(Ma1.toString());
        Ma1.setAreaOfBase(452); 
        System.out.println(Ma1.toString()+"\n \n");
        
        //**********************************************//
        
        System.out.println("** Cheeses ** ** fixed rate **\n");
        
        Cheese M1= new Mozzerella(-1);
        System.out.println(M1.toString());
        M1.setAreaOfCheese(452);   
        System.out.println(M1.toString()+"\n ");
        
        Cheese G1=new Goat();
        System.out.println(G1.toString());
        G1.setAreaOfCheese(-1);
        G1.setAreaOfCheese(452); 
        System.out.println(G1.toString()+"\n \n");
        
        //**********************************************//
        
        System.out.println("** Meat ** ** rate based on servings **\n");
        
        Meat S1=new Sausage();
        System.out.println(S1.toString());
        S1.changeServings(4); 
        System.out.println("4 servings of "+S1.toString()+"\n ");
        
        Meat P1=new Pepperoni(-1);
        System.out.println(P1.toString());
        P1.changeServings(2); 
        System.out.println("2 servings of "+P1.toString()+"\n \n");
        
        //**********************************************//
        
        System.out.println("** Vegetables ** ** rate based on servings **\n");
        Olive O1=new Olive();
        System.out.println(O1.toString());
        O1.changeServings(5);
        System.out.println("5 servings of "+O1.toString()+"\n \n");
        
        Pepper V1=new Pepper();
        System.out.println(V1.toString());
        V1.changeServings(2);
        System.out.println("2 servings of "+V1.toString()+"\n \n");
        
        
        for(int i=0; i<10; i++){
            System.out.println((int)(Math.random()*1));
        }
        
    }
}
