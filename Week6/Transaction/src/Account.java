import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<>();

    /**
     * Create deposit transaction.
     * @param amount amount of money to deposit
     */
    private void deposit(double amount) {
        if (amount > 0) {
            if (transitionList.isEmpty()) {
                Transaction newTransaction = new Transaction("deposit", amount, amount);
                transitionList.add(newTransaction);
            } else {
                Transaction newTransaction = new Transaction("deposit", amount,
                        transitionList.get(transitionList.size() - 1).getBalance() + amount);
                transitionList.add(newTransaction);
            }
        } else {
            System.out.println("So tien ban nap vao khong hop le!");
        }
    }

    /**
     * Create withdraw operation.
     * @param amount amount of money to withdraw
     */
    private void withdraw(double amount) {
        if (transitionList.isEmpty()) {
            System.out.println("So tien ban rut vuot qua so du!");
        } else if (amount > 0
                && amount < transitionList.get(transitionList.size() - 1).getBalance()) {
            Transaction newTransaction = new Transaction("withdraw", amount,
                    transitionList.get(transitionList.size() - 1).getBalance() - amount);
            transitionList.add(newTransaction);
        } else if (amount < 0) {
            System.out.println("So tien ban rut ra khong hop le!");
        } else {
            System.out.println("So tien ban rut vuot qua so du!");
        }
    }

    /**
     * Add transaction to the list.
     * @param amount amount of money for operation
     * @param operation operation deposit or withdraw
     */
    public void addTransaction(double amount, String operation) {
        if (operation.equals("deposit")) {
            deposit(amount);
        } else if (operation.equals("withdraw")) {
            withdraw(amount);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Print the transactions list.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            System.out.print("Giao dich " + (i + 1) + ": ");
            if (transitionList.get(i).getOperation().equals("deposit")) {
                System.out.print("Nap tien $");
                System.out.printf("%.2f",
                        (double) Math.round((transitionList.get(i).getAmount()) * 100) / 100);
            } else {
                System.out.printf("Rut tien $");
                System.out.printf("%.2f",
                        (double) Math.round((transitionList.get(i).getAmount()) * 100) / 100);
            }
            System.out.printf(". So du luc nay: $");
            System.out.printf("%.2f",
                    (double) Math.round((transitionList.get(i).getBalance()) * 100) / 100);
            System.out.println(".");
        }
    }
}
