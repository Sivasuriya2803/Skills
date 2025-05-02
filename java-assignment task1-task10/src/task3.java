import java.util.Scanner;
public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of customers: ");
        int noOfCustomers = scanner.nextInt();
        for (int i = 1; i <= noOfCustomers; i++) {
            System.out.println("\n--- Customer " + i + " ---");
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();
            System.out.print("Enter annual interest rate in %: ");
            double annualInterestRate = scanner.nextDouble();
            System.out.print("Enter number of years: ");
            int years = scanner.nextInt();
            double futureBalance = initialBalance * Math.pow((1 + annualInterestRate / 100), years);

            System.out.printf("Future balance after %d years: ₹%.2f\n", years, futureBalance);
        }
        scanner.close();
    }
}
