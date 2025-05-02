package Test;

import static org.junit.jupiter.api.Assertions.*;

import FinanceDao.DataAcess;
import Model.DataModel;
import Model.ExpenseData;
import org.junit.jupiter.api.Test;
import Exception.UserNot;

import java.sql.Date;

public class FinanceTest {

    DataAcess dao = new DataAcess();

    @Test
    void testAddUser() {
        try {
            DataModel user = new DataModel(1, "testUser", "test@example.com", "pass123");
            assertDoesNotThrow(() -> dao.addUser(user));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testAddExpense() {

        try {
            ExpenseData expense = new ExpenseData(1, 1, 500.0, 101, Date.valueOf("2025-04-08"), "Food");
            assertDoesNotThrow(() -> dao.addExpense(expense));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testSearchExpenseById() {

        try {
            ExpenseData expense = dao.getAllExpenses(104);
            assertNotNull(expense, "Expense should be found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testDeleteInvalidUser() {
        try {
            int nonExistentUserId =101;
            dao.deleteUser(nonExistentUserId);
            fail("Expected UserNot exception but none was thrown.");
        } catch (UserNot e) {
            assertTrue(e.getMessage().contains("no user"));
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

}
