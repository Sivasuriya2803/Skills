package task9;
import java.util.*;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Get Balance\n5. Transfer\n6. Show Account Details\n7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // flush
                    System.out.print("Customer ID: ");
                    String id = sc.nextLine();
                    System.out.print("First Name: ");
                    String fn = sc.nextLine();
                    System.out.print("Last Name: ");
                    String ln = sc.nextLine();
                    System.out.print("Email: ");
                    String em = sc.nextLine();
                    System.out.print("Phone: ");
                    String ph = sc.nextLine();
                    System.out.print("Address: ");
                    String ad = sc.nextLine();
                    System.out.print("Account Type: ");
                    String type = sc.nextLine();
                    System.out.print("Initial Balance: ");
                    float bal = sc.nextFloat();

                    Customer cust = new Customer(id, fn, ln, em, ph, ad);
                    bank.createAccount(cust, type, bal);
                    break;

                case 2:
                    System.out.print("Account Number: ");
                    long accNoD = sc.nextLong();
                    System.out.print("Amount: ");
                    float amtD = sc.nextFloat();
                    bank.deposit(accNoD, amtD);
                    break;

                case 3:
                    System.out.print("Account Number: ");
                    long accNoW = sc.nextLong();
                    System.out.print("Amount: ");
                    float amtW = sc.nextFloat();
                    bank.withdraw(accNoW, amtW);
                    break;

                case 4:
                    System.out.print("Account Number: ");
                    long accNoB = sc.nextLong();
                    float balB = bank.getBalance(accNoB);
                    if (balB != -1) System.out.println("Balance: " + balB);
                    else System.out.println("Account not found.");
                    break;

                case 5:
                    System.out.print("From Account Number: ");
                    long from = sc.nextLong();
                    System.out.print("To Account Number: ");
                    long to = sc.nextLong();
                    System.out.print("Amount: ");
                    float amtT = sc.nextFloat();
                    bank.transfer(from, to, amtT);
                    break;

                case 6:
                    System.out.print("Account Number: ");
                    long accDet = sc.nextLong();
                    bank.showAccountDetails(accDet);
                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}