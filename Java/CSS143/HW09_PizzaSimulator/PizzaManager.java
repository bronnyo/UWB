import java.util.Scanner;

/** PizzaManager Skeleton File
 *  CSS 162, Final Project
 * 
 *  This class is a starting point for your final project and is incomplete.
 *  Note that if there are any inconsistencies between this skeleton and
 *  the assignment description, the assignment description controls.
 * 
 *  Author: Rob Nash with edits by Johnny Lin  [ and Krystle S Levin (3/9/2018) ]
 */
public class PizzaManager { 
    /*
     *  TODO: Data definitions here.  
     */
    private final ArrayList<Pizza> pizzaStock=new ArrayList<Pizza>(); 
    private final double AREA=200.96;
    
    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection='q';
        
        Scanner foo = new Scanner(System.in);
        boolean done=false;
        while(!done) {
            //displayAllPizzas();
            displayInstructions();
            
            selection=foo.next().charAt(0);
             //foo.nextChar() doesn't exist, so now what?
            switch(selection) {
                case 'A':    
                case 'a':   System.out.println("Adding a random pizza to the ArrayList<Pizza>.");
                            addRandomPizza();
                            break;
                case 'H':    
                case 'h':   System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                            for(int i=0; i<100; i++){
                                addRandomPizza();
                             }
                            break; 
                case 'D':
                case 'd':   displayAllPizzas();
                            break;
                
                case 'E':    
                case 'e':   System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                            eatSomePizza(foo);
                            break;            
                case 'P':    
                case 'p':   System.out.println("Sorting pizzas by (P)rice");
                            sortByPrice();
                            break;    
                case 'S':    
                case 's':   System.out.println("Sorting pizzas by (S)ize");
                            sortBySize();
                            break;          
                case 'C':    
                case 'c':   System.out.println("Sorting pizzas by (C)alories");
                            sortByCalories();
                            break;
                case 'B':
                case 'b':   System.out.println("(B)inary search over pizzas by calories(int)."+
                            " Sorting first.  What calorie count are you looking for?");
                            int cals=foo.nextInt(); 
                            binarySearchByCalories(cals);
                            break;
                case 'Q':
                case 'q':   System.out.println("(Q)uitting!" );
                            done=true;
                            break;
                            
                default:    System.out.println("Unrecognized input - try again");
            }
        }

    }
    /**
     * EatSomePizza subtracts a specified fractional amount from a random pizza
     */
    private void eatSomePizza(Scanner keys) { 
        keys=new Scanner(System.in); 
        String input=keys.next();
        String[] splitInput=input.split("/");
        
        int randomIndex=(int)(Math.random()*pizzaStock.size());
        
        Pizza currentPizza=pizzaStock.get(randomIndex);
        Fraction f=null;
        try {
            f= new Fraction(Integer.parseInt(splitInput[0]),Integer.parseInt(splitInput[1]));
        } catch(Exception e){
            System.out.println("Invalid fraction input");
            return;
        }
        currentPizza.eatSomePizza(f);
        
        if(currentPizza.getRemainingArea()<=0){
            System.out.println("You ate the last peice!");
            System.out.println(currentPizza.toString());
            pizzaStock.remove(randomIndex); 
        }
    }
    /**
     * addRandomPizza auto generates a random pizza and add it to the pizzaStock
     * every pizza has a sauce base and cheese but added ingredients may differ
     * in addition to their cost and calorie count. all pizzas will be of the
     * same initial area size.
     */
    private void addRandomPizza() {
        int selection;
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
        pizzaStock.add(pizza);
    }
    /**
     * displayAllPizzas displays all pizzas and their contents
     */
    private void displayAllPizzas() {
        System.out.println(pizzaStock.toString());
    }

    /**
     * sortByPrice
     * Pre-Condition: pizzaStock is not null and all pizzas have prices
     * PostCondition: all the pizzas in the list will be sorted accoding to price
     */
    private void sortByPrice() {  
        int listLength=pizzaStock.size();
        Money minPrice;
        int minIndex;
        Pizza temp;
        boolean done=false;
        while(!done){ //just for a double check that the list has indeed been sorted
            done=true;    
            for(int i=0; i<listLength; i++){
                temp=pizzaStock.get(i);
                minPrice=temp.getCost();
                minIndex=i;
                for(int j=i; j<listLength; j++){                
                    if(pizzaStock.get(j).getCost().compareTo(minPrice)<0){
                        minPrice=pizzaStock.get(i).getCost();
                        temp=pizzaStock.get(j);
                        minIndex=j;
                        done=false;
                    }
                }
                
                pizzaStock.changeItem(minIndex, pizzaStock.get(i));
                pizzaStock.changeItem(i, temp);
                
            }
        }
    }
    
    /**
     * sortBySize
     * Pre-Condition: pizzaStock is not null and all pizzas have sizes
     * PostCondition: all the pizzas in the list will be sorted accoding to remaining area
     */
    private void sortBySize() {
        int listLength=pizzaStock.size();
        double minSize;
        int minIndex;
        Pizza temp;
        boolean done=false;
        while(!done){
            done=true;    
            for(int i=0; i<listLength; i++){
                temp=pizzaStock.get(i);
                minSize=temp.getRemainingArea();
                minIndex=i;
                for(int j=i; j<listLength; j++){                
                    if(pizzaStock.get(j).getRemainingArea()<minSize){
                        minSize=pizzaStock.get(i).getRemainingArea();
                        temp=pizzaStock.get(j);
                        minIndex=j;
                        done=false;
                    }
                }
                
                pizzaStock.changeItem(minIndex, pizzaStock.get(i));
                pizzaStock.changeItem(i, temp);
                
            }
        }
    }
    
    /**
     * sortByCalories
     * Pre-Condition: pizzaStock is not null and all pizzas have calories
     * PostCondition: all the pizzas in the list will be sorted accoding to thie total calories
     */
    private void sortByCalories() {
        int listLength=pizzaStock.size();
        int minCalories;
        int minIndex;
        Pizza temp;
        boolean done=false;
        while(!done){
            done=true;    
            for(int i=0; i<listLength; i++){
                temp=pizzaStock.get(i);
                minCalories=temp.getCalories();
                minIndex=i;
                for(int j=i; j<listLength; j++){                
                    if(pizzaStock.get(j).getCalories()<minCalories){
                        minCalories=pizzaStock.get(i).getCalories();
                        temp=pizzaStock.get(j);
                        minIndex=j;
                        done=false;
                    }
                }
                
                pizzaStock.changeItem(minIndex, pizzaStock.get(i));
                pizzaStock.changeItem(i, temp);
                
            }
        }
    }
    
    /**
     * BinarySearchByCalories
     * Pre-Condition: pizzaStock is not null and in pizzaStock there exists a pizza with the desired calories
     * PostCondition: all pizzas with the desired number of calories will be listed
     */
    private void binarySearchByCalories(int cals) {
        sortByCalories();
        System.out.println("Here is recommended pizza(s) with "+cals+" calories:\n"); 
        int index=recSearch(cals,0, pizzaStock.size()-1);
        if(index>=0){
            System.out.println(pizzaStock.get(index).toString());
            int i=1;
            boolean done=false;
            while(!done){
                done=true;
                if((index-i>=0)&&pizzaStock.get(index).compareToByCalories(pizzaStock.get(index-i))==0){
                    System.out.println(pizzaStock.get(index-i).toString()); 
                    done=false;
                }  
                if((index+i<pizzaStock.size())&&pizzaStock.get(index).compareToByCalories(pizzaStock.get(index+i))==0){
                    System.out.println(pizzaStock.get(index+i).toString()); 
                    done=false;                    
                }
                i++;
            }            
        }
        else
            System.out.println("Sorry there are no Pizza's that are "+cals+" calories"); 
    }
    /**
     * reSearch is a helper function to the binarySearchByCalories method above.
     */
    private int recSearch(int cals, int lowIndex, int highIndex){ 
        if(lowIndex==highIndex){
            if(cals==pizzaStock.get(lowIndex).getCalories())
                return 0;
            return -1;
        }
        int midIndex=(int)((highIndex-lowIndex)/2) + lowIndex;
        if(cals==pizzaStock.get(midIndex).getCalories()) 
            return midIndex;
            
        if(cals<pizzaStock.get(midIndex).getCalories())
            return recSearch(cals, lowIndex, midIndex);
            
        if(cals>pizzaStock.get(midIndex).getCalories())
            return recSearch(cals, midIndex, highIndex);
        
        return -1;
    } 
    
    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = "\n\n-----------------------\nWelcome to PizzaManager\n-----------------------\nPlease Make a Selection:\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(D)isplay all pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}
