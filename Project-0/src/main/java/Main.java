import Utils.ConnectionManager;
import Utils.ViewManager;
import Views.*;

import java.sql.Connection;

public class Main {
public static void main(String[] args){

    ViewManager viewManager = ViewManager.getRenderer();
    viewManager.registerView(new WelcomeView());
    viewManager.registerView(new RegistrationView());
    viewManager.registerView(new LoginView());
    viewManager.registerView(new MainView());
    viewManager.registerView(new CreateAccountView());
    viewManager.registerView(new AccountSummaryView());
    viewManager.registerView(new TransactionView());

    try {
        Connection  conn = ConnectionManager.getConnection();
        viewManager.navigate("WelcomeView");

        while(viewManager.isRunning()){
            viewManager.renderView();
        }
    } catch (Exception e){
        e.printStackTrace();
    }





}
}
