package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class TransactionRepository {
    public TransactionRepository(){}
    public TransactionRepository(Connection connection){
        this.connection = connection;
    }
    static Connection connection = connect();
    public boolean registerTransaction(String date,double value,int id_origin_account,int id_destination_account){
        String sql= "INSERT INTO transacao (data,valor,id_conta_origem,id_conta_destino) VALUES (?,?,?,?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, date);
            statement.setDouble(2, value);
            statement.setInt(3, id_origin_account);
            statement.setInt(4, id_destination_account);
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean showAllTransactionsofaSpecificAccount(int id_origin_account){
        String sql = "SELECT * FROM transacao WHERE id_conta_origem = ? ";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_origin_account);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.println("Data da transação: " + result.getString("data"));
                System.out.println("Valor transferido: R$" + result.getString("valor"));
                System.out.println("Id de origem: " + result.getString("id_conta_origem"));
                System.out.println("Id de destino: " + result.getString("id_conta_destino"));
                System.out.println("------------------------");
            }

            statement.close();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}