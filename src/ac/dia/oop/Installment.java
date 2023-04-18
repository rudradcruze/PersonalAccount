package ac.dia.oop;

public class Installment extends Transaction {

	private String transType = "installment"; 
	private double interest;
	
	public void installment(Account account, double amount) {
		setTransAccount(account);
		double interest = account.interest();
		setInterest(interest);
		withdraw(account, (amount - interest));
	}
	
	public String getTransType() {
		return transType;
	}
	
	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getInterest() {
		return interest;
	}

	@Override
	public String toString() {
		return "\t" + getTransId() + "\t\t"+ getTransType() + "\t" + cDate.format(getTransDate()) + "\t" + (getTransAmount()+getInterest()) + "\t" + getTransAccount().getAccountNo()+ "\t\t\t" +getInterest();
//		return "Installment [transType=" + transType + ", interest=" + interest + "]";
	}
	
	
}
