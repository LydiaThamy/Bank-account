package sg.edu.nus.iss;

public class FixedDepositAccount extends BankAccount {
    
    // members
    private float interest = (float)3;
    private int duration = 6;

    // constructors
    public FixedDepositAccount(String fullName, float balance) {
        super(fullName, balance);
    }

    public FixedDepositAccount(String fullName, float balance, float interest) {
        super(fullName, balance);
        this.interest = interest;
    }

    public FixedDepositAccount(String fullName, float balance, float interest, int duration) {
        super(fullName, balance);
        this.interest = interest;
        this.duration = duration;
    }
    
    // getters and setters
    public float getInterest() {
        return interest;
    }

        // interest setter
    public void setInterest(float interest) {
        if (this.interest == (float)3) {
            this.interest = interest;
        } else {
            throw new IllegalArgumentException("You can only change the interest once.");
        }
    }

    public int getDuration() {
        return duration;
    }

        // duration setter
    public void setDuration(int duration) {
        if (this.duration == (float)6) {
            this.duration = duration;
        } else {
            throw new IllegalArgumentException("You can only change the duration once.");
        }
    }  

    // NOP for withdrawal and deposit
    @Override
    public void deposit(float amount) {
        System.out.println("You cannot deposit any amounts into a fixed deposit account.");
    }

    @Override
    public void withdraw(float amount) {
        System.out.println("You cannot deposit any amounts into a fixed deposit account.");
    }

    // new balance method
    @Override
    public float getBalance() {
        return super.getBalance() + this.interest;
    }
}
