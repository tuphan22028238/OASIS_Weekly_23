public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;
    public int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * Constructor with given param.
     * @param amount amount
     * @param initialBalance initialBalance
     * @param finalBalance finalBalance
     */
    public Transaction(double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * Constructor with given param.
     * @param type type
     * @param amount amount
     * @param initialBalance initialBalance
     * @param finalBalance finalBalance
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * Get transaction type string.
     * @param type type
     * @return transaction type string
     */
    private String getTransactionTypeString(int type) {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING:
                return "Nạp tiền vãng lai";
            case TYPE_WITHDRAW_CHECKING:
                return "Rút tiền vãng lai";
            case TYPE_DEPOSIT_SAVINGS:
                return "Nạp tiền tiết kiệm";
            case TYPE_WITHDRAW_SAVINGS:
                return "Rút tiền tiết kiệm";
            default:
                return "";
        }
    }

    /**
     * Get transaction summary.
     * @return transaction summary
     */
    public String getTransactionSummary() {
        return "- Kiểu giao dịch: " + getTransactionTypeString(this.type)
                + ". Số dư ban đầu: $"  + String.format("%.2f", this.initialBalance)
                + ". Số tiền: $" +  String.format("%.2f", this.amount)
                + ". Số dư cuối: $" +  String.format("%.2f", this.finalBalance) + ".";
    }
}
