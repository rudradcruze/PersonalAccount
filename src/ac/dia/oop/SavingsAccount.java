package ac.dia.oop;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingsAccount extends Account {
	
	private int limit;
	private String accType = "Savings Account";
	private double rate;
	SimpleDateFormat cDate = new SimpleDateFormat();
	
	public SimpleDateFormat getcDate() {
		return cDate;
	}

	public void setcDate(SimpleDateFormat cDate) {
		this.cDate = cDate;
	}

	public int getLimit() {
		return limit;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public String getAccType() {
		return accType;
	}
	
	public void setAccType(String accType) {
		this.accType = accType;
	}
	
	public double getRate() {
		return rate;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public void display() {
		System.out.println("- " + getAccType());
		System.out.println("- Transition Count: " + countTransition());
		super.display();
	}
}
