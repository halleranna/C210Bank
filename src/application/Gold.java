package application;

public class Gold extends Account {
	//instance variables
	static double interestRate = 0.05; 
		
	Gold(Customer customer, int accountNum){ 
		super(customer, accountNum);
	}
	
	//getter and setter
	public double getInterestRate() {
		return Gold.interestRate;
	}

	//instance method
	public void calculateInterest() {
		double interest = this.getBalance()*interestRate;
		double newBalance = this.getBalance() + interest;
		this.setBalance(newBalance);
	}
	
	
}
