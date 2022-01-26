package Persistence;

import Persistence.BankAccount;
import Persistence.DataSourceCRUD;
import Utils.ConnectionManager;
import Utils.CustomArrayList;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BankAccountData implements DataSourceCRUD<BankAccount> {
    private Connection connection;

    public BankAccountData() {
        connection = ConnectionManager.getConnection();
    }


    @Override
    public Integer create(BankAccount bankAccount) {
        try {
            String sql = "INSERT INTO accounts (customer_id, balance) VALUES(?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, bankAccount.getCustomerId());
            BigDecimal accountBalance = new BigDecimal(bankAccount.getCheckingBalance());
            pstmt.setBigDecimal(2, accountBalance);

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public BankAccount read(Integer id) {
        try {
            String sql = "SELECT * FROM accounts WHERE account_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();
            BankAccount account = new BankAccount();

            while (rs.next()){
                account.setCheckingBalance(rs.getFloat("balance"));
                account.setAccountId(rs.getInt("account_id"));
            }
            return account;

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        try {
            String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            BigDecimal accountBalance = new BigDecimal(bankAccount.getCheckingBalance());
            pstmt.setBigDecimal(1, accountBalance);
            pstmt.setInt(2,bankAccount.getAccountNumber());

            pstmt.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }

        return bankAccount;
    }

    @Override
    public void delete(Integer id) {

    }

    public CustomArrayList<BankAccount> getCustomerAccounts(Integer customerId) {
        try {
            String sql = "SELECT * FROM accounts WHERE customer_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, customerId);

            ResultSet rs = pstmt.executeQuery();
            CustomArrayList<BankAccount> allAccounts = new CustomArrayList<>();

            while (rs.next()) {
                BankAccount account = new BankAccount(rs.getInt("customer_id"),
                        rs.getFloat("balance"),
                        rs.getInt("account_id"));
                allAccounts.add(account);
            }
            return allAccounts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
