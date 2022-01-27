package Views;

import Persistence.BankAccount;
import Persistence.BankAccountData;
import Persistence.Customer;
import Persistence.CustomerData;
import Utils.AuthClass;
import Utils.CurrentUser;
import Utils.ViewManager;



public class RegistrationView extends View{

    public RegistrationView(){
        viewName = "RegistrationView";
        viewManager = ViewManager.getRenderer();
    }

    AuthClass auth = new AuthClass();

    //here a new user is able to create a new account and input info
    //we are authenticating emails and names
    //creating a bank account with and without funds

    @Override
    public void renderView() {
        System.out.println("==== Please enter your email ====");
        String email = viewManager.getScanner().nextLine();

        if(!auth.authenticateEmail(email)){
            System.out.println("###Sorry Invalid Email###");
            System.out.println("==== Please enter your email ====");
            email = viewManager.getScanner().nextLine();
        }


        System.out.println("==== Please choose a password ====");
        String password = viewManager.getScanner().nextLine();

        System.out.println("=== Enter Your First Name === ");
        String firstName = viewManager.getScanner().nextLine();

        if (!auth.authenticateName(firstName)){
            System.out.println("###Save the special characters for your unique username###");
            System.out.println("=== Enter Your First Name === ");
            firstName = viewManager.getScanner().nextLine();
        }

        System.out.println("=== Enter Your Last Name ===");
        String lastName = viewManager.getScanner().nextLine();

        if (!auth.authenticateName(lastName)){
            System.out.println("###Save the special characters for your unique username###");
            System.out.println("=== Enter Your Last Name === ");
            lastName = viewManager.getScanner().nextLine();
        }

        System.out.println("=== Awesome! Almost Done! Choose A Unique Username===");
        String username = viewManager.getScanner().nextLine();

        Customer customer = new Customer(firstName,lastName,username,email,password);
        CustomerData custData = new CustomerData();
        Integer customerID = custData.create(customer);
        customer.setCustomerId(customerID);

        System.out.println("=== ALL SET! Please add a deposit to activate your account! ===");
        System.out.println("=== Or enter \"0\" to set up your account later ===");

        Float initialDeposit = viewManager.getScanner().nextFloat();
        viewManager.getScanner().nextLine();


        while (initialDeposit < 0) {

            System.out.println(" Invalid Amount! Let's try this again...");

           initialDeposit = viewManager.getScanner().nextFloat();
            viewManager.getScanner().nextLine();

        }


            BankAccount bankAccount = new BankAccount(initialDeposit);
            bankAccount.setCustomerId(customerID);
            BankAccountData bankData = new BankAccountData();
            Integer accountId = bankData.create(bankAccount);

            customer.setBankAccount(accountId);
            custData.update(customer);

            CurrentUser.setCurrentUser(customer);

            viewManager.navigate("MainView");
        }


    }
