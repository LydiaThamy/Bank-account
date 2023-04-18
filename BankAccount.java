package sg.edu.nus.iss;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String fullName;
    private String accountNumber;
    private float balance;
    private boolean isClosed = false;
    private Date accountStartDate;
    private Date accountEndDate;
    private List<String> transactions; // this collection is not instantiated, so it does not yet exist
    // we don't need it now, since no bank account exists
    // we will instantiate it once an account is created
    
    // generate constrcutors
    public BankAccount(String fullName, String accountNumber) {
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.balance = 0.0f;

        // set the date once the account is opened (instatiated)
        this.accountStartDate = new Date();
        transactions = new ArrayList<>();
    }

    public BankAccount(String fullName, String accountNumber, float balance) {
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    // generate getters and setters
    public String getFullName() {
        return fullName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public boolean isClosed() {
        return isClosed;
    }
    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;

        // set the date once the account is closed
        this.accountEndDate = new Date(); 
    }
    public Date getAccountStartDate() {
        return accountStartDate;
    }
    public void setAccountStartDate(Date accountStartDate) {
        this.accountStartDate = accountStartDate;
    }
    public Date getAccountEndDate() {
        return accountEndDate;
    }
    public void setAccountEndDate(Date accountEndDate) {
        this.accountEndDate = accountEndDate;
    }
    public List<String> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
    
    // deposit method
    public void deposit(float amount) {
        if (isClosed) {
            throw new IllegalArgumentException("Account closed/inactive. You cannot make a deposit to a closed/inactive account.");
            // illegal arguments are a class, you cannot use it withbout instantiating it
        } else if (amount < 0) {
            throw new IllegalArgumentException("You cannot make a negative amount deposit.");
        } else {
            this.balance += amount;

            Date dt = new Date(); // a way to get today's date
            transactions.add("Deposited $" + amount + " to account " + accountNumber + " on " + dt.toString());
        }
    }

    // withdrawal method
    public void withdraw(float amount) {
        if (isClosed) {
            throw new IllegalArgumentException("Account is closed/inactive. You cannot make a withdrawal from a closed/inactive account.");
        } else if (amount < 0) {
            throw new IllegalArgumentException("You cannot make a negative amount withdrawal.");
        } else if (amount > this.balance) {
            throw new IllegalArgumentException("Withdrawal amount is more than account balance.");
        } else {
            this.balance -= amount;

            Date dt = new Date();
            transactions.add("Withdrew $" + amount + " from account " + accountNumber + " on " + dt.toString());
        }
    }

    @Override
    public String toString() {
        /* return "BankAccount [fullName=" + fullName + ", accountNumber=" + accountNumber + ", balance=" + balance
                + ", isClosed=" + isClosed + ", accountStartDate=" + accountStartDate + ", accountEndDate="
                + accountEndDate + ", transactions=" + transactions + "]"; */

        return "BankAccount [fullName = " + fullName + ", accountNumber = " + accountNumber + ", balance = " + balance
                + ", isClosed = " + isClosed + ", accountStartDate = " + accountStartDate + ", accountEndDate="
                + accountEndDate + "]";
    
    }
}
