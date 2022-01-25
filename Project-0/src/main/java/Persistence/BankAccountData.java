package Persistence;

import Persistence.BankAccount;
import Persistence.DataSourceCRUD;
import Utils.ConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BankAccountData implements DataSourceCRUD<BankAccount> {
    private Connection connection;

    public BankAccountData(){
        connection = ConnectionManager.getConnection();
    }



    @Override
    public Integer create(BankAccount bankAccount) {
        try {
            String sql = "INSERT INTO accounts (customer_id, balance) VALUES(?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1,bankAccount.getCustomerId());
            BigDecimal accountBalance = new BigDecimal(bankAccount.getCheckingBalance());
            pstmt.setBigDecimal(2,accountBalance);

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);


        } catch (Exception e){
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public BankAccount read(Integer id) {
        return null;
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
