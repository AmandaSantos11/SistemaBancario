import org.example.controller.TransactionController;
import org.example.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionControllerTest {
    private TransactionRepository transactionRepository;
    private TransactionController transactionController;

    @BeforeEach
    public void setUp() {
        transactionRepository = mock(TransactionRepository.class);
        transactionController = new TransactionController(transactionRepository);
    }

    @DisplayName("Testa se o registrar transação retorna true")
    @Test
    void t1(){
        when(transactionRepository.registerTransaction("20/09/2023",40.00,1,2)
        ).thenReturn(true);

        boolean result = transactionController.registerTransaction("20/09/2023",40.00,1,2);

        assertTrue(result);
    }

    @DisplayName("Testa se o registrar transação retorna false")
    @Test
    void t2(){
        when(transactionRepository.registerTransaction("29/02/2023",10.00,3,2)
        ).thenReturn(false);

        boolean result = transactionController.registerTransaction("20/09/2023",10.00,3,2);

        assertFalse(result);
    }

    @DisplayName("Testa se mostrar transações de uma conta retorna true")
    @Test
    void t3() {
     when(transactionRepository.showAllTransactionsofaSpecificAccount(2)).thenReturn(true);

     boolean result = transactionController.showAllTransactionsofaSpecificAccount(2);

     assertTrue(result);
    }
}