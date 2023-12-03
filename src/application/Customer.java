package application;

import java.util.ArrayList;

public class Customer {
    private int customerID;
    private String name;
    private ArrayList<Account> accountsHeld; 
    
    Customer(String newName, int newID) {
    	this.name = newName;
    	this.customerID = newID;
    	this.accountsHeld = new ArrayList<Account>(); 
    }
    
    public int getCustomerID() {
        return this.customerID;
    }
    
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<Account> getAccountsHeld(){
    	return this.accountsHeld;
    }
    
    public void addAccount(Account account) {
    	accountsHeld.add(account);
    }
    
    public void removeAccount(Account account) {
    	accountsHeld.remove(account);
    }

}