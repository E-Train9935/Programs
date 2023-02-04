/**
 * Concrete Class: Checking
 * The savings account where the interest rate, balance and the withdraws happen in the checkings account as well as the method of how much there is inside this account.
 * Ethian Chiu
 * March 29
 * CS 108 Section X (3)
 */
public class Savings extends Deposit {
    public final int interestRate = 4;

    public Savings() {
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
        else if (withdrawals == 3) {
            System.out.println("Withdrawals Limit Exceeded");
            return false;
        }
        else {
            withdrawals++;
            accountBalance =  accountBalance - i;
            System.out.println("Updated Balance: " + accountBalance);
            System.out.println("Remaining Withdrawals: " + (3-withdrawals));
            return true;
        }
    }

    public int calcInterest() {
        int interestPerMonth = accountBalance * interestRate/100/12;
        return interestPerMonth;
    }

    public boolean addInterest() {
        if (BankApp.bank.isMonthEnd == true) {
            accountBalance += calcInterest();
            return true;
        }
        return false;
    }

    public String toString() {
        return "Savings | Balance: " + accountBalance + " | Withdrawals: " + withdrawals + " | Potential Interest: " + calcInterest();
    }

}