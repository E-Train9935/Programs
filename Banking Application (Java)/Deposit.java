/**
 * Abstract Class: Deposit
 * Deposit super class implementing Account class setting all the accountIDs, balance, customers and setting and returning everything to do with depositing, also deleting accounts and ressiting the withdrawals.
 * Ethian Chiu
 * March 29
 * CS 108 Section X (3)
 */
public abstract class Deposit implements Account {
    public int accountID;
    public Customer firstCustomer;
    public Customer secondCustomer;
    public int accountBalance;
    public int withdrawals;

    public Deposit() {
        accountID = Bank.numAccounts;
        Bank.numAccounts++;
        firstCustomer = checkCustomer();
        accountBalance = 0;
        withdrawals = 0;
        System.out.println("A new account was created with account ID: " + accountID);
        System.out.println("The first holder is: Customer: " + firstCustomer.getCustomerName() + " | Customer ID: " + firstCustomer.getCustomerID());
    }

    public int getAccountID() {
        return accountID;
    }
    public void setAccountID(int ID) {
        accountID = ID;
    }
    public int getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(int balance) {
        accountBalance = balance;
    }

    public int getWithdrawal() {
        return withdrawals;
    }

    public void setWithdrawal(int withdrawal) {
        withdrawals = withdrawal;
    }

    public Customer getFirstCustomer() {
        return firstCustomer;

    }
    public void setFirstCustomer(Customer name) {
        firstCustomer = name;
    }

    public Customer getSecondCustomer() {
        return secondCustomer;
    }

    public void setSecondCustomer(Customer name) {
        secondCustomer = name;
    }

    public boolean depositMoney(int cashIn){

        if (cashIn > 0) {
            accountBalance += cashIn;
            System.out.println("Updated Balance: " + accountBalance);
            return true;
        }
        System.out.println("Invalid Amount");
        return false;
    }

    public Customer checkCustomer() {
        char exist;
        System.out.println("Are you an existing customer? [Y: Yes; N: No]");
        exist = BankApp.scan.nextLine().charAt(0);
        if (Character.toLowerCase(exist) == 'y') {
            System.out.println("Enter Customer ID: ");
            accountID = Integer.parseInt(BankApp.scan.nextLine());
            for(Customer customer : BankApp.customers) {
                if (accountID == customer.getCustomerID()) {
                    return customer;
                }
            }
            System.out.println("There was no record of the ID. A new ID will be created");
        }
            System.out.println("Enter your name: ");
            String name = BankApp.scan.nextLine();
            if(name.length() == 0) {
                return new Customer();
            }
            return new Customer(name);
    }
    public boolean addAccountHolder() {
        secondCustomer = checkCustomer();
        System.out.printf("For Account ID: %d%nFirst Holder: Customer: %s | Customer ID: %d%nSecond Holder: Customer: %s | Customer ID: %d%n", accountID, firstCustomer.getCustomerName(), firstCustomer.getCustomerID(), secondCustomer.getCustomerName(), secondCustomer.getCustomerID());
        return true;
    }
    public boolean updateAccount(Customer other) {
        firstCustomer = other;
        if (firstCustomer == other)
            return true;
        return false;
    }

    public boolean updateAccount(Customer other, int num) {
        if (num == 1) {
            updateAccount(other);
        }
        if (num == 2) {
            secondCustomer = other;
            if (secondCustomer == other)
                return true;
            return false;
        }
        return false;
    }

    public Account deleteAccount() {
        char input;
        System.out.println("Are you sure you want to delete your account?");
        input = BankApp.scan.nextLine().charAt(0);
        if (Character.toLowerCase(input) == 'y') {
            System.out.println("Enter your Customer ID: ");
            accountID = Integer.parseInt(BankApp.scan.nextLine());
            for(Deposit account : BankApp.accounts) {
                if (accountID == account.getAccountID()) {
                    System.out.println("Do you want to delete your savings account with AccID: " + accountID + " ?");
                    input = BankApp.scan.nextLine().charAt(0);
                    if (Character.toLowerCase(input) == 'y') {
                        BankApp.accounts.remove(account);
                        return account;
                    }
                }
            }
            System.out.println("Customer ID Invalid");
        }
        System.out.println("No accounts were deleted");
        return null;
    }
    public void resetWithdrawals(){
        withdrawals = 0;
    }
    public abstract boolean withdrawMoney(int i);
    public abstract int calcInterest();
    public abstract boolean addInterest();
}