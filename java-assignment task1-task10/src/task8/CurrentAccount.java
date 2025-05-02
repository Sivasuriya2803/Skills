package task8;

public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 5000.0;

    public CurrentAccount(String accountNumber, double accountBalance) {
        super(accountNumber, "Current", accountBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= accountBalance + OVERDRAFT_LIMIT) {
            accountBalance -= amount;
            System.out.println("Withdrew (CurrentAccount): Rs" + amount);
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    public void calculateInterest() {
        System.out.println("No interest for Current Account.");
    }
}
