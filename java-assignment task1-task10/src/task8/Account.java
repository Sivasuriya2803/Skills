package task8;
public class Account {
    protected String accountNumber;
    protected String accountType;
    protected double accountBalance;

    public Account() {}

    public Account(String accountNumber, String accountType, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public void deposit(float amount) {
        accountBalance += amount;
        System.out.println("Deposited (float): Rs" + amount);
    }

    public void withdraw(float amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrew (float): Rs" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(int amount) {
        accountBalance += amount;
        System.out.println("Deposited (int): Rs" + amount);
    }

    public void withdraw(int amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrew (int): Rs" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        accountBalance += amount;
        System.out.println("Deposited (double): Rs" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrew (double): Rs" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void calculateInterest() {
        System.out.println("No interest for this account type.");
    }

    public void printAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: Rs" + accountBalance);
    }
}