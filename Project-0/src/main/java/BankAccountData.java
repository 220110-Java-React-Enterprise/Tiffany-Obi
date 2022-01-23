import java.math.BigDecimal;
import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BankAccountData implements DataSourceCRUD<BankAccount>{
    private Connection connection;

    public BankAccountData(){
        connection = ConnectionManager.getConnection();
    }



    @Override
    public BankAccount create(BankAccount bankAccount) {
        try {
            String sql = "INSERT INTO accounts (account_id, balance) VALUES(?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1,bankAccount.getAccountNumber());
            BigDecimal accountBalance = new BigDecimal(bankAccount.getCheckingBalance().toString());
            pstmt.setBigDecimal(2,accountBalance);

            pstmt.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        }

        return bankAccount;
    }

    @Override
    public BankAccount read(String id) {
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
