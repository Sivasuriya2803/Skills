package Client;

import dao.InsuranceServiceImpl;
import Model.Policy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InsuranceServiceImpl service = new InsuranceServiceImpl();
        boolean exit = false;

        while (!exit) {
            System.out.println("Insurance Management System");
            System.out.println("1. Create Policy");
            System.out.println("2. Get Policy by ID");
            System.out.println("3. View All Policies");
            System.out.println("4. Update Policy");
            System.out.println("5. Delete Policy");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Policy ID: ");
                    int policyId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Policy Name: ");
                    String policyName = scanner.nextLine();
                    System.out.print("Enter Policy Details: ");
                    String policyDetails = scanner.nextLine();

                    Policy policy = new Policy(policyId, policyName, policyDetails);
                    if (service.createPolicy(policy)) {
                        System.out.println("Policy created successfully.");
                    } else {
                        System.out.println("Failed to create policy.");
                    }
                    break;
                case 2:
                    System.out.print("Enter Policy ID to retrieve: ");
                    int idToGet = scanner.nextInt();
                    Policy retrievedPolicy = service.getPolicy(idToGet);
                    if (retrievedPolicy != null) {
                        System.out.println("Retrieved Policy: " + retrievedPolicy);
                    } else {
                        System.out.println("Policy not found.");
                    }
                    break;
                case 3:
                    List<Policy> policies = (List<Policy>) service.getAllPolicies();
                    if (policies.isEmpty()) {
                        System.out.println("No policies found.");
                    } else {
                        System.out.println("All Policies:");
                        for (Policy p : policies) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter Policy ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Policy Name: ");
                    String newPolicyName = scanner.nextLine();
                    System.out.print("Enter new Policy Details: ");
                    String newPolicyDetails = scanner.nextLine();

                    Policy updatedPolicy = new Policy(idToUpdate, newPolicyName, newPolicyDetails);
                    if (service.updatePolicy(updatedPolicy)) {
                        System.out.println("Policy updated successfully.");
                    } else {
                        System.out.println("Failed to update policy.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Policy ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    if (service.deletePolicy(idToDelete)) {
                        System.out.println("Policy deleted successfully.");
                    } else {
                        System.out.println("Failed to delete policy.");
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
