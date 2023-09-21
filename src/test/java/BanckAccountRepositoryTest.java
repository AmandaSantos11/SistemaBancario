import org.example.repository.BankAccountRepository;
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

public class BanckAccountRepositoryTest {
    private BankAccountRepository bankAccountRepository;
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
        bankAccountRepository = new BankAccountRepository(connect);
    }

    @DisplayName("Testa se o registro de conta retorna true")
    @Test
    void t1()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean result = bankAccountRepository.registerAccount("212100",150,1);

        assertTrue(result);
    }

    @DisplayName("Testa se o excluir conta retorna true")
    @Test
    void t2()throws SQLException{
        when(statement.executeUpdate()).thenReturn(1);

        boolean result = bankAccountRepository.deleteAccount("123456");

        assertTrue(result);
    }

    @DisplayName("Testa se o exibir saldo retorna true")
    @Test
    void t3()throws SQLException{
        when(statement.executeQuery()).thenReturn(result);
        when(result.getString("saldo")).thenReturn("Saldo: R$100");

        boolean result = bankAccountRepository.showBalance("111111");

        assertTrue(result);
    }

    @DisplayName("Testa se o exibir contas de um cliente retorna true")
    @Test
    void t4()throws SQLException{
        when(statement.executeQuery()).thenReturn(result);
        when(result.getString("numero_conta")).thenReturn("Número da conta: 100100");

        boolean result = bankAccountRepository.showClientAccounts(1);

        assertTrue(result);
    }
}