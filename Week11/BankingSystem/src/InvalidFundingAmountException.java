public class InvalidFundingAmountException extends BankException {
    /**
     * Invalid Funding Amount Exception.
     * @param amount given amount
     */
    public InvalidFundingAmountException(double amount) {
        super("Số dư tài khoản không đủ $"
                + String.format("%.2f", amount)
                + " để thực hiện giao dịch");
    }
}