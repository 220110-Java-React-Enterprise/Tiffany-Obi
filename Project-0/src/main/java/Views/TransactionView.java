package Views;

import Persistence.BankAccount;
import Persistence.BankAccountData;
import Persistence.Customer;
import Utils.CurrentUser;
import Utils.CustomArrayList;
import Views.View;
import Utils.ViewManager;

public class TransactionView extends View {

    public TransactionView(){
        viewName = "TransactionView";
        viewManager = ViewManager.getRenderer();
    }

    //here users are able to deposit or withdraw funds
    //from existing accounts
    //only can withdraw what they have
    //no negative balances

    @Override
    public void renderView() {

        System.out.println("KEEP YOUR ACCOUNT SAFE");
        System.out.println("****************************");
        System.out.println("****************************");
        System.out.println("****************************");
        System.out.println("DON'T SHARE YOUR ACCOUNT INFORMATION WITH ANYONE");



        if (CurrentUser.getTransactionType() == "deposit"){

            BankAccountData bankData = new BankAccountData();
            Customer customer = CurrentUser.getCurrentUser();

            CustomArrayList<BankAccount> accounts = bankData.getCustomerAccounts(customer.getCustomerId());
            CustomArrayList<Integer> accoundIds = new CustomArrayList<>();

            System.out.println("Choose The Account To Deposit Into");

            for(BankAccount account: accounts){
                accoundIds.add(account.getAccountNumber());
                System.out.println("Account Number: "+ account.getAccountNumber() +
                        "    Current Balance: " + "$" + String.format("%.2f",account.getCheckingBalance()));
            }

            System.out.println("Enter the account number");


            Integer accountNumber = viewManager.getScanner().nextInt();
            viewManager.getScanner().nextLine();

            while (!accoundIds.contains(accountNumber)){
                System.out.println("Sorry wrong account number! Please try again");
                accountNumber = viewManager.getScanner().nextInt();
                viewManager.getScanner().nextLine();
            }

            BankAccount selectedAccount = bankData.read(accountNumber);
            System.out.println("Balance:  $" + String.format("%.2f",selectedAccount.getCheckingBalance()));

            System.out.println("HOW MUCH WOULD YOU LIKE TO DEPOSIT?");
            Float deposit = viewManager.getScanner().nextFloat();
            viewManager.getScanner().nextLine();


            selectedAccount.deposit(deposit);

            bankData.update(selectedAccount);

            System.out.println("***********************************");
            System.out.println("************Depositing*************");
            System.out.println("***********************************");
            System.out.println("============= S U C C E S S ===========");

        viewManager.navigate("MainView");

        } else if (CurrentUser.getTransactionType() == "withdraw"){

            BankAccountData bankData = new BankAccountData();
            Customer customer = CurrentUser.getCurrentUser();

            CustomArrayList<BankAccount> accounts = bankData.getCustomerAccounts(customer.getCustomerId());
            CustomArrayList<Integer> accoundIds = new CustomArrayList<>();

            System.out.println("Choose The Account To Withdraw From");

            for(BankAccount account: accounts){
                accoundIds.add(account.getAccountNumber());
                System.out.println("Account Number: "+ account.getAccountNumber() +
                        "    Current Balance: " + "$" + String.format("%.2f",account.getCheckingBalance()));
            }

            System.out.println("Enter the account number");

            Integer accountNumber = viewManager.getScanner().nextInt();
            viewManager.getScanner().nextLine();

            while (!accoundIds.contains(accountNumber)){
                System.out.println("Sorry wrong account number! Please try again");
                accountNumber = viewManager.getScanner().nextInt();
                viewManager.getScanner().nextLine();
            }

            BankAccount selectedAccount = bankData.read(accountNumber);
            System.out.println("Balance:  $" + String.format("%.2f",selectedAccount.getCheckingBalance()));

            System.out.println("HOW MUCH WOULD YOU LIKE TO WITHDRAW?");
            Float withdraw = viewManager.getScanner().nextFloat();
            viewManager.getScanner().nextLine();



         while(!selectedAccount.withdraw(withdraw)) {

             System.out.println("INSUFFICIENT FUNDS! Try again\n\n");
             withdraw = viewManager.getScanner().nextFloat();
             viewManager.getScanner().nextLine();
         }

            bankData.update(selectedAccount);
            System.out.println("***********************************");
            System.out.println("************Withrawing*************");
            System.out.println("***********************************");
            System.out.println("============= S U C C E S S ===========");
            viewManager.navigate("MainView");

        } else {
            System.out.println("Something is not adding up");
            viewManager.quit();
        }


    }
}
