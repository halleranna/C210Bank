package application;

public class Account {
    private double balance;
    private Customer customer;
    private int accountNumber;

    Account(Customer customer, int accountNumber) {
        this.customer = customer;
    	this.accountNumber = accountNumber;
        this.balance = 0.0;
        
        (this.customer).addAccount(this);
        
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public Customer getCustomer() {
    	return this.customer;
    }
    
    public void setCustomer(Customer customer) {
    	this.customer = customer;
    }

    //instance methods
    public void makeDeposit(double deposit) {
        this.balance += deposit;
        System.out.print("\nAccount updated successfully!\n");
    }

    public void makeWithdrawal(double withdrawal) {
        this.balance -= withdrawal;
        System.out.print("\nAccount updated successfully!\n");
    }
}
