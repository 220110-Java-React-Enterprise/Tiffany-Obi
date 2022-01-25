package Persistence;

public class Customer {
   private Integer bankAccountNumber;
   private String firstName;
   private String lastName;
   private Integer customerId;
   private String username;
   private String password;
   private String email;

   public Customer(){

   }

   public Customer(String firstName, String lastName,String username, String email, String password ){
       this.firstName = firstName;
       this.lastName = lastName;
       this.username = username;
       this.email = email;
       this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
