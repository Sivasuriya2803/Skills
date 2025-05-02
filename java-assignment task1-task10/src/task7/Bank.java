package task7;
public class Bank {
    public static void main(String[] args)
    {
        Custmer customer = new Custmer(1001, "Ananya", "Ravi", "ananya@example.com", "9876543210", "Chennai");
        customer.printCustomerInfo();

        System.out.println("\n--- Account Details ---");
        Account account = new Account("AC123456", "Savings", 10000.0);
        account.printAccountInfo();

        account.deposit(5000.0);
        account.withdraw(2000.0);
        account.calculateInterest();

        System.out.println("\n--- Updated Account Details ---");
        account.printAccountInfo();
    }
}


