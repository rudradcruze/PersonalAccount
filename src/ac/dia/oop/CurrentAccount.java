package ac.dia.oop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentAccount extends Account {
	
	private String accType = "Current Account";
	private double creditLimit;
	private double dailyInterestRate;
	private double dailyInterest;
	SimpleDateFormat cDate = new SimpleDateFormat();
	
	public CurrentAccount() {
		super();
	}

	public String getAccType() {
		return accType;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getDailyInterestRate() {
		return dailyInterestRate;
	}

	public void setDailyInterestRate(double dailyInterestRate) {
		this.dailyInterestRate = dailyInterestRate;
	}
	
	public void calculateInterest() {
		dailyInterest = getAccountBalance() * dailyInterestRate;
        setAccountBalance(getAccountBalance() + dailyInterest);
        Transaction transaction = new Transaction();
        transaction.setTransAccount(this);
        transaction.setTransType("interest");
        transaction.setTransAmount(dailyInterest);
        transaction.setTransDate(new Date());
        getTransactions().add(transaction);
	}
	
    @Override
    public void display() {
        System.out.println("- " + getAccType());
        System.out.println("- Credit Limit: " + getCreditLimit());
        System.out.println("- Daily Interest Rate: " + getDailyInterestRate());
        System.out.println("- Transition Count: " + countTransition());
        super.display();
    }
}
