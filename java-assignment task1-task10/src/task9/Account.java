package task9;

public class Account {
    long accountNumber;
    String accountType;
    float balance;
    Customer customer;

    public Account() {}

    public Account(long accountNumber, String accountType, float balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }

    public void printAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
        customer.printCustomer();
    }
}
