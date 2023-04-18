package ac.dia.oop;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class FixedDeposit extends Account {
	
	private String accType = "Fixed Account";
	private String status = "panding";
	private double interestRate;
	private byte year;
	
	public String getAccType() {
		return accType;
	}

	public void setStatus(String status) {
		this.status = status;
		if (status == "close")
			System.out.println(getAccountNo() + " is successfully " + getStatus());
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public byte getYear() {
		return year;
	}

	public void setYear(byte year) {
		this.year = year;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public void setAccountBalance(double accountBalance) {
		System.err.println("Cannot set the account balance directly.");
	}
	
	private boolean checkDateAligibility() {
		Date lastTransitionDate = new Date();
		DateTimeFormatter dTformatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		for(Transaction transaction : getTransactions()) {
			if (transaction.getTransType() == "deposit") {
				lastTransitionDate = transaction.getTransDate();
//				break;
			}
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(lastTransitionDate);
		c.add(Calendar.YEAR, getYear());
		lastTransitionDate = c.getTime();
		
//		System.out.println(lastTransitionDate);
		
//		String nowDate = "14/04/2026";
		String strDate = formatter.format(lastTransitionDate);
		String nowDate = formatter.format(new Date());
		
		LocalDate dateLast = LocalDate.parse(strDate, dTformatter);
		LocalDate dateNow = LocalDate.parse(nowDate, dTformatter);
		
		long dayBetween = ChronoUnit.DAYS.between(dateLast, dateNow);
		long printDifference = dayBetween;
		
		byte year = (byte) (printDifference / 365);
		printDifference = printDifference % 365;
		byte month = (byte) (printDifference / 30);
		byte day = (byte) (printDifference % 30);
		
		if(dayBetween >= 0 && getStatus() == "close")
			return true;
		else {
			System.out.println(year + " year, " + month + " month, " + day + " days left");
			return false;
		}
	}
	
	@Override
	public void withdraw(double amount) {
		boolean interest = false;
		boolean checkDate = checkDateAligibility();
		
		for(Transaction transaction : getTransactions()) {
			if (transaction.getTransType() == "interest")
				interest = true;
		}
		
		if(interest == true && checkDate == true) {
			super.withdraw(getAccountBalance());
		} else {
			getTransactions().remove(getTransactions().size()-1);
			System.err.println("The withdraw cannot procced.");
		}
    }
	
	@Override
	public double interest() { 
		boolean interest = false;
		boolean dateCheck = checkDateAligibility();
		for(Transaction transaction : getTransactions()) {
			if (transaction.getTransType() == "interest")
				interest = true;
		}
		
		if(getStatus() != "close" || interest == true || dateCheck == false) {
			return 0;
		}
		else {
			double interestAmount = (double)(getAccountBalance() * getInterestRate() * getYear()) / 100.00;
			return interestAmount;
		}
	}
	
	@Override
 	public void display() {
		System.out.println("- " + getAccType());
        System.out.println("- Validity: " + getYear() + " years");
        System.out.println("- Interest Rate: " + getInterestRate());
        System.out.println("- Transition Count: " + countTransition());
        System.out.println("- Account Status: " + getStatus());
        super.display();
	}

	@Override
	public void deposit(double amount) {
		if (countTransition() >= 1 || getStatus() == "close")
			System.err.println("Cannot perform this operation.");
		else {
			setStatus("active");
			super.deposit(amount);
		}
	}
}
