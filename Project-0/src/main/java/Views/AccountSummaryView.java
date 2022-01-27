package Views;

import Persistence.BankAccount;
import Persistence.BankAccountData;
import Persistence.Customer;
import Utils.CurrentUser;
import Utils.CustomArrayList;
import Utils.ViewManager;

public class AccountSummaryView extends View {

    public AccountSummaryView(){
        viewManager = ViewManager.getRenderer();
        viewName = "AccountSummaryView";
    }

    //we are retrieving the users accounts and displaying it to the console
    @Override
    public void renderView() {

        BankAccountData bankData = new BankAccountData();
        Customer customer = CurrentUser.getCurrentUser();

        CustomArrayList<BankAccount> accounts = bankData.getCustomerAccounts(customer.getCustomerId());

        System.out.println("====== ACCOUNT SUMMARY ======");

        for(BankAccount account: accounts){
            System.out.println("Account Number: "+ account.getAccountNumber() +
                    "    Current Balance: " + "$" +String.format("%.2f",account.getCheckingBalance()));
        }

        System.out.println("  HOW CAN WE HELP YOU TODAY? ");
        System.out.println(
                "1) Return to Main Menu\n"+
                        "2) Log Out \n"

        );

        String selection = viewManager.getScanner().nextLine();

        switch (selection){
            case "1":
                viewManager.navigate("MainView");
                break;
            case "2":

                System.out.println("***************************************");
                System.out.println("*************Logging Out***************");
                System.out.println("======= HAVE A GREAT DAY =======");


                viewManager.quit();
        }

    }
}
