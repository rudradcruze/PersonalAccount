package ac.dia.oop;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class SavingsAccount extends Account {
	
	private int limit;
	private String accType = "Savings Account";
	private double rate;
	SimpleDateFormat cDate = new SimpleDateFormat("dd-MM-yyyy");
	
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
	public void withdraw(double amount) {
		int n = 0;
		for (Transaction transaction : getTransactions())
			if(cDate.format(transaction.getTransDate()).equals(cDate.format(new Date())) && transaction.getTransType() == "withdraw")
				n++;
		
		if(n > limit) {			
			getTransactions().remove(getTransactions().size()-1);
			System.err.println("Transition cannot procced because out of limit.");
		} else {
			setAccountBalance(getAccountBalance() - amount);
//			super.withdraw(amount);
		}
	}
		
	@Override
	public double interest() {
		int count=0;
		Date lastTransitionDate = new Date();
		DateTimeFormatter dTformatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		for(Transaction transaction : getTransactions()) {
			if (transaction.getTransType() == "interest") {
					count++;
					lastTransitionDate = transaction.getTransDate();
			}
		}
		
//		String strDate = "10/03/2023";
		String strDate = formatter.format(lastTransitionDate);
		String nowDate = formatter.format(new Date());
		
		LocalDate dateLast = LocalDate.parse(strDate, dTformatter);
		LocalDate dateNow = LocalDate.parse(nowDate, dTformatter);
		
		long dayBetween = ChronoUnit.DAYS.between(dateLast, dateNow);
		
		if(dayBetween >= 28 || count == 0) {
			double interestAmount = (getAccountBalance() * 1 * (rate/100.00));
			return interestAmount;
		} else
			return 0;
	}

	@Override
	public void display() {
		System.out.println("- " + getAccType());
		System.out.println("- Transition Count: " + countTransition());
		System.out.println("- Interest Rate: " + getRate());
		super.display();
	}
}
