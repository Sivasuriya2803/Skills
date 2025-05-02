package Client;
import Connect.DataConnect;
import Service.FinanSer;
import java.sql.Connection;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner a =new Scanner(System.in);
          Connection con= DataConnect.getCon();
        FinanSer ser=new FinanSer();
            while (true){
                System.out.println("Welcome to the Finance APP!!");
                System.out.println("1.New User");
                System.out.println("2.Add Expense to the Account");
                System.out.println("3.Update the Expense");
                System.out.println("4.View All Expenses");
                System.out.println("5.Delete the Expense");
                System.out.println("6.Delete the Account" + "\n");
                System.out.println("Enter the Number:  ");
                int ch=a.nextInt();
                try {
                    switch (ch) {
                        case 1:
                            ser.addUser();
                            break;
                        case 2:
                            ser.addExpense();
                            break;
                        case 3:
                            ser.updateExpense();
                            break;
                        case 4:
                            ser.ViewExpense();
                            break;
                        case 5:
                            ser.deleteExpense();
                            break;
                        case 6:
                            ser.deleteUser();

                            break;
                        case 7:
                            System.exit(0);
                        default:
                            System.out.println("Enter the Correct Option..");
                    }
                } catch (Exception e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }


            }

    }
}