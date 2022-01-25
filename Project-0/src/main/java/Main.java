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


//
//    Persistence.Customer testCust = new Persistence.Customer("Tiffany","Obi");
//    Persistence.CustomerData custRepo = new Persistence.CustomerData();
//    Integer custID = custRepo.create(testCust);
//
//    CurrentUser currentUser = new CurrentUser(testCust.getFirstName());
//    testCust.setCustomerId(custID);
//    currentUser.setCustomerId(custID);
//
//    Persistence.BankAccount testAccount = new Persistence.BankAccount(100.00F);
//    testAccount.setCustomerId(custID);
//    Persistence.BankAccountData accountRepo = new Persistence.BankAccountData();
//    Integer bankAccountNum = accountRepo.create(testAccount);
//    currentUser.setAccountId(bankAccountNum);
//
//    testCust.setBankAccount(bankAccountNum);
//    System.out.println(testCust.getBankAccount());
//
//    if(testCust.getBankAccount() > 0){
//        custRepo.update(testCust);
//    } else {
//        System.out.println("There is no value here");
//    }




}
}
