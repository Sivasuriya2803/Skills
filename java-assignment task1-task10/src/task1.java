import java.util.Scanner;
public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer's credit score: ");
        int creditScore = scanner.nextInt();
        System.out.print("Enter customer's annual income: ");
        double annualIncome = scanner.nextDouble();
        if(creditScore >500 && annualIncome>=50000) {
            System.out.println("Customer is eligible for loan");
        }else {
            System.out.println("Customer not eligible for loan");
        }
        if(creditScore<=500) {
            System.out.println("Credit score must be above 500");
        }
        if(annualIncome < 50000) {
            System.out.println("Annual Income must be at least 50000");
        }
    }
}

