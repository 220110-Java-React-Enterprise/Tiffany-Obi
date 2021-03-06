package Views;

import Persistence.BankAccount;
import Persistence.BankAccountData;
import Persistence.Customer;
import Utils.CurrentUser;
import Utils.CustomArrayList;
import Views.View;
import Utils.ViewManager;

public class MainView extends View {


    //here we give users different options to flow through the app

    public MainView(){
        viewName = "MainView";
        viewManager = ViewManager.getRenderer();
    }

    @Override
    public void renderView() {

        System.out.println("======= M A I N   M E N U =======");
        System.out.println("  HOW CAN WE HELP YOU TODAY? ");
        System.out.println(
                        "1) Open a New Account \n" + 
                        "2) View Accounts \n"+
                        "3) Make a Deposit into Existing Account \n" +
                        "4) Withdraw Funds from Existing Account \n" +
                                "5) Transfer Funds between Accounts \n" +
                                "6) Log Out \n"
                        );



        String selection2 = viewManager.getScanner().nextLine();


        switch (selection2) {
            case "1":

                viewManager.navigate("CreateAccountView");
                break;

            case "2":
               viewManager.navigate("AccountSummaryView");
               break;
            case "3":
                CurrentUser.setTransactionType("deposit");
                viewManager.navigate("TransactionView");
                break;

            case "4":
                CurrentUser.setTransactionType("withdraw");
                viewManager.navigate("TransactionView");
                break;


            case "5":
                viewManager.navigate("TransferFundsView");

                break;

            case "6":
                System.out.println("***************************************");
                System.out.println("*************Logging Out***************");
                System.out.println("======= HAVE A GREAT DAY =======");
                viewManager.quit();
                    break;
            default:
                System.out.println("Sorry invalid selection");
        }

    }
}
