
import Utils.ConnectionManager;

import java.sql.*;

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
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1,cust.getCustomerId());
            pstmt.setString(2,cust.getFirstName());
            pstmt.setString(3,cust.getLastName());
            pstmt.setInt(4, cust.getBankAccount());

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            rs.getInt(1);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer read(Integer id) {
    // reading from the table based on the customer id
        try {
            String sql = "SELECT * FROM customers WHERE customer_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            Customer customer = new Customer();

            while (rs.next()){
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setBankAccount(rs.getInt("account_id"));
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
