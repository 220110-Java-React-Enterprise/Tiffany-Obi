package Persistence;

import Persistence.Customer;
import Persistence.DataSourceCRUD;
import Utils.ConnectionManager;

import java.sql.*;

public class CustomerData implements DataSourceCRUD<Customer> {

    private Connection connection;

    public CustomerData() {
        connection = ConnectionManager.getConnection();
    }

    @Override
    public Integer create(Customer cust) {
        // here we are inserting into the customer table that we created in db
        try {
            String sql = "INSERT INTO customers (first_name, last_name, user_name, email, password) VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,cust.getFirstName());
            pstmt.setString(2,cust.getLastName());
            pstmt.setString(3,cust.getUsername());
            pstmt.setString(4, cust.getEmail());
            pstmt.setString(5, cust.getPassword());

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();

            return rs.getInt(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
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

        try {
            String sql = "UPDATE customers SET account_id = ? WHERE customer_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1,cust.getBankAccount());
            pstmt.setInt(2, cust.getCustomerId());

            pstmt.executeUpdate();
        } catch(Exception e){
            e.printStackTrace();
        }
    return cust;

    }

    @Override
    public void delete(Integer id) {

    }
}
