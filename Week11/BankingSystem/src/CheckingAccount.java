public class CheckingAccount extends Account {

    /**
     * Constructor with given value.
     * @param accountNumber given account number
     * @param balance given balance
     */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Override the abstract method in class Account.
     * @param amount given amount to withdraw
     */
    @Override
    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
        } catch (InsufficientFundsException 
        | InvalidFundingAmountException error) {
            error.printStackTrace();
        }
    }

    /**
     * Override the abstract method in class Account.
     * @param amount given amount to deposit
     */
    @Override
    public void deposit(double amount) {
        try {
            doDepositing(amount);
        } catch (InsufficientFundsException 
        | InvalidFundingAmountException error) {
            error.printStackTrace();
        }
    }
}
