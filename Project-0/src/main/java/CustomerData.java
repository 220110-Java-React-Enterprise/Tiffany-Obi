
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerData implements DataSourceCRUD<Customer> {

    private Connection connection;

    public CustomerData() {
        connection = ConnectionManager.getConnection();
    }

    @Override
    public Customer create(Customer cust) {
        // here we are inserting into the customer table that we created in db
        try {
            String sql = "INSERT INTO customers (customer_id, first_name, last_name, account_id) VALUES(?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1,cust.getCustomerId());
            pstmt.setString(2,cust.getFirstName());
            pstmt.setString(3,cust.getLastName());
            pstmt.setString(4, cust.getBankAccount());

            pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        return cust;
    }

    @Override
    public Customer read(String id) {
    // reading from the table based on the customer id
        try {
            String sql = "SELECT * FROM customers WHERE customer_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,id);

            ResultSet rs = pstmt.executeQuery();

            Customer customer = new Customer("","","","");

            while (rs.next()){
                customer.setCustomerId(rs.getString("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setBankAccount(rs.getString("account_id"));
            }

            return customer;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public Customer update(Customer cust) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
