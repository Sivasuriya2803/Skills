package task7;

public class Account {
    private String accountNumber;
    private String accountType;
    private double accountBalance;

    public Account() {}

    public Account(String accountNumber, String accountType, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public double getAccountBalance() { return accountBalance; }
    public void setAccountBalance(double accountBalance) { this.accountBalance = accountBalance; }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposited: Rs" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrew: Rs" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void calculateInterest() {
        if (accountType.equalsIgnoreCase("Savings")) {
            double interest = (accountBalance * 4.5) / 100;
            accountBalance += interest;
            System.out.println("Interest of Rs" + interest + " added to balance.");
        } else {
            System.out.println("Interest is only applicable for Savings accounts.");
        }
    }

    public void printAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: Rs" + accountBalance);
    }
}
