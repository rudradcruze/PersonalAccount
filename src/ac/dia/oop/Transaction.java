package ac.dia.oop;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Transaction {
	
	private int transId;
	private String transType;
	private Date transDate;
	private double transAmount;
	private Account transAccount;
	SimpleDateFormat cDate = new SimpleDateFormat();
	
	public int getTransId() {
		return transId;
	}
	
	public void setTransId(int transId) {
		this.transId = transId;
	}
	
	public String getTransType() {
		return transType;
	}
	
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	public Date getTransDate() {
		return transDate;
	}
	
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	
	public double getTransAmount() {
		return transAmount;
	}
	
	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}
	
	public Account getTransAccount() {
		return transAccount;
	}
	
	public void setTransAccount(Account transAccount) {
		this.transAccount = transAccount;
	}
	
	public void deposit(Account account, double amount) {
		transType = "deposit";
		transDate = new Date();
		setTransAccount(account);
		setTransAmount(amount);
		account.deposit(amount);
		account.getTransactions().add(this);
	}
	
	public void withdraw(Account account, double amount) {
		if (account.getAccountBalance() > amount) {
			transType = "withdraw";
			transDate = new Date();
			setTransAccount(account);
			setTransAmount(amount);
			account.withdraw(amount);
			account.getTransactions().add(this);
		} else {
			System.err.println("insufficient Balance");
		}
	}
	
	public void withdraw(CurrentAccount account, double amount) {
		if(amount > account.getAccountBalance())
			System.err.println("You are spending over your balance.");
		
        double availableBalance = account.getAccountBalance() + account.getCreditLimit();
        if (availableBalance >= amount) {
        	account.setAccountBalance(account.getAccountBalance() - amount);        	
        	transType = "withdraw";
			transDate = new Date();
			setTransAccount(account);
			setTransAmount(amount);
			account.withdraw(amount);
			account.getTransactions().add(this);
        } else {
            System.err.println("Exceeded credit limit.");
        }
    }
	
	public void calculateInterest(CurrentAccount account) {
		int count=0;
		for(Transaction transaction : account.getTransactions()) {
			if (cDate.format(transaction.getTransDate()).equals(cDate.format(new Date())) &&
					transaction.getTransType() == "interest")
					count++;
		}
		
		if(count != 0)
			System.err.println("The interest is already applied.");
		else {
			double dailyInterest = (double)(account.getAccountBalance() * account.getDailyInterestRate()) / 100.00;
			account.setAccountBalance(account.getAccountBalance() + dailyInterest);
			transType = "interest";
			transDate = new Date();
			setTransAmount(dailyInterest);
			setTransAccount(account);
			account.getTransactions().add(this);
		}
	}
	
	public void calculateInterest(SavingsAccount account) {
		double totalTransition = account.countTransition();
		
		int count=0;
		Date lastTransitionDate = new Date();
		DateTimeFormatter dTformatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		for(Transaction transaction : account.getTransactions()) {
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
		
		if(dayBetween >= 28) {
			double dailyInterest = (double)(account.getAccountBalance() * account.getRate()) / 100.00;
			account.setAccountBalance(account.getAccountBalance() + dailyInterest);
			transType = "interest";
			transDate = new Date();
			setTransAmount(dailyInterest);
			setTransAccount(account);
			account.getTransactions().add(this);
		} else {
			System.err.println("Interest cannot applicable.");
		}
	}

	@Override
    public String toString() {
        return "Transaction id=" + transId + ", date=" + transDate + ", type=" + transType + ", amount=" + transAmount;
    }
}
