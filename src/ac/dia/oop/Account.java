package ac.dia.oop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Account {
	
	private int accountNo;
	private String accountTitle;
	private double accountBalance;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	SimpleDateFormat cDate = new SimpleDateFormat();
	
	public Account() {
		super();
	}

	public Account(int accountNo, String accountTitle, double accountBalance) {
		super();
		this.accountNo = accountNo;
		this.accountTitle = accountTitle;
		this.accountBalance = accountBalance;
	}
	
	public int countTransition() {
		int n = 0;
		for (Transaction transaction : getTransactions())
			if (cDate.format(transaction.getTransDate()).equals(cDate.format(new Date())))
				n++;
		return n;
	}
	
	public int getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountTitle() {
		return accountTitle;
	}
	
	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	public void deposit(double amount) {
		accountBalance += amount;
	}
	
	public void withdraw(double amount) {
		if (accountBalance >= amount)
			accountBalance -= amount;
		else {
			System.err.println("insufficient Balance");
		}
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountTitle=" + accountTitle + ", accountBalance="
				+ accountBalance + "]";
	}
	
	public void display() {
		System.out.println("- Account No: " + getAccountNo());
		System.out.println("- Account Title: " + getAccountTitle());
		
		for(Transaction transaction : transactions) {
			System.out.println("* " + transaction);
		}
		
		System.out.println("- Account Balance: " + getAccountBalance() + "\n");
	}
	
	public void show() {
		System.out.println("------ Account Information ------");
		System.out.println("- Account No: " + getAccountNo());
		System.out.println("- Account Title: " + getAccountTitle());
		System.out.println("- Account Balance: " + getAccountBalance());
	}
}
