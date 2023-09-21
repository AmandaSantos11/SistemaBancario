import org.example.controller.BanckAccountController;
import org.example.repository.BankAccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BanckAccountControllerTest {
    private BankAccountRepository bankAccountRepository;
    private BanckAccountController bankAccountController;

    @BeforeEach
    public void setUp() {
        bankAccountRepository = mock(BankAccountRepository.class);
        bankAccountController = new BanckAccountController(bankAccountRepository);
    }

    @DisplayName("Testa se o registrar conta retorna true")
    @Test
    void t1(){
        when(bankAccountRepository.registerAccount("888888",1200.00,7)
        ).thenReturn(true);

        boolean result = bankAccountController.registerAccount("888888",1200.00,7);

        assertTrue(result);
    }

    @DisplayName("Testa se o deletar conta retorna true")
    @Test
    public void t2(){
        when(bankAccountRepository.deleteAccount("101010")).thenReturn(true);

        boolean result = bankAccountController.deleteAccount("101010");

        assertTrue(result);
    }

    @DisplayName("Testa se o mostrar saldo da conta retorna true")
    @Test
    public void t3(){
        when(bankAccountRepository.showBalance("101010")).thenReturn(true);

        boolean result = bankAccountController.showBalance("101010");

        assertTrue(result);
    }

    @DisplayName("Testa se o substrair saldo da conta retorna true")
    @Test
    void t4(){
        when(bankAccountRepository.subtractBalanceAccount(1,50)
        ).thenReturn(true);

        boolean result = bankAccountController.subtractBalanceAccount(1,50);

        assertTrue(result);
    }

    @DisplayName("Testa se o adicionar saldo da conta retorna true")
    @Test
    void t5(){
        when(bankAccountRepository.addBalanceAccount(2,150)
        ).thenReturn(true);

        boolean result = bankAccountController.addBalanceAccount(2,150);

        assertTrue(result);
    }

    @DisplayName("Testa se o mostrar contas do cliente retorna true")
    @Test
    public void t6(){
        when(bankAccountRepository.showClientAccounts(3)).thenReturn(true);

        boolean result = bankAccountController.showClientAccounts(3);

        assertTrue(result);
    }
}