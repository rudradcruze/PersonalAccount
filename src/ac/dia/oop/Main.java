package ac.dia.oop;

public class Main {

	public static void main(String[] args) {
	
		CurrentAccount currentAcc = new CurrentAccount();
		currentAcc.setAccountNo(2001);
		currentAcc.setAccountTitle("Test Current");
		currentAcc.setAccountBalance(100000.00);
		currentAcc.setCreditLimit(50000);
		currentAcc.setDailyInterestRate(10);
		
		SavingsAccount acc2 = new SavingsAccount();
		acc2.setAccountNo(1002);
		acc2.setAccountTitle("Ninjax");
		acc2.setAccountBalance(10000);
		acc2.setRate(10);
		
		Transaction trans1 = new Transaction();
		trans1.setTransId(2001);
		trans1.deposit(acc2, 10000);
		
//		Transaction t1 = new Transaction();
//		t1.setTransId(1002);
//		t1.withdraw(currentAcc, 120000);
		
		Transaction trans2 = new Transaction();
		trans2.setTransId(1001);
		trans2.deposit(currentAcc, 10000);
		
		Transaction trans3 = new Transaction();
		trans3.setTransId(1003);
		trans3.calculateInterest(currentAcc);
		
		Transaction trans4 = new Transaction();
		trans4.setTransId(1005);
		trans4.calculateInterest(acc2);
		
		currentAcc.display();
		acc2.display();
		
		/* savings
		Account acc1 = new Account();
		acc1.setAccountNo(1001);
		acc1.setAccountTitle("Rudra");
		acc1.setAccountBalance(50000);
		
		Account acc2 = new SavingsAccount();
		acc2.setAccountNo(1002);
		acc2.setAccountTitle("Ninjax");
		acc2.setAccountBalance(10000);
		
		Transaction trans1 = new Transaction();
		trans1.setTransId(101);
		trans1.deposit(acc1, 10000);
		
		Transaction trans2 = new Transaction();
		trans2.setTransId(102);
		trans2.withdraw(acc1, 500);
		
		AccountTransfer trans3 = new AccountTransfer();
		trans3.setTransId(103);
		trans3.transfer(acc1, acc2, 5000);
		
		acc1.display();
		acc2.display();
		*/

	}

}
