package application;

public class Checking extends Account { 
	static double transactionFee = 3.0;
	private int monthlyTransactions;
	
	Checking (Customer customer, int accountNumber) {
		super(customer, accountNumber);
		this.monthlyTransactions = 0;
	}
	//getters and setters
		public double getTransactionFee() {
			return Checking.transactionFee;
		}
		public void setTransactionFee(double transactionFee) {
			Checking.transactionFee = transactionFee;
		}
		public int getMonthlyTransactions () {
			return this.monthlyTransactions;
		}
	
	//instance method
		public void makeDeposit(double amount) {
			super.makeDeposit(amount);
			this.monthlyTransactions++;
		}
		
		//overrides makeWithdrawal in Account to account for restrictions on withdrawals and to update monthlyTransactions
		public void makeWithdrawal(double amount) {
			if (this.getBalance() > 0.) {
				if(amount > this.getBalance()) {
					System.out.println("You are attempting to withdraw more money than is in your account.");
					double newWithdrawal = this.getBalance();
					System.out.println("Only $" + newWithdrawal + " was withdrawn.");
					super.makeWithdrawal(newWithdrawal);
					this.monthlyTransactions++;
				}else {
					super.makeWithdrawal(amount);
					this.monthlyTransactions++;
				}
			}else {
				System.out.println("There is no money in this account.");
			}
		}
		
		//Calculates and assesses monthly fees
		public void monthlyFees() {
			if (monthlyTransactions > 2) {
				double monthlyBalance = this.getBalance() - ((getMonthlyTransactions()-2)*3);
				this.setBalance(monthlyBalance);
				}
			
	//toString?
		}
}