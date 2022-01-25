package Views;

import Persistence.BankAccount;
import Persistence.BankAccountData;
import Persistence.Customer;
import Persistence.CustomerData;
import Utils.ViewManager;

public class RegistrationView extends View{

    public RegistrationView(){
        viewName = "RegistrationView";
        viewManager = ViewManager.getRenderer();
    }



    @Override
    public void renderView() {
        System.out.println("==== Please enter your email ====");
        String email = viewManager.getScanner().nextLine();

        System.out.println("==== Please choose a password ====");
        String password = viewManager.getScanner().nextLine();

        System.out.println("=== Enter Your First Name === ");
        String firstName = viewManager.getScanner().nextLine();

        System.out.println("=== Enter Your Last Name ===");
        String lastName = viewManager.getScanner().nextLine();

        System.out.println("=== Awesome! Almost Done! Choose A Unique Username===");
        String username = viewManager.getScanner().nextLine();

        Customer customer = new Customer(firstName,lastName,username,email,password);
        CustomerData custData = new CustomerData();
        Integer customerID = custData.create(customer);
        customer.setCustomerId(customerID);

        System.out.println("=== ALL SET! Please add a deposit to activate your account! ===");
        System.out.println("=== Or enter 7 to set up your account later ===");

        Integer initialDeposit = viewManager.getScanner().nextInt();


        switch (initialDeposit) {

            case 7:
                viewManager.navigate("LoginView");
                break;

            default:
                BankAccount bankAccount = new BankAccount(initialDeposit.floatValue());
                bankAccount.setCustomerId(customerID);
                BankAccountData bankData = new BankAccountData();
                Integer accountId = bankData.create(bankAccount);

                customer.setBankAccount(accountId);
                custData.update(customer);

                viewManager.navigate("MainView");
                break;
        }


    }
}
