/**
 * Concrete Class: Checking
 * The checking account where the interest rate, balance and the withdraws happen in the checkings account as well as the method of how much there is inside this account.
 * Ethian Chiu
 * March 29
 * CS 108 Section X (3)
 */
public class Checking extends Deposit {
    public final int interestRate = 1;

    public Checking() {
        super();
    }

    public boolean withdrawMoney(int i) {

        if (i < 0) {
            System.out.println("Invalid Amount");
            return false;
        }
        else if (accountBalance < i) {
            System.out.println("Not Enough Balance");
            return false;
        }
        else {
            accountBalance =  accountBalance - i;
            withdrawals++;
            System.out.println("Updated Balance: " + accountBalance);
            return true;
        }
    }

    public int calcInterest() {
        int interestPerMonth = accountBalance * interestRate/100/12;
        return interestPerMonth;
    }

    public boolean addInterest() {
        if (BankApp.bank.isMonthEnd == true) {
            accountBalance = calcInterest() + accountBalance;
            return true;
        }
        return false;
    }

    public String toString() {
        return "Checking | Balance: " + accountBalance + " | Withdrawals: " + withdrawals + " | Potential Interest: " + calcInterest();
    }
}