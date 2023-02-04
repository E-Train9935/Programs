/**
 * Concrete Class: Bank
 * The num of accounts and customers are stored here as well as all the methods of the months
 * Ethian Chiu
 * March 29
 * CS 108 Section X (3)
 */

public class Bank {
    public static int numAccounts;
    public static int numCustomers;
    public int month;
    public boolean isMonthEnd;

    public Bank() {
        month = 0;
        isMonthEnd = false;
    }
    public int getMonth(){
        return month;
    }
    public int nextMonth() {
        if (isMonthEnd == false) {
            System.out.println("It is not the end of month!");
            return -1;
        }
        isMonthEnd = false;
        if (month == 11) {
            month = 0;
        }
            month++;
            return month;
    }
        public int endOfMonth() {
            if (isMonthEnd == true) {
                System.out.println("It is already end of month!");
                return -1;
            }
            isMonthEnd = true;
            System.out.println("It is now end of month!");
            return month;
        }
 }
