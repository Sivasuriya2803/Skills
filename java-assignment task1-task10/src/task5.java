import java.util.Scanner;
public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Create your bank account password: ");
        String password = scanner.nextLine();

        boolean isValid = true;

        if (password.length() < 8) {
            System.out.println(" Password must be at least 8 characters long.");
            isValid = false;
        }

        boolean hasUpperCase = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        if (!hasUpperCase) {
            System.out.println(" Password must contain at least one uppercase letter.");
            isValid = false;
        }

        if (!hasDigit) {
            System.out.println("Password must contain at least one digit.");
            isValid = false;
        }

        if (isValid) {
            System.out.println("Password created successfully!");
        }

        scanner.close();
    }
}
