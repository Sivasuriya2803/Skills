package Service;
import java.sql.Date;
import java.util.Scanner;
import FinanceDao.DataAcess;
import Model.DataModel;
import Model.ExpenseData;
public class FinanSer {
    Scanner sc;
    DataAcess dao;

    public FinanSer() {
        sc = new Scanner(System.in);
        dao = new DataAcess();
    }

    public void addUser() {
        try {
            DataModel u = new DataModel();
            System.out.print("User ID: ");
            u.setUserId(sc.nextInt());
            sc.nextLine();
            System.out.print("Username: ");
            u.setUsername(sc.nextLine());
            System.out.print("Password: ");
            u.setPassword(sc.nextLine());
            System.out.print("Email: ");
            u.setEmail(sc.nextLine());

            dao.addUser(u);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteUser() {
        try {
            System.out.print("Enter user ID to delete: ");
            int id = sc.nextInt();
            dao.deleteUser(id);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addExpense(){ try{
        ExpenseData e = new ExpenseData();
        System.out.print("Expense ID: ");
        e.setExpenseId(sc.nextInt());
        System.out.print("User ID: ");
        e.setUserId(sc.nextInt());
        System.out.print("Amount: ");
        e.setAmount(sc.nextDouble());
        System.out.print("Category ID: ");
        e.setCategoryId(sc.nextInt());
        sc.nextLine();
        System.out.print("Date (yyyy-mm-dd): ");
        e.setDate(Date.valueOf(sc.nextLine()));
        System.out.print("Description: ");
        e.setDescription(sc.nextLine());

        dao.addExpense(e);
    }catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }

    public void deleteExpense() {
        try {
            System.out.print("Enter expense ID to delete: ");
            int id = sc.nextInt();
            dao.deleteExpense(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateExpense() {
        try {
            ExpenseData e = new ExpenseData();
            System.out.print("Expense ID to update: ");
            e.setExpenseId(sc.nextInt());
            System.out.print("New Amount: ");
            e.setAmount(sc.nextDouble());
            System.out.print("New Category ID: ");
            e.setCategoryId(sc.nextInt());
            sc.nextLine();
            System.out.print("New Date (yyyy-mm-dd): ");
            e.setDate(Date.valueOf(sc.nextLine()));
            System.out.print("New Description: ");
            e.setDescription(sc.nextLine());

            dao.updateExpense(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ViewExpense() {
        try {
            System.out.print("Enter Expense ID: ");
            int id = sc.nextInt();
            ExpenseData e = dao.getAllExpenses(id);

            if (e != null) {
                System.out.println("Expense ID: " + e.getExpenseId());
                System.out.println("User ID: " + e.getUserId());
                System.out.println("Amount: " + e.getAmount());
                System.out.println("Category ID: " + e.getCategoryId());
                System.out.println("Date: " + e.getDate());
                System.out.println("Description: " + e.getDescription());
            } else {
                System.out.println("No expense found with ID " + id);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}