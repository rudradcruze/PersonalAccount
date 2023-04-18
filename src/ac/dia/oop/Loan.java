package ac.dia.oop;

public class Loan extends Account {
	
	private double rate;
	private int installments;
	private int expierDate;
	private String accType = "Loan Account";
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getInstallments() {
		return installments;
	}

	public void setInstallments(int installments) {
		this.installments = installments;
	}

	public int getExpierDate() {
		return expierDate;
	}

	public void setExpierDate(int expierDate) {
		this.expierDate = expierDate;
	}

	public String getAccType() {
		return accType;
	}

	@Override
	public double interest() {
		double interestAmount = ((getAccountBalance() * getRate()) / 100.00)/getInstallments();
		return interestAmount;
	}
	
	@Override
    public void display() {
        System.out.println("- " + getAccType());
        System.out.println("- Total Instalments: " + getInstallments());
        System.out.println("- Left Installments: " + (getInstallments() - countTransition()));
        System.out.println("- Paid Installment: " + countTransition());
        System.out.println("- Limit Year: " + getExpierDate() + " years");
        System.out.println("- Account No: " + getAccountNo());
		System.out.println("- Account Title: " + getAccountTitle());
		System.out.println("-------------------------------------------------------------------------------------------------------------------");  
		System.out.println("Transition ID\tType\t\t\tDate\t\t\tAmount\tAccount to\tInsterest by");
		System.out.println("-------------------------------------------------------------------------------------------------------------------");   

		for(Transaction transaction : getTransactions()) {
			System.out.println(transaction);
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------");  
		
		System.out.println("- Account Balance: " + getAccountBalance() + "\n");
    }

}
