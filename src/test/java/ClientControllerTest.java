import org.example.controller.ClientController;
import org.example.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientControllerTest {
    private ClientRepository clientRepository;
    private ClientController clientController;

    @BeforeEach
    public void setUp() {
        clientRepository = mock(ClientRepository.class);
        clientController = new ClientController(clientRepository);
    }

    @DisplayName("Testa se o registrar cliente retorna true")
    @Test
    void t1(){
        when(clientRepository.registerClient("Paulo","00000000000","Rua Padre Almeida")
        ).thenReturn(true);

        boolean result = clientController.registerClient("Paulo","00000000000","Rua Padre Almeida");

        assertTrue(result);
    }

    @DisplayName("Testa se o registrar cliente retorna false")
    @Test
    void t2(){
        when(clientRepository.registerClient("Lola","90909090900","Rua Padre Almeida")
        ).thenReturn(false);

        boolean result = clientController.registerClient("Lola","90909090900","Rua Padre Almeida");

        assertFalse(result);
    }

    @DisplayName("Testa se o deletar cliente retorna true")
    @Test
    public void t3(){
        when(clientRepository.deleteClient("10101010101")).thenReturn(true);

        boolean result = clientController.deleteClient("10101010101");

        assertTrue(result);
    }

    @DisplayName("Testa se o deletar cliente retorna false")
    @Test
    public void t4(){
        when(clientRepository.deleteClient("23423423423")).thenReturn(false);

        boolean result = clientController.deleteClient("23423423423");

        assertFalse(result);
    }

    @DisplayName("Testa se o login cliente retorna true")
    @Test
    void t5(){
        when(clientRepository.login("66666666666")).thenReturn(true);

        boolean result = clientController.login("66666666666");

        assertTrue(result);
    }
}