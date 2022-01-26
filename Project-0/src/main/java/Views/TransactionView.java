package Views;

import Utils.CurrentUser;
import Views.View;
import Utils.ViewManager;

public class TransactionView extends View {

    public TransactionView(){
        viewName = "TransactionView";
        viewManager = ViewManager.getRenderer();
    }
    @Override
    public void renderView() {

        System.out.println("we are here to make a " + CurrentUser.getTransactionType());


        viewManager.quit();
//
//        if (CurrentUser.getTransactionType() == "deposit"){
//            System.out.println("Deposit logic");
//            viewManager.quit();
//        } else if (CurrentUser.getTransactionType() == "withdraw"){
//            System.out.println("Withdraw logic");
//            viewManager.quit();
//        } else {
//            System.out.println("Something is not adding up");
//            viewManager.quit();
//        }


    }
}
