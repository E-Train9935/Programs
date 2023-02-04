/**
 * Concrete Class: Customer
 * Stores and returns Customer names, customerID and where the customer objects are in.
 * Ethian Chiu
 * March 29
 * CS 108 Section X (3)
 */
public class Customer {
    final int customerID;
    String customerName;
    int numOfAccounts;

    public Customer() {
        BankApp.customers.add(this);
        customerID = Bank.numCustomers;
        customerName = "Customer" + customerID;
        Bank.numCustomers++;
        numOfAccounts = 0;
    }

    public Customer(String name) {
        this();
        customerName = name;
    }

    public int getCustomerID() {
        return customerID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String inputName) {
        customerName = inputName;
    }
    public int getCustomerAccounts() {
        return numOfAccounts;
    }
    public void setCustomerAccounts(int numAccounts) {
        numOfAccounts = numAccounts;
    }
    public String toString() {
        return "Customer: " + customerName + " | Customer ID: " + customerID;
    }
}