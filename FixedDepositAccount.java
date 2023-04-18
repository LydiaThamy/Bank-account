package sg.edu.nus.iss;

public class FixedDepositAccount extends BankAccount {
    
    public FixedDepositAccount(String fullName, String accountNumber, float balance) {
        super(fullName, accountNumber, balance);
        
    }

    private float interest = 3;
    private int durationInMonths = 6;

    // getters and setters
    public float getInterest() {
        return interest;
    }
    public void setInterest(float interest) {
        this.interest = interest;
    }
    public int getDurationInMonths() {
        return durationInMonths;
    }
    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    // Method overrides
    @Override
    public void deposit(float amount) {
        System.out.println("You cannot deposit any amounts into a fixed deposit account.");
    }
    @Override
    public void withdraw(float amount) {
        System.out.println("You cannot deposit any amounts into a fixed deposit account.");
    }

    
    
    
}
