package Persistence;

import Utils.CustomArrayList;

public class BankAccount {
    private Integer customerId;
    private Float checkingBalance = 0.0F;
    private Integer accountNumber;


//    private CustomArrayList<Integer> accounts = new CustomArrayList<>();
//    Float savingsAccount;

    public BankAccount(){
    }

    public BankAccount(Float initialDeposit) {
        this.checkingBalance = initialDeposit;
    }

    public BankAccount(Integer customerId, Float accountBalance, Integer accountNumber){
        this.customerId = customerId;
        this.checkingBalance = accountBalance;
        this.accountNumber = accountNumber;
    }
    public BankAccount(Integer customerId, Float initialDeposit){
        this.customerId = customerId;
        this.checkingBalance = initialDeposit;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getCustomerId(){
        return customerId;
    }
    public void setAccountId(Integer accountNumber){
        this.accountNumber = accountNumber;
    }

    public Integer getAccountNumber(){
        return this.accountNumber;
    }
    public Float getCheckingBalance() {

        return checkingBalance;
    }

    public void setCheckingBalance(Float checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public void deposit(Float deposit) {

        this.checkingBalance += deposit;
    }

    public boolean withdraw(Float withdraw){
        if (withdraw <= checkingBalance) {
            checkingBalance -= withdraw;
            return true;
            } else {
            return false;
        }

    }


}
