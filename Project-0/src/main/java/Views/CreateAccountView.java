package Views;

import Persistence.BankAccount;
import Persistence.BankAccountData;
import Persistence.Customer;
import Persistence.CustomerData;
import Utils.CurrentUser;
import Utils.ViewManager;

public class CreateAccountView extends View{

    public CreateAccountView(){
        viewName = "CreateAccountView";
        viewManager = ViewManager.getRenderer();
    }

    @Override
    public void renderView() {

        System.out.println("=== ALL SET! Please add a deposit to activate your account! ===");
        Float initialDeposit = viewManager.getScanner().nextFloat();
        viewManager.getScanner().nextLine();

        Customer currentUser = CurrentUser.getCurrentUser();

        System.out.println(currentUser.getCustomerId());

        BankAccount newAccount = new BankAccount(currentUser.getCustomerId(),initialDeposit);
        BankAccountData accountData = new BankAccountData();
        Integer newAccountNum = accountData.create(newAccount);
        System.out.println(newAccountNum);

        System.out.println("==== AWESOME !! YOUR ACCOUNT IS CREATED ====");
        System.out.println("****************************");
        System.out.println("****************************");
        System.out.println("****************************");
        System.out.println("  HOW CAN WE HELP YOU TODAY? ");
        System.out.println(
                        "1) Deposit Funds \n" +
                        "2) Withdraw Funds \n" +
                        "3) Quit \n"
        );



        String selection2 = viewManager.getScanner().nextLine();


        switch (selection2) {
            case "1":
                CurrentUser.setTransactionType("deposit");
                viewManager.navigate("TransactionView");
                break;
            case "2":
                CurrentUser.setTransactionType("withdraw");
                viewManager.navigate("TransactionView");
                break;
            case  "3":
                System.out.println("***************************************");
                System.out.println("**************Logging Out**************");
                System.out.println("***************************************");

                System.out.println("========== HAVE A GREAT DAY! ==========");
                viewManager.quit();
                break;

            default:
                System.out.println("Sorry invalid selection. SOMETHING IS WRONG");

        }

    }
}
