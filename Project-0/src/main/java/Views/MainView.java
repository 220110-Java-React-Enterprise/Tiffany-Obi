package Views;

import Persistence.Customer;
import Utils.CurrentUser;
import Views.View;
import Utils.ViewManager;

public class MainView extends View {

    public MainView(){
        viewName = "MainView";
        viewManager = ViewManager.getRenderer();
    }

    @Override
    public void renderView() {

        System.out.println("======= M A I N   V I E W =======");
        System.out.println("  HOW CAN WE HELP YOU TODAY? ");
        System.out.println(
                "1) Open a New Account \n" +
                "2) Make a deposit into existing account \n" +
                "3) Withdraw funds from existing \n"
                        );

        Customer currentUser = CurrentUser.getCurrentUser();

        String selection = viewManager.getScanner().nextLine();


        switch (selection) {
            case "1":
                System.out.println("create new account view was selected");
                viewManager.navigate("CreateAccountView");
                break;

            case "2":
                CurrentUser.setTransactionType("deposit");
                System.out.println(CurrentUser.getTransactionType());

                viewManager.navigate("TransactionView");
                break;

            case "3":
                CurrentUser.setTransactionType("withdraw");
                viewManager.navigate("TransactionView");
                break;


            default:
                System.out.println("Sorry invalid selection");
        }






        viewManager.quit();

    }
}
