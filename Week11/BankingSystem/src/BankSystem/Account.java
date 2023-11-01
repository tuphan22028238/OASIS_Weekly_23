import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";

    public Account() {

    }

    /**
     * Constructor with given param.
     * @param accountNumber account number
     * @param balance balance in account
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Do with drawing money action.
     * @param amount amount of drawing
     * @throws InsufficientFundsException Insufficient Funds Exception
     * @throws InvalidFundingAmountException Invalid Funding Amount Exception
     */
    public void doWithdrawing(double amount)
            throws
            InsufficientFundsException,
            InvalidFundingAmountException {
        if (amount < 0) {
            throw new
                    InsufficientFundsException(amount);
        } 
        if (balance - amount < 0) {
            throw new
                    InvalidFundingAmountException(amount);
        }
        if (this instanceof SavingsAccount) {
            if (balance - amount < 5000) {
                throw new
                        InvalidFundingAmountException(amount);
            }
            if (amount > 1000) {
                throw new InsufficientFundsException(amount);
            }
        }
        Transaction transaction
                = new Transaction(amount, balance, balance - amount);
        transactionList.add(transaction);
        if (this instanceof CheckingAccount) {
            transaction.type
                    = Transaction.TYPE_WITHDRAW_CHECKING;
        } else {
            transaction.type
                    = Transaction.TYPE_WITHDRAW_SAVINGS;
        }
        balance = balance - amount;
    }

    /**
     * Handle depositing action.
     * @param amount amount of money to deposit
     * @throws InvalidFundingAmountException InvalidFundingAmountException
     * @throws InsufficientFundsException InsufficientFundsException
     */
    public void doDepositing(double amount)
            throws
            InvalidFundingAmountException,
            InsufficientFundsException {
        if (amount < 0) {
            throw new InsufficientFundsException(amount);
        }
        Transaction transaction
                = new Transaction(amount, balance, balance + amount);
        transactionList.add(transaction);
        if (this instanceof CheckingAccount) {
            transaction.type
                    = Transaction.TYPE_DEPOSIT_CHECKING;
        } else {
            transaction.type
                    = Transaction.TYPE_DEPOSIT_SAVINGS;
        }
        balance = balance + amount;
    }

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    /**
     * Get transaction history.
     * @return transaction history
     */
    public String getTransactionHistory() {
        String historyTransaction = "";
        historyTransaction += "Lịch sử giao dịch của tài khoản ";
        historyTransaction += this.accountNumber;
        historyTransaction += ":\n";
        for (Transaction x: transactionList) {
            historyTransaction += x.getTransactionSummary();
            historyTransaction += "\n";
        }
        return historyTransaction;
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * Tesst whether given object is equal to this account.
     * @param obj given object
     * @return true if obj is equal to this account, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof  Account)) {
            return false;
        }
        Account account = (Account) obj;
        return (account.getAccountNumber()
                == this.accountNumber);
    }
}
