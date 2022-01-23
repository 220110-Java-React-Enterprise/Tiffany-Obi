public class BankAccount {

    private Float checkingBalance = 0.0F;
    private String accountNumber;
//    Float savingsAccount;

    public BankAccount(String accountNumber, Float initialDeposit) {
        this.accountNumber = accountNumber;
        this.checkingBalance = initialDeposit;
    }

    public String getAccountNumber(){
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
