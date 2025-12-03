import java.util.ArrayList;
import java.util.List;

// 1. Abstract class
abstract class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Setters
    public void setAccNumber(int aNum) { accountNumber = aNum; }
    public void setAccHolderN(String aHN) { accountHolderName = aHN; }
    public void setBalance(double b) { balance = b; }

    // Getters
    public int getAccNumber() { return accountNumber; }
    public String getAccHolderN() { return accountHolderName; }
    public double getBalance() { return balance; }

    // Deposit method
    public void deposit(double amount) {
        if(amount <= 0){
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance += amount;
    }

    // Withdraw method
    public void withdraw(double amount) {
        if(amount <= 0 || amount > balance){
            System.out.println("Invalid withdrawal amount!");
            return;
        }
        balance -= amount;
    }

    // Display account info
    void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
    }

    // Abstract method
    abstract double calculateInterest();
}

// 2. Interface
interface Transaction {
    void transter(BankAccount targetAccount, double amount);
    void printTransactionHistory();
}

// 3. SavingsAccount class
class SavingsAccount extends BankAccount implements Transaction {
    private double interestRate;
    private List<String> history = new ArrayList<>();

    public SavingsAccount(int accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void transter(BankAccount targetAccount, double amount) {
        if(getBalance() < amount){
            System.out.println("Insufficient balance for transfer!");
            return;
        }
        // Withdraw from this account
        withdraw(amount);

        // Deposit to target account
        targetAccount.deposit(amount);

        // Add to history
        history.add("Transferred " + amount + " to Account " + targetAccount.getAccNumber());
    }

    @Override
    public void printTransactionHistory() {
        System.out.println("Transaction History for Savings Account:");
        if(history.isEmpty()){
            System.out.println("No transactions yet.");
            return;
        }
        for(String record : history){
            System.out.println(record);
        }
    }
}

// 4. CheckingAccount class
class CheckingAccount extends BankAccount implements Transaction {
    private double transactionFee = 10.0;
    private List<String> history = new ArrayList<>();

    public CheckingAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.01;
    }

    @Override
    public void transter(BankAccount targetAccount, double amount) {
        if(getBalance() < amount + transactionFee){
            System.out.println("Insufficient balance for transfer");
            return;
        }

        // Withdraw amount
        withdraw(amount);

        // Deduct transaction fee
        setBalance(getBalance() - transactionFee);

        // Deposit to target account
        targetAccount.deposit(amount);

        // Save history
        history.add("Transferred " + amount + " to Account " + targetAccount.getAccNumber()
                + " (Fee: " + transactionFee + ")");
    }

    @Override
    public void printTransactionHistory() {
        System.out.println("Transaction History for Checking Account:");
        if(history.isEmpty()){
            System.out.println("No transactions yet.");
            return;
        }
        for(String record : history){
            System.out.println(record);
        }
    }
}

// 5. Main class
public class bankAccMsystem {
    public static void main(String[] args) {
        // Create accounts
        SavingsAccount sAcc = new SavingsAccount(101, "Alice", 5000, 0.05);
        CheckingAccount cAcc = new CheckingAccount(201, "Bob", 3000);

        // Deposits
        sAcc.deposit(1000);
        cAcc.deposit(500);

        // Withdrawals
        sAcc.withdraw(500);
        cAcc.withdraw(1000);

        // Transfers
        sAcc.transter(cAcc, 2000);  // Savings → Checking
        cAcc.transter(sAcc, 500);   // Checking → Savings (fee applies)

        // Display account info
        System.out.println("\n--- Account Info ---");
        sAcc.displayAccountInfo();
        cAcc.displayAccountInfo();

        // Print transaction history
        System.out.println("\n--- Transaction Histories ---");
        sAcc.printTransactionHistory();
        cAcc.printTransactionHistory();

        // Show calculated interest
        System.out.println("\n--- Interest ---");
        System.out.println("Savings Account Interest: " + sAcc.calculateInterest());
        System.out.println("Checking Account Interest: " + cAcc.calculateInterest());
    }
}
