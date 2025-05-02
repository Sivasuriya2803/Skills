package task9;
import java.util.*;

public class Bank {
    HashMap<Long, Account> accounts = new HashMap<>();
    long nextAccountNumber = 1001;

    public void createAccount(Customer customer, String type, float balance) {
        Account account = new Account(nextAccountNumber, type, balance, customer);
        accounts.put(nextAccountNumber, account);
        System.out.println("Account Created. Account Number: " + nextAccountNumber);
        nextAccountNumber++;
    }

    public float getBalance(long accNo) {
        if (accounts.containsKey(accNo)) {
            return accounts.get(accNo).balance;
        }
        return -1;
    }

    public void deposit(long accNo, float amount) {
        if (accounts.containsKey(accNo)) {
            accounts.get(accNo).balance += amount;
            System.out.println("Deposited. New Balance: " + accounts.get(accNo).balance);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(long accNo, float amount) {
        if (accounts.containsKey(accNo)) {
            Account acc = accounts.get(accNo);
            if (acc.balance >= amount) {
                acc.balance -= amount;
                System.out.println("Withdrawn. New Balance: " + acc.balance);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(long fromAcc, long toAcc, float amount) {
        if (accounts.containsKey(fromAcc) && accounts.containsKey(toAcc)) {
            Account from = accounts.get(fromAcc);
            Account to = accounts.get(toAcc);
            if (from.balance >= amount) {
                from.balance -= amount;
                to.balance += amount;
                System.out.println("Transfer Successful.");
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void showAccountDetails(long accNo) {
        if (accounts.containsKey(accNo)) {
            accounts.get(accNo).printAccount();
        } else {
            System.out.println("Account not found.");
        }
    }
}
