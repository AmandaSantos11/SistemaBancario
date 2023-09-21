package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class ClientRepository {
    public ClientRepository(){}
    public ClientRepository(Connection connection){
        this.connection = connection;
    }
    static Connection connection = connect();
    public boolean registerClient(String name,String cpf,String address){
        String sql= "INSERT INTO cliente (nome,cpf,endereco) VALUES (?,?,?) ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, cpf);
            statement.setString(3, address);
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteClient(String cpf){
        String sql = "DELETE FROM cliente WHERE cpf = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean login(String cpf){
        String sql= "SELECT * FROM cliente WHERE cpf = ? ";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);

            ResultSet result = statement.executeQuery();
            if (result.next()){
                return true;
            }

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}