import org.example.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionRepositoryTest {
    private TransactionRepository transactionRepository;
    private Connection connect = mock(Connection.class);
    private PreparedStatement statement = mock(PreparedStatement.class);
    private ResultSet result = mock(ResultSet.class);

    @BeforeEach
    void setUp() {
        try {
            when(connect.prepareStatement(anyString())).thenReturn(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        transactionRepository = new TransactionRepository(connect);
    }

    @DisplayName("Testa se o registro transação retorna true")
    @Test
    void t1()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean result = transactionRepository.registerTransaction("21/09/2023",50,1,2);

        assertTrue(result);
    }

    @DisplayName("Testa se o exibir transações retorna true")
    @Test
    void t2()throws SQLException{
        when(statement.executeQuery()).thenReturn(result);
        when(result.getString("data")).thenReturn("Data da transação: 21/09/2023");
        when(result.getString("valor")).thenReturn("Valor transferido: R$50");
        when(result.getString("id_conta_origem")).thenReturn("Id de origem: 1");
        when(result.getString("id_conta_destino")).thenReturn("Id de destino: 2");

        boolean result = transactionRepository.showAllTransactionsofaSpecificAccount(1);

        assertTrue(result);
    }
}