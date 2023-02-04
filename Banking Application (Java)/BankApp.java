/**
 * BankApp Class (Main File)
 * The main method is in here and scanner, where all the magic happens, stores both arraylist of accounts and customers and implements all the classes in the app, except the account class.
 * Ethian Chiu
 * March 29
 * CS 108 Section X (3)
 */
import java.util.Scanner;
import java.util.ArrayList;

public class BankApp {

  static Scanner scan = new Scanner(System.in);
  public static Bank bank;
  public static ArrayList<Deposit> accounts;
	public static ArrayList<Customer> customers;

   public static void main(String[] args) {
	   int choice = -5;
	   System.out.println("The Local Union");
	   BankApp app = new BankApp();
	   while (true) {
		   app.printMenu();

		   int accountID;
		   while (choice < 0 || choice > 9) {
			   System.out.println("Enter a relevant option: ");
			   choice = Integer.parseInt(scan.nextLine());
		   }
		   switch (choice) {
			   case 0:
				   System.out.println("Thanks for using the bank application");
				   return;
			   case 1:
			   	   int accountType;
				   System.out.println("1. Deposit Account: Checking");
				   System.out.println("2. Deposit Account: Savings");
				   System.out.println("0. Return to the main menu");
				   System.out.println("Enter the type of account you wish to open: ");
				   accountType = Integer.parseInt(scan.nextLine());
				   if (accountType == 1) {
					   accounts.add(new Checking());
				   }
				   else if (accountType == 2) {
					   accounts.add(new Savings());
				   }
				   else
					   System.out.println("Exiting to main menu");
				   break;
			   case 2:
				   System.out.println("Enter your account ID: ");
				   accountID = Integer.parseInt(scan.nextLine());
				   for (Deposit account : accounts) {
					   if (accountID == account.getAccountID()) {
						   account.addAccountHolder();
					   }
				   }

				   break;
			   case 3:
				   System.out.println("Enter your account ID: ");
				   accountID = Integer.parseInt(scan.nextLine());
				   for (Deposit account : accounts) {
					   if (accountID == account.getAccountID()) {
						   System.out.println("1. Deposit");
						   System.out.println("2. Withdraw");
						   System.out.println("0. Return to Main Menu");
						   int input = Integer.parseInt(scan.nextLine());
						   if (input == 1) {
							   System.out.println("Enter the amount you wish to deposit: ");
							   int depositMoney = Integer.parseInt(scan.nextLine());
							   account.depositMoney(depositMoney);
							   break;
						   }
						   else if (input == 2) {
							   System.out.println("Enter the amount you wish to withdraw: ");
							   int withdrawMoney = Integer.parseInt(scan.nextLine());
							   account.withdrawMoney(withdrawMoney);
							   break;
						   }
						   else {
							   System.out.println("Exiting to main menu");
						   }
					   }

				   }
				   break;
			   case 4:
				   System.out.println("Enter your account ID: ");
				   accountID = Integer.parseInt(scan.nextLine());
				   for (Deposit account : accounts) {
					   if (accountID == account.getAccountID()) {
						   account.deleteAccount();
						   break;

					   }
				   }
				   break;
			   case 5:
				   System.out.println("Enter your account ID: ");
				   accountID = Integer.parseInt(scan.nextLine());
				   for (Deposit account : accounts) {
					   if (accountID == account.getAccountID()) {
						   System.out.println(account.toString());
						   break;
					   }

				   }
				   break;
			   case 6:
				   System.out.println("Enter your customer ID: ");
				   int customerID = Integer.parseInt(scan.nextLine());
				   for (Customer customer : customers) {
					   if (customerID == customer.getCustomerID()) {
						   System.out.println(customer.toString());
						   break;
					   }
				   }
				   break;
			   case 7:
				   bank.endOfMonth();
				   for (Deposit account : accounts) {
//					   //System.out.println(account.calcInterest());
					   account.addInterest();
					   account.resetWithdrawals();
				   }
				   break;
			   case 8:
				   bank.nextMonth();
				   break;
			   case 9:
				   System.out.println("Current Month: " + bank.getMonth());
				   System.out.println("Month End Flag: " + (bank.isMonthEnd ? "true" : "false"));
				   break;
		   }
		   choice = -1;
	   }
   }


   public BankApp() {
      //default ctor
	bank = new Bank();
	accounts =  new ArrayList<Deposit>();
	customers = new ArrayList<Customer>();
   }

   public void printMenu() {
		System.out.println();
		System.out.println("1. Open a new account.");
		System.out.println("2. Add a second holder to an existing account.");
		System.out.println("3. Deposit/Withdraw");
		System.out.println("4. Delete a current account.");
		System.out.println("5. Print details about a account.");
		System.out.println("6. Print details about a customer.");
		System.out.println("7. Update to end month [reset withdrawals & add interest].");
		System.out.println("8. Update to next month.");
		System.out.println("9. Print details about month.");
		System.out.println("0. Exit");
		System.out.println();
	}


}
