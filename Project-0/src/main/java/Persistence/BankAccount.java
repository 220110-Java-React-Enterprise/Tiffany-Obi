package Persistence;

public class BankAccount {
    private Integer customerId;
    private Float checkingBalance = 0.0F;
    private Integer accountNumber;
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

    public void withdraw(Float withdraw) throws Exception {
        try {
            if (withdraw < checkingBalance) {
            checkingBalance += withdraw;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
