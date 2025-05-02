package FinanceDao;
import Model.DataModel;
import Model.ExpenseData;
import java.sql.*;
import Exception.UserNot;
import Exception.ExpenseNot;

import Connect.DataConnect;

public class DataAcess {

    Connection con;

    public DataAcess() {
        con = DataConnect.getCon();
    }

    public void addUser(DataModel user) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?)");
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.executeUpdate();
            System.out.println("User added.");
        }catch(Exception e)

    {
        System.out.println(e.getMessage());
    }

}

    public void deleteUser(int userId) throws UserNot, SQLException {
        PreparedStatement deleteExpenses = con.prepareStatement("DELETE FROM expenses WHERE user_id = ?");
        deleteExpenses.setInt(1, userId);
        deleteExpenses.executeUpdate();

        PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE user_id = ?");
        ps.setInt(1, userId);
        int count = ps.executeUpdate();

        if (count == 0) {
            throw new UserNot("no user found with id " + userId);
        } else {
            System.out.println("User deleted.");
        }
    }





    public void addExpense(ExpenseData exp) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Expenses VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, exp.getExpenseId());
            ps.setInt(2, exp.getUserId());
            ps.setDouble(3, exp.getAmount());
            ps.setInt(4, exp.getCategoryId());
            ps.setDate(5, exp.getDate());
            ps.setString(6, exp.getDescription());
            ps.executeUpdate();
            System.out.println("Expense added.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteExpense(int expenseId) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Expenses WHERE expense_id = ?");
            ps.setInt(1, expenseId);
            ps.executeUpdate();
            System.out.println("Expense deleted.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateExpense(ExpenseData exp) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Expenses SET amount=?, category_id=?, date=?, description=? WHERE expense_id=?");
            ps.setDouble(1, exp.getAmount());
            ps.setInt(2, exp.getCategoryId());
            ps.setDate(3, exp.getDate());
            ps.setString(4, exp.getDescription());
            ps.setInt(5, exp.getExpenseId());
            ps.executeUpdate();
            System.out.println("Expense updated.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public ExpenseData getAllExpenses(int expenseId) throws ExpenseNot{
            ExpenseData e = null;
        try {

            String sql = "SELECT * FROM Expenses WHERE expense_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, expenseId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e = new ExpenseData();
                e.setExpenseId(rs.getInt("expense_id"));
                e.setUserId(rs.getInt("user_id"));
                e.setAmount(rs.getDouble("amount"));
                e.setCategoryId(rs.getInt("category_id"));
                e.setDate(rs.getDate("date"));
                e.setDescription(rs.getString("description"));
            }
            if(e==null){
                throw new ExpenseNot("Expense with ID " + expenseId + " not found.");

            }

        } catch (Exception q) {
            System.out.println(q.getMessage());
        }
            return e;
    }
}
