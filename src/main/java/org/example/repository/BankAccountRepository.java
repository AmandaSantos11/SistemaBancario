package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class BankAccountRepository {
    static Connection connection = connect();
    public BankAccountRepository(){}
    public BankAccountRepository(Connection connection){
        this.connection = connection;
    }
    public boolean registerAccount(String number_account,double balance,int id_client){
        String sql= "INSERT INTO conta_bancaria (numero_conta,saldo,id_cliente) VALUES (?,?,?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, number_account);
            statement.setDouble(2, balance);
            statement.setInt(3, id_client);
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteAccount(String number_account){
        String sql = "DELETE FROM conta_bancaria WHERE numero_conta = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, number_account);
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean showBalance(String number_account){
        String sql = "SELECT saldo FROM conta_bancaria WHERE numero_conta = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,number_account);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                System.out.println("Saldo: R$"+result.getDouble("saldo"));
            }

            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean subtractBalanceAccount(int id_account_bank,double value){
        String SQL = "UPDATE conta_bancaria SET saldo = saldo - ? WHERE id_conta_bancaria = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setDouble(1,value);
            statement.setInt(2,id_account_bank);
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
    public boolean addBalanceAccount(int id_account_bank,double value){
        String SQL = "UPDATE conta_bancaria SET saldo = saldo + ? WHERE id_conta_bancaria = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(SQL);
            statement.setDouble(1,value);
            statement.setInt(2,id_account_bank);
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }
    public boolean showClientAccounts(int id_cliente){
        String sql = "SELECT numero_conta FROM conta_bancaria WHERE id_cliente = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id_cliente);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                System.out.println("Número da conta: "+result.getString("numero_conta"));
            }

            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}