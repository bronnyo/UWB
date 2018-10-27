
/**
 * Write a description of class PizzaStock_Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PizzaStock_Tester
{
    public static void main(String[] args){
        //randomPizzaGenerator();
        eatPizzaTester(); 
        //compareToTester();    
    }
    public static void compareToTester(){
        Pizza pizza1=new Pizza();
        pizza1.addIngredient(new Mozzerella(200));
        pizza1.addIngredient(new Alfredo(200));
        pizza1.addIngredient(new Pepperoni());
        
        System.out.println(pizza1.toString()+"\n");
        
        Pizza pizza2=new Pizza();
        pizza2.addIngredient(new Mozzerella(200));
        pizza2.addIngredient(new Alfredo(200));
        pizza2.addIngredient(new Pepper());
        pizza2.addIngredient(new Olive());
        
        System.out.println(pizza2.toString()+"\n");
        
        System.out.println("Compare To (cost): "+pizza1.compareTo(pizza2));
        System.out.println("Compare To (calories): "+pizza1.compareToByCalories(pizza2));
        System.out.println("Compare To (size): "+pizza1.compareToBySize(pizza2));
        
        System.out.println("Eating some of Pizza1");
        pizza1.eatSomePizza(new Fraction(1,8));
        System.out.println("Compare To (size): "+pizza1.compareToBySize(pizza2));
    }
    public static void eatPizzaTester(){
        Pizza pizza=new Pizza();
        pizza.addIngredient(new Mozzerella(200));
        pizza.addIngredient(new Alfredo(200));
        pizza.addIngredient(new Pepperoni());
        
        System.out.println(pizza.toString());
        
        pizza.eatSomePizza(new Fraction(1,8));
        
        System.out.println(pizza.toString());
        
        pizza.eatSomePizza(new Fraction(1,4));
        
        System.out.println(pizza.toString());
        
        pizza.eatSomePizza(new Fraction(3,4));
        
        System.out.println(pizza.toString());
    }
    public static void randomPizzaGenerator(){
        ArrayList<Pizza> pizzaStock=new ArrayList<Pizza>();
        double AREA=200.96;
        int selection;        
        for(int i=0; i<10; i++){
            Pizza pizza=new Pizza();
            selection=(int)(Math.random()*2+1);
            switch(selection){
                case 1:pizza.addIngredient(new Mozzerella(AREA));
                       break;
                case 2:pizza.addIngredient(new Goat(AREA));
                       break;
            }
            selection=(int)(Math.random()*2+1);
            switch(selection){
                case 1:pizza.addIngredient(new Marinara(AREA));
                       break;
                case 2:pizza.addIngredient(new Alfredo(AREA));
                       break;
            }
            int numberOfToppings=(int)(Math.random()*5);
            int k;
            for(k=0; k<numberOfToppings; k++){
               selection=(int)(Math.random()*4+1);
               switch(selection){
                   case 1: pizza.addIngredient(new Pepperoni());
                           break;
                   case 2: pizza.addIngredient(new Sausage());
                           break;
                   case 3: pizza.addIngredient(new Olive());
                           break;
                   case 4: pizza.addIngredient(new Pepper());
                           break;
                }
            }
            System.out.println(pizza.toString());
            pizzaStock.add(pizza);
            }
    }
}
