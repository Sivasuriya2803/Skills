import java.util.Scanner;
public class task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] accountNumbers = {101, 102, 103, 104, 105};
        double[] balances = {5000.0, 12000.5, 7600.75, 300.0, 9800.0};

        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter your account number: ");
            int inputAccount = scanner.nextInt();
            boolean found = false;
            for (int i = 0; i < accountNumbers.length; i++) {
                if (accountNumbers[i] == inputAccount) {
                    System.out.println(" Account Exists!");
                    System.out.println(" Balance is: " + balances[i]);
                    found = true;
                    isValid = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Invalid account number. Please try again.\n");
            }
        }

        scanner.close();
    }
}
