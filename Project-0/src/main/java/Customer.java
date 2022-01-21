public class Customer {
   private BankAccount bankAccount;
   private String firstName;
   private String lastName;
   private String socialSecurityNo;
   private String customerId;

   public Customer(){
       bankAccount.checkingAccount = Float.valueOf(0);
       bankAccount.savingsAccount = Float.valueOf(0);
       firstName = "Customer 1";
       lastName = "Temp Customer";
       socialSecurityNo = "0000001";
       customerId = "01";

   }

   public Customer(BankAccount account,String firstName,String lastName,String socialSecurityNo,String customerId){
       this.bankAccount = account;
       this.firstName = firstName;
       this.lastName = lastName;
       this.socialSecurityNo = socialSecurityNo;
       this.customerId = customerId;
   }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNo() {
        return socialSecurityNo;
    }

    public void setSocialSecurityNo(String socialSecurityNo) {
        this.socialSecurityNo = socialSecurityNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
