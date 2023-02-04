/**
 * Interface: Account
 * Interface of the Deposit class (does not implement).
 * Ethian Chiu
 * March 29
 * CS 108 Section X (3)
 */
public interface Account {

    public boolean addAccountHolder();
    public boolean updateAccount(Customer c);
    public boolean updateAccount(Customer c, int i);
    public Account deleteAccount();
    public int getAccountID();

}