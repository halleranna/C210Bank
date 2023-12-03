package application;

public class Regular extends Account {
	static double interestRate = 0.06; 
	static double maintenanceFee = 10.0;

	
	Regular (Customer customer, int accountNumber) {
		super(customer, accountNumber);
	}
	
	//getter and setters
	public double getInterestRate() {
		return Regular.interestRate;
	}

	public double getMaintenanceFee() {
		return Regular.maintenanceFee;
	}
	
	//instance methods
	public void makeWithdrawal(double withdrawal) {
		if (this.getBalance() > 0.) {
			if(withdrawal > this.getBalance()) {
				System.out.println("You are attempting to withdraw more money than is in your account.");
				double newWithdrawal = this.getBalance();
				System.out.println("Only $" + newWithdrawal + " was withdrawn.");
				super.makeWithdrawal(newWithdrawal);
			}else {
				super.makeWithdrawal(withdrawal);
			}
		}else {
			System.out.println("There is no money in this account.");
		}
	}
	
	public void newMonthlyBalance() {
		double monthlyBalance = (this.getBalance() + (this.getBalance()*interestRate)) - maintenanceFee;
		this.setBalance(monthlyBalance);
	}
	
}