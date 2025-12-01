


//package Inheritance.Final Project;
// echo "# payment_processing_system-project-" >> README.md
// git init
// git add README.md
// git commit -m "first commit"
// git branch -M main
// git remote add origin https://github.com/Samuel-5485/payment_processing_system-project-.git
// git push -u origin main

//Abstract class: payment
abstract class Payment{
    double amount;
    
      Payment(double amount){
        this.amount = amount;

    }
    abstract void processPayment();//abstract method

    //method for interface
}
//2.Interface
interface ReceiptPrintable{
        void printReceipt();
    }
class CashPayment extends Payment implements ReceiptPrintable{
     
     CashPayment(double amount){
        super(amount);
     }

     @Override
    void processPayment(){
        System.out.println("Processing cash payment of " + amount);
    }
    //implement printReceipt
    @Override
    public void printReceipt(){
        System.out.println("Receipt: Cash payment completed.");
    }
}

class CardPayment extends Payment implements ReceiptPrintable{
    String cardNumber;
    //costructor
    CardPayment(double amount, String cardNumber){
        super(amount);
        this.cardNumber = cardNumber;
    
    }
    @Override
    void processPayment(){
        System.out.println("Processing Card payment " + amount  + " Using card number of " + cardNumber);
    }
    @Override
    public void printReceipt(){
        System.out.println("Receipt: Card payment completed");
    }
}

class BankTransfer extends Payment implements ReceiptPrintable{
    String bankName;
    //
    BankTransfer(double amount, String b){
        super(amount);
        bankName = b;

    }
    @Override
    void processPayment(){
        System.out.println("Amount to transfer " + amount  + " Name of Bank " + bankName) ;
    }
    @Override
    public void printReceipt(){
        System.out.println("Receipt: Just completed!");
    }
}
public class heroProject {
    public static void main(String[] args) {
        Payment[] payments = {
            new CashPayment(134),
            new CardPayment(237.93, "cn/421/18"),
            new BankTransfer(123, "Commerical Bank")
        };
        for(Payment p : payments){
            p.processPayment();
          ((ReceiptPrintable)p).printReceipt();
          System.out.println("------------------");
        }
    }
}
