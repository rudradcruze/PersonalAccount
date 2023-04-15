package ac.dia.oop;

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
	
	@Override
 	public void display() {
		System.out.println("- " + getAccType());
        System.out.println("- Validity: " + getYear() + " years");
        System.out.println("- Interest Rate: " + getInterestRate());
        System.out.println("- Transition Count: " + countTransition());
        System.out.println("- Account Status: " + getStatus());
        super.display();
	}
}
