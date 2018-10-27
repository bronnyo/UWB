
/**
 * Write a description of class HW08_TestDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HW08_TestDriver
{
    public static void main(String[] args){
        System.out.println("****************** BillClassTester ******************");
        Money amount1=new Money(50, 75);
        System.out.println("ToString test: "+amount1.toString());
        System.out.println();
        
        Date dueDate1=new Date(11, 30, 2020);
        Bill bill1=new Bill(amount1, dueDate1, "Frank");
        System.out.println("ToString test: "+bill1.toString());
        System.out.println();
        
        Bill bill2=new Bill(bill1);
        
        bill1.setPaidDate(new Date(1, 3, 2021));
        bill1.setPaidDate(new Date(1, 3, 2019));
        
        System.out.println(bill1.toString());
        System.out.println(bill2.toString());
        System.out.println("Bill 1 = Bill 2 : "+bill1.equals(bill2));
        
        bill2.setPaidDate(new Date(1,3,2019));
        
        System.out.println("Bill 1: "+bill1.toString());
        System.out.println("Bill 2: "+bill2.toString());
        System.out.println("Bill 1 = Bill 2 : "+bill1.isEqual(bill2)); 
        
        System.out.println();
        System.out.println("***** Expense Account Test Methods *****");
        System.out.println();
        
        Bill ralf=new Bill(new Money(10,35), new Date(10, 4, 2020), "Ralf");
        Bill mary=new Bill(new Money(100,15), new Date(12, 03, 2019), "Mary");
        Bill bobby=new Bill(new Money(32,78), new Date(8, 12, 2020), "Bobby");
        bobby.setPaidDate(new Date(1, 9, 2019));
        
        Bill sally=new Bill(new Money(1,25), new Date(4, 21, 2022), "Sally");
        sally.setPaidDate(new Date(12, 25, 2021));
        
        Bill bill6=new Bill(new Money(200,15), new Date(12, 03, 2021), "Jeff");
        Bill bill7=new Bill(new Money(123.56), new Date(03, 21, 2014), "Nick");
        
        
        ExpenseAccount records=new ExpenseAccount();
        try{
            records.addNew(bill1); 
            records.addNew(bill2);
            records.addNew(ralf); 
            
            records.addNew(mary);
            records.addNew(bobby);
            records.addNew(sally);
            records.addNew(bill6);
            records.addNew(bill7);
            
        }
        catch(Exception e){
            System.err.println("Error in main");
        }
        System.out.println();
        System.out.printf(records.toString());
        System.out.println();
        
        System.out.printf("Last payment recieved: %n"+records.viewLastBillPaid()+"%n");
        System.out.println();
        System.out.printf("Largest open debt account: %n"+records.viewLargestAccountDebt()+"%n");
        System.out.println();
        System.out.printf("Next Payment Due: %n"+records.viewNextPaymentDue()+"%n"); 
        System.out.println();
        System.out.println();
        
        System.out.println("Index of Last Payment:       "+records.indexOf(records.getLastBillPaid()));  
        System.out.println("Index of largest open debt:  "+records.indexOf(records.getLargestAccountDebt())); 
        System.out.println("Index of Mary's Bill:       "+records.indexOf(mary));
        System.out.println();
        System.out.println("Length of List: "+records.size());
        
        System.out.println();
        System.out.printf("Bill at Index 3: %n"+records.get(3)+"%n");
        
        System.out.println();
        System.out.printf("Removing the following bill from the list: %n"+records.remove(2));
        System.out.println();
        System.out.println();
        System.out.println("New Length of List: "+records.size());
        System.out.printf(records.toString());
        System.out.println();
        System.out.println(records.viewFirstBillPaid());
        System.out.println();
        System.out.printf("Removing the following bill from the list: %n"+records.remove(1));
        System.out.println();
        
        System.out.println();
        System.out.printf("New largest open debt account: %n"+records.viewLargestAccountDebt()+"%n");
        System.out.println();
    }
}
