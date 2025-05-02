package task8;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = null;

        System.out.println("Choose Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Account Number: ");
                String saNumber = sc.next();
                System.out.print("Enter Initial Balance: ");
                double saBalance = sc.nextDouble();
                System.out.print("Enter Interest Rate: ");
                double rate = sc.nextDouble();
                account = new SavingsAccount(saNumber, saBalance, rate);
                break;
            case 2:
                System.out.print("Enter Account Number: ");
                String caNumber = sc.next();
                System.out.print("Enter Initial Balance: ");
                double caBalance = sc.nextDouble();
                account = new CurrentAccount(caNumber, caBalance);
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }

        boolean running = true;
        while (running) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest");
            System.out.println("4. Display Account Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dAmount = sc.nextDouble();
                    account.deposit(dAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wAmount = sc.nextDouble();
                    account.withdraw(wAmount);
                    break;
                case 3:
                    account.calculateInterest();
                    break;
                case 4:
                    account.printAccountInfo();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
