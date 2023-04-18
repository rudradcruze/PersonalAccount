package ac.dia.oop;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Transaction {
	
	private int transId;
	private String transType;
	private Date transDate;
	private double transAmount;
	private Account transAccount;
	SimpleDateFormat cDate = new SimpleDateFormat("dd-MM-yyyy");
	
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
		transType = "withdraw";
		transDate = new Date();
		setTransAccount(account);
		setTransAmount(amount);
		account.getTransactions().add(this);
		account.withdraw(amount);
	}

	public void interest(Account account) {
		double amount = account.interest();
		if (amount != 0) {
			transType = "interest";
			transDate = new Date();
			setTransAccount(account);
			setTransAmount(amount);
			account.deposit(amount);
			account.getTransactions().add(this);
		} else
			System.err.println("Interest cannot applicable.");
	}
	
	@Override
    public String toString() {
//        return "Transaction id=" + transId + ", date=" + transDate + ", type=" + transType + ", amount=" + transAmount;
        return "\t" + getTransId() + "\t\t"+ getTransType() + "\t\t" + cDate.format(getTransDate()) + "\t" + getTransAmount() + "\t" + getTransAccount().getAccountNo();
    }
}
