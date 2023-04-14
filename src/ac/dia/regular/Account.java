package ac.dia.regular;

public class Account {
	
	private int accountNo;
	private String accountTitle;
	private double accountBalance;
	
	
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
	
	public void deposit(double amount) {
		
		accountBalance += amount;
		
		System.out.println("==== !!! ==== Deposit Successful ==== !!! ====");
		System.out.println("Account No: " + getAccountNo());
		System.out.println("Deposit amount: " + amount);
		System.out.println("Your new balance is: " + getAccountBalance() + "\n");
	}
	
	public void withdraw(double amount) {
		
		if(amount > getAccountBalance()) {
			System.out.println("==== !!! ==== Withdraw Unsuccessful ==== !!! ====");
			System.out.println("The amount " + amount + " you want to withdraw  is gratter then the actual balance.");
			return;
		}

		accountBalance -= amount;
		
		System.out.println("==== !!! ==== Withdraw Successful ==== !!! ====");
		System.out.println("Account No: " + getAccountNo());
		System.out.println("Withdraw amount: " + amount);
		System.out.println("Your new balance is: " + getAccountBalance() + "\n");
	}
	
	public void showDetails() {
		System.out.println("------ Account Information ------");
		System.out.println("---------------------------------");
		System.out.println("- Account No: " + getAccountNo());
		System.out.println("- Account Title: " + getAccountTitle());
		System.out.println("- Account Balance: " + getAccountBalance());
		System.out.println("---------------------------------\n");
	}
}