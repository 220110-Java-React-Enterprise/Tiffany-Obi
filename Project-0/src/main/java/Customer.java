public class Customer {
   private String bankAccountNumber;
   private String firstName;
   private String lastName;
   private String customerId;
   private String username;

//   public Customer(){
//       this.bankAccountNumber = "0001";
//       this.firstName = "Customer 1";
//       this.lastName = "Temp Customer";
//       this.customerId = "01";
//
//   }

   public Customer(String firstName,String lastName,String customerId,String accountNumber){
       this.bankAccountNumber = accountNumber;
       this.firstName = firstName;
       this.lastName = lastName;
       this.customerId = customerId;
   }

    public String getBankAccount() {
        return bankAccountNumber;
    }

    public void setBankAccount( String bankAccountNumber) {

       this.bankAccountNumber = bankAccountNumber;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {

       this.customerId = customerId;
    }
}
