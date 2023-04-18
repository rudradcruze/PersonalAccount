package ac.dia.oop;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class Account {
	
	private int accountNo;
	private String accountTitle;
	private double accountBalance;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	SimpleDateFormat cDate = new SimpleDateFormat("dd-MM-yyyy");
	
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
		accountBalance -= amount;
	}
	
	public abstract double interest();
	
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountTitle=" + accountTitle + ", accountBalance="
				+ accountBalance + "]";
	}
	
	public void display() {
		System.out.println("- Account No: " + getAccountNo());
		System.out.println("- Account Title: " + getAccountTitle());
		System.out.println("-------------------------------------------------------------------------------------------------------------------");  
		System.out.println("Transition ID\tType\t\t\tDate\t\t\tAmount\tAccount to\tAccount by");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");   

		for(Transaction transaction : transactions) {
			System.out.println(transaction);
//			System.out.println("\t" + transaction.getTransId() + "\t\t"+ transaction.getTransType() + "\t\t" + cDate.format(transaction.getTransDate()) + "\t" + transaction.getTransAmount() + "\t" + transaction.getTransAccount().accountNo);
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------");  
		
		System.out.println("- Account Balance: " + getAccountBalance() + "\n");
	}
}
