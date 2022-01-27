package Views;


import Persistence.BankAccountData;
import Persistence.Customer;
import Persistence.CustomerData;
import Utils.CurrentUser;
import Views.View;
import Utils.ViewManager;

public class LoginView extends View {

    public LoginView(){
        viewName = "LoginView";
        viewManager = ViewManager.getRenderer();
    }

    //In this view a user is able to login
    //with their unique username and password
    //we then set our Current user == to user that logs in
    @Override
    public void renderView() {
        System.out.println("==== HELLO! Please enter your username ====");
        String username = viewManager.getScanner().nextLine();

        System.out.println("====Please enter your password ====");
        String password = viewManager.getScanner().nextLine();

        CustomerData custData = new CustomerData();
        Customer customer = custData.checkLoginInfo(username,password);

        CurrentUser.setCurrentUser(customer);

        System.out.println("===== WELCOME" + " " + customer.getFirstName().toUpperCase() + " =====");
        System.out.println("");

        viewManager.navigate("MainView");
    }
}
