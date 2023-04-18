package ac.dia.oop;

public class Main {

	public static void main(String[] args) {
		
		Loan loan1 = new Loan();
		loan1.setAccountBalance(100000);
		loan1.setRate(10);
		loan1.setAccountNo(9001);
		loan1.setAccountTitle("Loan test");
		loan1.setExpierDate(3);
		loan1.setInstallments(10);
		
//		SavingsAccount sav12=  new SavingsAccount();
//		sav12.setAccountNo(434);
//		sav12.setAccountBalance(100000);
//		
		Installment ins1 = new Installment();
		ins1.setTransId(8001);
		ins1.installment(loan1, 10000);
		
		Installment ins2 = new Installment();
		ins2.setTransId(8002);
		ins2.installment(loan1, 8000);
		
		Installment ins3 = new Installment();
		ins3.setTransId(8003);
		ins3.installment(loan1, 10000);
		
//		AccountTransfer ac21 =  new AccountTransfer();
//		ac21.setTransId(111);
//		ac21.transfer(loan1, sav12, 10000);
		
		
		loan1.display();
		
		
		/*
		CurrentAccount currentAcc = new CurrentAccount();
		currentAcc.setAccountNo(2001);
		currentAcc.setAccountTitle("Test Current");
		currentAcc.setAccountBalance(100000.00);
		currentAcc.setCreditLimit(50000);
		currentAcc.setDailyInterestRate(10);
		
		Transaction t1 = new Transaction();
		t1.setTransId(1002);
		t1.withdraw(currentAcc, 120000);
		
		Transaction t2 = new Transaction();
		t2.setTransId(1003);
		t2.withdraw(currentAcc, 30000);
		
		Transaction t3 = new Transaction();
		t3.setTransId(1004);
		t3.interest(currentAcc);
		
		currentAcc.display();
		*/
		/*
		SavingsAccount acc1 = new SavingsAccount();
		acc1.setAccountNo(1001);
		acc1.setAccountTitle("Rudra");
		acc1.setAccountBalance(50000);
		acc1.setRate(10);
		acc1.setLimit(3);
		
		SavingsAccount acc2 = new SavingsAccount();
		acc2.setAccountNo(1002);
		acc2.setAccountTitle("Ninjax");
		acc2.setAccountBalance(50000);
		acc2.setRate(10);
		acc2.setLimit(3);
		
		AccountTransfer transfer = new AccountTransfer();
		transfer.setTransId(999);
		transfer.transfer(acc1, acc2, 4000);
		
		Transaction trans1 = new Transaction();
		trans1.setTransId(101);
		trans1.withdraw(acc1, 10000);
		
		Transaction trans2 = new Transaction();
		trans2.setTransId(102);
		trans2.withdraw(acc1, 500);
		
		Transaction trans3 = new Transaction();
		trans3.setTransId(103);
		trans3.withdraw(acc1, 5000);
				
//		Transaction trans4 = new Transaction();
//		trans4.setTransId(104);
//		trans4.withdraw(acc1, 5000);
		
		Transaction trans5 = new Transaction();
		trans5.setTransId(105);
		trans5.interest(acc1);
//		
//		Transaction trans6 = new Transaction();
//		trans6.setTransId(106);
//		trans6.withdraw(acc1, 1000);
//		
		Transaction trans7 = new Transaction();
		trans7.setTransId(107);
		trans7.deposit(acc1, 1000);

		Transaction trans8 = new Transaction();
		trans8.setTransId(108);
		trans8.interest(acc1);
//
		Transaction trans9 = new Transaction();
		trans9.setTransId(109);
		trans9.withdraw(acc1, 1000);
		
		acc1.display();
		*/
		
		/*
//		Fixed Account
		FixedDeposit fx1 = new FixedDeposit();
		fx1.setAccountNo(5001);
		fx1.setAccountTitle("Nella");
		fx1.setInterestRate(10);
		fx1.setYear((byte) 3);
//		fx1.setAccountBalance(10000);
		
		Transaction fxtrans1 = new Transaction();
		fxtrans1.setTransId(6001);
		fxtrans1.deposit(fx1, 20000);
		
//		Transaction fxtrans2 = new Transaction();
//		fxtrans2.setTransId(6002);
//		fx1.setStatus("close");
//		fxtrans2.calculateInterest(fx1);
//		
		Transaction fxtrans3 = new Transaction();
		fxtrans3.withdraw(fx1);
		
		fx1.display();
		
		*/
		
		/* Current Account
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
		*/
		/*
		SavingsAccount acc1 = new SavingsAccount();
		acc1.setAccountNo(1001);
		acc1.setAccountTitle("Rudra");
		acc1.setAccountBalance(50000);
		acc1.setRate(10);
		acc1.setLimit(3);
		
		SavingsAccount acc2 = new SavingsAccount();
		acc2.setAccountNo(1002);
		acc2.setAccountTitle("Ninjax");
		acc2.setAccountBalance(10000);
		acc2.setRate(10);
		acc2.setLimit(3);
		
		Transaction trans1 = new Transaction();
		trans1.setTransId(101);
		trans1.deposit(acc1, 10000);
		
		Transaction trans2 = new Transaction();
		trans2.setTransId(102);
		trans2.withdraw(acc1, 500);
		
		AccountTransfer trans3 = new AccountTransfer();
		trans3.setTransId(103);
		trans3.transfer(acc1, acc2, 5000);
		
		Transaction trans4 = new Transaction();
		trans4.setTransId(104);
		trans4.calculateInterest(acc1);
		

		
		Transaction trans5 = new Transaction();
		trans5.setTransId(104);
		trans5.calculateInterest(acc1);
		
		acc1.display();
//		acc2.display();
*/
	}

}
