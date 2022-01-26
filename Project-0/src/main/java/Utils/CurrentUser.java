package Utils;

import Persistence.Customer;

public class CurrentUser {
    private static Customer currentUser;
    private static String transactionType;
//    public static Integer customerId;
//    public static Integer accountId;
//    public static String username;



    public CurrentUser(){

    }

    public static Customer getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Customer currentUser) {
        CurrentUser.currentUser = currentUser;
    }

    public static String getTransactionType() {
        return transactionType;
    }

    public static void setTransactionType(String transactionType) {
        CurrentUser.transactionType = transactionType;
    }
    //    public CurrentUser(String username){
//        this.username = username;
//    }
//
//    public Integer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Integer customerId) {
//        this.customerId = customerId;
//    }
//
//    public Integer getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(Integer accountId) {
//        this.accountId = accountId;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
}
