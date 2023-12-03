package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Operator extends Application {
	Label lblDisplay = new Label("Messages:");
	Label lblName = new Label("Name:");
	Label lblCustomerNum = new Label("Customer Number:");
	Label lblAccountNum = new Label("Account Number:");
	Label lblCustomers = new Label("Existing Customers:");
	Label lblHeader = new Label("Bank of C210 - Blue Branch");
	Label lblAccountOps = new Label("Account Operations");
	Label lblBankOps = new Label("Bank Operations");
	Label lblAmount = new Label("Amount:");
	
	Button btnAddChecking = new Button("Add a Checking Account");
	Button btnAddGold = new Button("Add a Gold Account");
	Button btnAddRegular = new Button("Add a Regular Account");
	Button btnDeposit = new Button("Make a Deposit");
	Button btnWithdraw = new Button("Make a Withdrawal");
	Button btnAccountInfo = new Button("Display Account Info");
	Button btnRemove = new Button("Remove an Account");
	Button btnEOM = new Button("Apply End-of-Month");
	Button btnStats = new Button("Run Bank Statistics");
	Button btnSubmit = new Button("Submit");
	
	TextArea taCustomers = new TextArea();
	TextArea taDisplay = new TextArea("Welcome to the Bank of C210! Please select an option on the right.");
	TextField txtName = new TextField();
	TextField txtCustomerNum = new TextField();
	TextField txtAccountNum = new TextField();
	TextField txtAmount = new TextField();
	
	ArrayList<String> editableFields = new ArrayList<>();
	
	
	ArrayList<Account> accounts = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    String accountType = "";
    String transactionType = "";
    String action = "";
    String name = "";
    int customerID = 0;
    int accountNumber = 0;
    double amount = 0.;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		
		//styling header label
		Font fontHeader = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 35);
		lblHeader.setFont(fontHeader);
			lblHeader.setTextFill(Color.WHITE);
				
		//styling operations labels
		Font fontOpsLabels = Font.font("Arial", 15);
		lblAccountOps.setFont(fontOpsLabels);
		lblBankOps.setFont(fontOpsLabels);
		
		
		taCustomers.setPrefHeight(500);
		taCustomers.setPrefWidth(150);
		
		
		taCustomers.setEditable(false);
		taDisplay.setEditable(false);
		txtName.setEditable(false);
		txtCustomerNum.setEditable(false);
		txtAccountNum.setEditable(false);
		txtAmount.setEditable(false);
		
		//top pane (header) formatting
		HBox topPane = new HBox();
		topPane.setPadding(new Insets(15, 15, 15, 15));
		topPane.setStyle("-fx-background-color: blue;");
		topPane.getChildren().add(lblHeader);
		
		//right pane (options) formatting
		VBox accountOpsPane = new VBox();
		accountOpsPane.setPadding(new Insets(15, 15, 15, 15));
		accountOpsPane.getChildren().addAll(lblAccountOps, btnAddChecking, btnAddGold, btnAddRegular, btnDeposit, btnWithdraw, btnAccountInfo, btnRemove);
		
		VBox bankOpsPane = new VBox();
		bankOpsPane.setPadding(new Insets(15, 15, 15, 15));
		bankOpsPane.getChildren().addAll(lblBankOps, btnEOM, btnStats);
		
		VBox rightPane = new VBox();
		//rightPane.setPadding(new Insets(15, 15, 15, 15));
		rightPane.getChildren().addAll(accountOpsPane, bankOpsPane);
		
		
		//center pane formatting
		VBox display = new VBox();
		display.setPadding(new Insets(15, 15, 15, 15));
		display.getChildren().addAll(lblDisplay, taDisplay);
		
		VBox input = new VBox();
		input.setPadding(new Insets(15, 15, 15, 15));
		input.getChildren().addAll(lblName, txtName, lblCustomerNum, txtCustomerNum, lblAccountNum, txtAccountNum, lblAmount, txtAmount, btnSubmit);
		
		VBox centerPane = new VBox();
		centerPane.getChildren().addAll(display, input);
		
		//left pane formatting
		VBox customers = new VBox();
		customers.setPadding(new Insets (15,15,15,15));
		customers.getChildren().addAll(lblCustomers, taCustomers);
		
		VBox leftPane = new VBox();
		leftPane.getChildren().add(customers);
		
		
		//main pane formatting
		BorderPane mainPane = new BorderPane();
		mainPane.setTop(topPane);
		mainPane.setLeft(leftPane);
		mainPane.setCenter(centerPane);
		mainPane.setRight(rightPane);
		
		btnAddChecking.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				taDisplay.appendText("\nPlease enter account information below.");
				action = "Create";
				accountType = "Checking";
				txtName.setEditable(true);
				txtCustomerNum.setEditable(true);
				txtAccountNum.setEditable(true);
			}
		});
		
		btnAddGold.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				taDisplay.appendText("\nPlease enter account information below.");
				action = "Create";
				accountType = "Gold";
				txtName.setEditable(true);
				txtCustomerNum.setEditable(true);
				txtAccountNum.setEditable(true);
			}
		});
		
		btnAddRegular.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				taDisplay.appendText("\nPlease enter account information below.");
				action = "Create";
				accountType = "Regular";
				txtName.setEditable(true);
				txtCustomerNum.setEditable(true);
				txtAccountNum.setEditable(true);
			}
		});
		
		btnDeposit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				taDisplay.appendText("\nPlease enter account number and desired amount.");
				action = "Transaction";
				transactionType = "Deposit";
				txtAccountNum.setEditable(true);
				txtAmount.setEditable(true);
			}
		});
		
		btnWithdraw.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				taDisplay.appendText("\nPlease enter account number and desired amount.");
				action = "Transaction";
				transactionType = "Withdrawal";
				txtAccountNum.setEditable(true);
				txtAmount.setEditable(true);
			}
		});
		
		btnAccountInfo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				taDisplay.appendText("\nEnter the account you wish to display.");
				action = "View";
				txtAccountNum.setEditable(true);
			}
		});
		
		btnRemove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				taDisplay.appendText("\nEnter the account you wish to remove.");
				action = "Remove";
				txtAccountNum.setEditable(true);
			}
		});
		
		btnEOM.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				applyEndOfMonth();
			}
		});
		
		btnStats.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				displayBankStatistics();
			}
		});
		
		btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				if (action.equals("Create")) {
					name = txtName.getText();
					taDisplay.appendText("\nThe name you entered is: " + name);
			
					customerID = Integer.parseInt(txtCustomerNum.getText());
					taDisplay.appendText("\nThe customer ID you entered is: " + customerID);
			
					accountNumber = Integer.parseInt(txtAccountNum.getText());
					taDisplay.appendText("\nThe account number you entered is: " + accountNumber);
				
					createAccount(accountType);
					customerDisplay();
				} else if(action.equals("Transaction")) {
					accountNumber = Integer.parseInt(txtAccountNum.getText());
					amount = Double.parseDouble(txtAmount.getText());
					transaction(transactionType);
				} else if(action.equals("View")) {
					accountNumber = Integer.parseInt(txtAccountNum.getText());
					displayAccountInfo();
				} else if(action.equals("Remove")) {
					accountNumber = Integer.parseInt(txtAccountNum.getText());
					removeAccount();
					customerDisplay();
				}
				
				txtName.setEditable(false);
				txtCustomerNum.setEditable(false);
				txtAccountNum.setEditable(false);
				txtAmount.setEditable(false);
				
				txtName.clear();
				txtCustomerNum.clear();
				txtAccountNum.clear();
				txtAmount.clear();
				
				taDisplay.appendText("\n\n------------");
				taDisplay.appendText("\nPlease select an option on the right.");
			}
			
		});

		Scene scene = new Scene(mainPane, 1000, 650);
		primaryStage.setTitle("Bank of C210");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	public void createAccount(String accountType) {
        
        //determines if customer already exists or if a new customer should be created
        Customer workingCustomer = null;
        for(Customer customer : customers) {
        	if (customer.getCustomerID() == customerID) {
        	    workingCustomer = customer;
        	}
        }
        if(workingCustomer == null) {
        	workingCustomer = new Customer(name, customerID);
        	customers.add(workingCustomer);
    	}

        //creates account object based on account type and customer information
        Account account = null;
        if (accountType.equals("Checking")) {
            account = new Checking(workingCustomer, accountNumber);
        } else if (accountType.equals("Gold")) {
            account = new Gold(workingCustomer, accountNumber);
        } if (accountType.equals("Regular")) {
            account = new Regular(workingCustomer, accountNumber);
        }
        
        taDisplay.appendText("\n" + accountType + " account created successfully!");

        accounts.add(account);
    }
	
	public void transaction(String transactionType) {
		System.out.print("\nPlease input the account number and desired amount: ");
        
        //determines if account exists; if so, performs a deposit or withdrawal
        for(Account account : accounts) {
        	if (account.getAccountNumber() == accountNumber) {

                if (transactionType.equals("Deposit")) {
                    account.makeDeposit(amount);
                    taDisplay.appendText("\nTransaction complete.");
                    return;
                } else if (transactionType.equals("Withdrawal")) {
                    account.makeWithdrawal(amount);
                    taDisplay.appendText("\nTransaction complete.");
                    return;
                }
            }
        }
        
        taDisplay.appendText("\nAccount not found!\n");
            
        
        
    }
	
	 public void displayAccountInfo() {

	        for (Account account : accounts) {
	            if (account.getAccountNumber() == accountNumber) {
	                taDisplay.appendText("\nAccount Information:");
	                taDisplay.appendText("\nAccount Number: " + account.getAccountNumber());
	                taDisplay.appendText("\nCustomer Name: " + (account.getCustomer()).getName());
	                taDisplay.appendText("\nCustomer ID: " + (account.getCustomer()).getCustomerID());
	                if(account.getBalance() >= 0){
	                	taDisplay.appendText("\nBalance: $" + account.getBalance());
	                } else if(account.getBalance() < 0) {
	                	//allows a negative balance to be displayed correctly
	                	double positiveBalance = -1 * account.getBalance(); 
	                	taDisplay.appendText("\nBalance: -$" + positiveBalance);
	                }
	                return;
	            }
	        }

	        taDisplay.appendText("\nAccount not found!");
	    }
	 
	 public void removeAccount() {

	        for (Account account : accounts) {
	            if (account.getAccountNumber() == accountNumber) {
	                accounts.remove(account);
	                (account.getCustomer()).removeAccount(account);
	                taDisplay.appendText("\nAccount removed successfully!");
	                return;
	            }
	        }

	        taDisplay.appendText("\nAccount not found, unable to remove!");
	    }
	 
	 public void applyEndOfMonth() {
	        for (Account account : accounts) {
	            if (account instanceof Gold) {
	                Gold goldAccount = (Gold) account;
	                goldAccount.calculateInterest();
	            } else if (account instanceof Regular) {
	                Regular regularAccount = (Regular) account;
	                regularAccount.newMonthlyBalance();
	            } else if (account instanceof Checking) {
	                Checking checkingAccount = (Checking) account;
	                checkingAccount.monthlyFees();
	            }
	        }
	        taDisplay.appendText("\nEnd-of-month actions applied to all accounts.");
	    }
	 
	 public void displayBankStatistics() {
	        double totalBalance = 0;
	        int zeroBalanceAccounts = 0;
	        double maxBalance = 0;
	        String largestOwner = "";
	        double averageBalance = 0;

	        for (Account account : accounts) {
	            totalBalance += account.getBalance();
	            if (account.getBalance() == 0) {
	                zeroBalanceAccounts++;
	            }
	            if (account.getBalance() > maxBalance) {
	                maxBalance = account.getBalance();
	                largestOwner = (account.getCustomer()).getName();
	            }
	        }
	        
	        if(accounts.size() > 0) {
	        averageBalance = totalBalance / accounts.size();
	        }
	        
	        taDisplay.appendText("\nBank Statistics:");
	        taDisplay.appendText("\nTotal Balance in the Bank: $" + totalBalance);
	        taDisplay.appendText("\nNumber of Zero-Balance Accounts: " + zeroBalanceAccounts);
	        taDisplay.appendText("\nAverage Balance of Accounts: $" + averageBalance);
	        taDisplay.appendText("\nAccount with Largest Balance: $" + maxBalance);
	        taDisplay.appendText("\nLargest account owner: " + largestOwner);
	    }
	
	public void customerDisplay() {
		taCustomers.setText("");
		for(Customer customer : customers) {
			taCustomers.appendText(customer.getName() + "\n");
			for(Account account : customer.getAccountsHeld()) {
				taCustomers.appendText("  -- " + account.getAccountNumber() + "\n");
			}
		}
	}
}

