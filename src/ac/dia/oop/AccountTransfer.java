package ac.dia.oop;

public class AccountTransfer extends Transaction {
	private Account accTo;
	private String transType = "transfer";
	
	public void transfer(Account by, Account to, double amount) {
		setAccTo(to);
		if (by.getAccountBalance() > amount) {
			deposit(to, amount);
			withdraw(by, amount);
		} else {
			System.out.println("insufficient Balance");
		}
	}
	
	public Account getAccTo() {
		return accTo;
	}
	
	public void setAccTo(Account accTo) {
		this.accTo = accTo;
	}
	
	public String getTransType() {
		return transType;
	}
	
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	@Override
    public String toString() {
		return "\t" + getTransId() + "\t\t"+ getTransType() + "\t\t" + cDate.format(getTransDate()) + "\t" + getTransAmount() + "\t" + getTransAccount().getAccountNo()+ "\t\t\t" +getAccTo().getAccountNo();
//        return "Transaction id=" + getTransId() + ", date=" + getTransDate() + ", type=" + getTransType()+ ", amount=" + getTransAmount() + " from " + getTransAccount().getAccountNo() + " to " + getAccTo().getAccountNo();
    }
}
