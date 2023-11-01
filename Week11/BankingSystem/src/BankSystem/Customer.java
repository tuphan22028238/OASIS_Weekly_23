import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private final List<Account> accountList = new ArrayList<>();

    public Customer() {
    }

    /**
     * Constructor with given param.
     * @param idNumber idNumber
     * @param fullName fullName
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     * Get customer info.
     * @return customer info
     */
    public String getCustomerInfo() {
        return "Số CMND: " + idNumber
                + ". "
                + "Họ tên: " + fullName
                + ".";
    }


    /**
     * Add an account.
     * @param account given account
     */
    public void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * Remove an account.
     * @param account account to be removed
     */
    public void removeAccount(Account account) {
        accountList.remove(account);
    }

}
