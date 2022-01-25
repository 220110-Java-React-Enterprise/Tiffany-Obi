public class Customer {
   private Integer bankAccountNumber;
   private String firstName;
   private String lastName;
   private Integer customerId;
   private String username;
   private  String password;

   public Customer(){

   }

   public Customer(String firstName, String lastName){

       this.firstName = firstName;
       this.lastName = lastName;
   }

    public Integer getBankAccount() {
        return bankAccountNumber;
    }

    public void setBankAccount(Integer bankAccountNumber) {

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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {

       this.customerId = customerId;
    }
}
