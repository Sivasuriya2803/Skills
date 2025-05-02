import java.util.Scanner;
import java.util.ArrayList;
public class task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> transactions = new ArrayList<>();
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\n--- Transaction Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double deposit = scanner.nextDouble();
                    transactions.add("Deposited: " + deposit);
                    System.out.println(" Deposit successful.");
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = scanner.nextDouble();
                    transactions.add("Withdrew: " + withdraw);
                    System.out.println("Withdrawal successful.");
                    break;
                case 3:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }


        System.out.println("\n Transaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }


    }
}
