package Views;

import Persistence.BankAccount;
import Persistence.BankAccountData;
import Persistence.Customer;
import Utils.CurrentUser;
import Utils.CustomArrayList;
import Utils.ViewManager;

public class TransferFundsView extends View{

    public TransferFundsView(){
        viewName = "TransferFundsView";
        viewManager = ViewManager.getRenderer();
    }

    //users are able to transer funds between their accounds
    // no negative balances


    @Override
    public void renderView() {

        CustomArrayList<Integer> accoundIds = new CustomArrayList<>();

        BankAccountData bankData = new BankAccountData();
        Customer customer = CurrentUser.getCurrentUser();

        CustomArrayList<BankAccount> accounts = bankData.getCustomerAccounts(customer.getCustomerId());

        System.out.println("====== ACCOUNT SUMMARY ======");

        for(BankAccount account: accounts){
            accoundIds.add(account.getAccountNumber());
            System.out.println("Account Number: "+ account.getAccountNumber() +
                    "    Current Balance: " + "$" +String.format("%.2f",account.getCheckingBalance()));
        }

        System.out.println("Select Account to transfer FROM:");

        Integer from = viewManager.getScanner().nextInt();
        viewManager.getScanner().nextLine();

        while (!accoundIds.contains(from)){
            System.out.println("Sorry wrong account number! Please try again");
            from = viewManager.getScanner().nextInt();
            viewManager.getScanner().nextLine();
        }

        BankAccount fromAccount = bankData.read(from);
        System.out.println("Balance:  $" + String.format("%.2f",fromAccount.getCheckingBalance()));


        System.out.println("Select Account to transfer TO:");

        Integer to = viewManager.getScanner().nextInt();
        viewManager.getScanner().nextLine();

        while (!accoundIds.contains(to)){
            System.out.println("Sorry wrong account number! Please try again");
            to = viewManager.getScanner().nextInt();
            viewManager.getScanner().nextLine();
        }

        BankAccount toAccount = bankData.read(to);
        System.out.println("Balance:  $" + String.format("%.2f",toAccount.getCheckingBalance()));

        System.out.println("How Much Would You Like To Transfer?");

        Float transferAmount = viewManager.getScanner().nextFloat();
        viewManager.getScanner().nextLine();

        while(!fromAccount.withdraw(transferAmount)) {

            System.out.println("INSUFFICIENT FUNDS! Try again\n");
            transferAmount = viewManager.getScanner().nextFloat();
            viewManager.getScanner().nextLine();
        }

        bankData.update(fromAccount);
        toAccount.deposit(transferAmount);
        bankData.update(toAccount);

        System.out.println("=============================================");
        System.out.println("++++++++++++ TRANSFER SUCCESSFUL ++++++++++++");
        System.out.println("=============================================\n\n");


        viewManager.navigate("AccountSummaryView");









    }
}
