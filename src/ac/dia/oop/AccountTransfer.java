package ac.dia.oop;

public class AccountTransfer extends Transaction {
	private Account accTo;
	private String transType = "Transfer";
	
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
        return "Transaction id=" + getTransId() + ", date=" + getTransDate() + ", type=" + getTransType()+ ", amount=" + getTransAmount() + " from " + getTransAccount().getAccountNo() + " to " + getAccTo().getAccountNo() + '\n';
    }
}
