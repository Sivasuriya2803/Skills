import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance;
        System.out.print("Enter your current account balance: ");
        balance = scanner.nextDouble();
        while(true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.print("Choose an option : ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("current balance is: " + balance);
            } else if (choice == 2) {
                System.out.print("Enter amount to withdraw (multiples of 100 or 500): ");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount > balance) {
                    System.out.println(" Insufficient balance.");
                } else if (withdrawAmount % 100 != 0 && withdrawAmount % 500 != 0) {
                    System.out.println("Withdrawal amount must be in multiples of 100 or 500.");
                } else {
                    balance -= withdrawAmount;
                    System.out.println("Withdrawal successful. Updated balance: " + balance);
                }

            } else if (choice == 3) {
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();

                if (depositAmount <= 0) {
                    System.out.println(" Deposit amount must be greater than zero.");
                } else {
                    balance += depositAmount;
                    System.out.println("Deposit successful. Updated balance: " + balance);
                }

            } else {
                System.out.println("Invalid option !! Try Again.");
            }}
    }
}
