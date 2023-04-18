package ac.dia.oop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentAccount extends Account {
	
	private String accType = "Current Account";
	private double creditLimit;
	private double dailyInterestRate;
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
	
	@Override
	public void withdraw(double amount) {
		if(amount > getAccountBalance())
			System.err.println("You are spending over your balance.");
		
        double availableBalance = getAccountBalance() + getCreditLimit();
        if (availableBalance >= amount) {
        	setAccountBalance(getAccountBalance() - amount);
        } else {
            System.err.println("Exceeded credit limit.");
            getTransactions().remove(getTransactions().size()-1);
        }
    }
	
	@Override
	public double interest() {
		int count=0;
		for(Transaction transaction : getTransactions()) {
			if (cDate.format(transaction.getTransDate()).equals(cDate.format(new Date())) &&
					transaction.getTransType() == "interest")
					count++;
		}
		
		if(count != 0) {			
//			System.err.println("The interest is already applied.");
			return 0;
		} else {
			double interestAmount = (getAccountBalance() * 1 * (getDailyInterestRate()/100.00));
			return interestAmount;
		}
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
