import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Customer> customerList = new ArrayList<Customer>();

    /**
     * Read information of customers from txt file.
     * @param inputStream stream of txt file
     */
    public void readCustomerList(InputStream inputStream) {
        InputStreamReader stream = new InputStreamReader(inputStream);
        BufferedReader read = new BufferedReader(stream);
        int input = 0;
        String text = "";

        while (input != -1) {
            try {
                input = read.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            text += (char) input;
        }
        text = text.substring(0, text.length() - 2);
        //tach chuoi thanh cac chuoi con khi gap dau xuong dong
        String[] infos = text.split("\\n");
        Customer profile = null;
        for (int i = 0; i < infos.length; i++) {
            String information = infos[i];
            information = information.trim();
            
            //doc dong tai khoan bat dau bang stk
            if (information.charAt(0) >= '0'
            && information.charAt(0) <= '9') {
                //tach thanh cac chuoi con cach nhau boi khoang trang
                String []w = information.split("\\s+");
                long id = Long.parseLong(w[0]);
                double balance = Double.parseDouble(w[2]);
                assert profile != null;
                if (w[1].equals("CHECKING")) {
                    profile.addAccount(new CheckingAccount(id, balance));
                } else if (w[1].equals("SAVINGS")) {
                    profile.addAccount(new SavingsAccount(id, balance));
                }
            } else { //doc dong co ten + cmnd
                //tach thanh cac chuoi con cach nhau boi khoang trang
                String []w = information.split("\\s+"); 
                long id = Long.parseLong(w[w.length - 1].trim());
                String name = information.replace(w[w.length - 1], "");
                name = name.trim();
                profile = new Customer(id, name);
                customerList.add(profile);
            }
        }
    }


    /**
     * Get the report of Customers info by name order.
     * @return the report of Customers info by name order
     */
    public String getCustomersInfoByNameOrder() {
        //sap xep lai list theo thu tu tang dan theo ten: Selection sort
        for (int i = 0; i < customerList.size() - 1; i++) {
            for (int j = i + 1; j < customerList.size(); j++) {
                String ipos = customerList.get(i).getFullName();
                String jpos = customerList.get(j).getFullName();
                if (ipos.compareTo(jpos) > 0) {
                    //doi cho
                    Customer tmp = customerList.get(i);
                    customerList.set(i, customerList.get(j));
                    customerList.set(j, tmp);
                }
            }
        }

        String report = "";
        for (int i = 0; i < customerList.size() - 1; i++) {
            report += customerList.get(i).getCustomerInfo();
            report += "\n";
        }
        report += customerList.get(customerList.size() - 1)
                .getCustomerInfo();
        return report;
    }

    /**
     * Get the report of Customers info by id order.
     * @return the report of Customers info by id order
     */
    public String getCustomersInfoByIdOrder() {
        //sap xep lai list theo thu tu tang dan theo ten: Selection sort
        for (int i = 0; i < customerList.size() - 1; i++) {
            for (int j = i + 1; j < customerList.size(); j++) {
                long ipos = customerList.get(i).getIdNumber();
                long jpos = customerList.get(j).getIdNumber();
                if (ipos > jpos) {
                    //doi cho
                    Customer tmp = customerList.get(i);
                    customerList.set(i, customerList.get(j));
                    customerList.set(j, tmp);
                }
            }
        }

        String report = "";
        for (int i = 0; i < customerList.size() - 1; i++) {
            report += customerList.get(i).getCustomerInfo();
            report += "\n";
        }
        report += customerList.get(customerList.size() - 1)
                .getCustomerInfo();
        return report;

    }

    /**
     * Get customer list.
     * @return customer list
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }
}
