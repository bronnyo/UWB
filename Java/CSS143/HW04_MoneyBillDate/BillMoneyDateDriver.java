/**
 HW3.java: Simple driver to test Money, Date, and Bill classes
 @author Rob Nash, borrowed from cfolsen
 */
public class BillMoneyDateDriver
{

    /**
     main driver function
     pre:  none
     post: exercises the methods in Bill, Money, and Date (not done)
     */
    public static void main(String[] args)
    {
        importedDriver();
        
        dateTester();
        moneyTester();
        billTester();
    }
    public static void importedDriver(){
        System.out.println("****************** ImportedDriverTests ******************");
        //Construct some money
        Money money1 = new Money(10); 
        Money money2 = new Money(money1);
        money1.setMoney(30,50);
        //TODO: do more functional exercises with the money class
        
        
        System.out.println("Money objects output:");
        System.out.println(money1);
        System.out.println(money2);
    
    
        //Construct some bills
        Money amount = new Money(20);
        Date dueDate = new Date(4, 30, 2007);
        dueDate.setDate(4, 30, 2014); 
        Bill bill1 = new Bill(amount, dueDate, "The phone company"); 
        bill1.setPaidDate(new Date(1, 30, 2014));
       
        Bill bill2 = new Bill(bill1);
        bill2.setDueDate(new Date(5, 30, 2007)); 
        amount.setMoney(31, 99);
        dueDate.setDay(29);
        Bill bill3 = new Bill(amount, dueDate, "The record company");
        
        System.out.println("Bill objects output:");
        System.out.println(bill1);
        System.out.println(bill2);
        System.out.println(bill3);
    }
    public static void dateTester(){
        System.out.println("****************** DateClassTester ******************");
        Date a=new Date();
        Date b=new Date();
        Date c=new Date();
        Date d=new Date();
        
        //Test for invalid Date entry
        System.err.println("Set Date Errors:");
        a.setDate(13, 40, 2000);
        b.setDate(-1, 21, 2017);
        c.setDate(12, -1, 2020);
        d.setDate(3, 16, 1991);
        System.out.println();
        
        //Printing Results
        System.out.println("Date a: "+a.toString());
        System.out.println("Date b: "+b.toString());
        System.out.println("Date c: "+c.toString());
        System.out.println("Date d: "+d.toString());
        System.out.println();
        
        //Resetting Dates to test specific changes
        a.setDate(12, 12, 2015);
        b.setDate(1, 21, 2017);
        c.setDate(12, 1, 2020);
        d.setDate(3, 16, 2019);
        System.out.println();
        //Printing new Date values:
        System.out.println("Date a: "+a.toString());
        System.out.println("Date b: "+b.toString());
        System.out.println("Date c: "+c.toString());
        System.out.println("Date d: "+d.toString());
        System.out.println();
        
        //Testing mutators
        System.err.println("Specific mutator Errors:");        
        a.setMonth(-42);
        b.setDay(-42);
        c.setYear(42);
        d.setDate(a); 
        System.out.println();
        
        //Printing Results
        System.out.println("Date a: "+a.toString());
        System.out.println("Date b: "+b.toString());
        System.out.println("Date c: "+c.toString());
        System.out.println("Date d: "+d.toString());
        System.out.println();
        
        //Testing for equivelancy
        System.out.println("Date a = b: "+a.equals(b));
        System.out.println("Date b = c: "+b.equals(c));
        System.out.println("Date c = d: "+c.equals(d));
        System.out.println("Date d = a: "+d.equals(a));
        System.out.println();
        
        //Testing Bad object entry in equals
        Money m=new Money(1,50);
        System.out.println("Date d = a: "+d.equals(m));
        System.out.println();
    }
    public static void moneyTester(){
        System.out.println("****************** MoneyClassTester ******************");
        //Testing Constructors
        Money a=new Money();
        Money b=new Money(-1, 3);
        Money c=new Money(10, -10);
        Money d=new Money(10, 42);
        Money e=new Money(10.82);
        Money f=new Money(-10.82);
        Money g=new Money(a);
        System.out.println();
        
        //Printing Results
        System.out.println("Money a: "+a.toString());
        System.out.println("Money b: "+b.toString());
        System.out.println("Money c: "+c.toString());
        System.out.println("Money d: "+d.toString());
        System.out.println("Money e: "+e.toString());
        System.out.println("Money f: "+f.toString());
        System.out.println("Money g: "+g.toString());
        System.out.println();
        
        //Testing add methods
        a.add(10.84);
        b.add(5,-10);
        c.add(10.84); 
        d.add(9, 10);
        e.add(0, -150);
        f.add(-3, -3);
        g.add(-1, 4);
        d.add(10,74);
        b.add(0, 27);
        System.out.println();
        
        //Printing Results
        System.out.println("Money a: "+a.toString());
        System.out.println("Money b: "+b.toString());
        System.out.println("Money c: "+c.toString());
        System.out.println("Money d: "+d.toString());
        System.out.println("Money e: "+e.toString());
        System.out.println("Money f: "+f.toString());
        System.out.println("Money g: "+g.toString());
        System.out.println();
        
        //Testing set methods
        a.setDollars(19);
        b.setCents(30);
        e.setDollars(-1);
        e.setDollars(2);
        e.setCents(235);
        f.setDollars(4);
        f.setCents(130);
        g.setMoney(3,-5);
        System.out.println();
        
        //Printing results
        System.out.println("Money a: "+a.toString());
        System.out.println("Money b: "+b.toString());
        System.out.println("Money c: "+c.toString());
        System.out.println("Money d: "+d.toString());
        System.out.println("Money e: "+e.toString());
        System.out.println("Money f: "+f.toString());
        System.out.println("Money g: "+g.toString());
        System.out.println();
        
        //Comparing equivelance
        System.out.println("Money a = b: "+a.equals(b));
        System.out.println("Money b = c: "+b.equals(c));
        System.out.println("Money d = e: "+d.equals(e));
        System.out.println("Money e = f: "+a.equals(f));        
        System.out.println("Money f = g: "+b.equals(g));
        System.out.println();
        System.out.println("Money f = b: "+f.equals(b));
        System.out.println("Money c = a: "+c.equals(a));
        System.out.println();
        
        //Testing Bad object entry in equals
        Date m=new Date(2, 1, 2017);
        System.out.println("Money a = Date m: "+a.equals(m));
        System.out.println();                
    }
    public static void billTester(){
        System.out.println("****************** BillClassTester ******************");
        Money amount1=new Money(50, 75);
        Date dueDate1=new Date(11, 30, 2020);
        Bill bill1=new Bill(amount1, dueDate1, "Frank");
        Bill bill2=new Bill(bill1);
        
        bill1.setPaidDate(new Date(1, 3, 2021));
        bill1.setPaidDate(new Date(1, 3, 2019));
        
        System.out.println(bill1.toString());
        System.out.println(bill2.toString());
        System.out.println("Bill 1 = Bill 2 : "+bill1.equals(bill2));
        
        bill2.setPaidDate(new Date(1,3,2019));
        
        System.out.println(bill1.toString());
        System.out.println(bill2.toString());
        System.out.println("Bill 1 = Bill 2 : "+bill1.equals(bill2));
        
        
        
    }
    
}
