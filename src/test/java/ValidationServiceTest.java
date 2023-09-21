import org.example.service.ValidationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationServiceTest {
    ValidationService validationService;

    @BeforeEach
    void setUp() {
        validationService =  new ValidationService();
    }

    @DisplayName("Testa CPF válido")
    @Test
    void t1() {
        assertTrue(validationService.validateCpf("12345678901"));
    }

    @DisplayName("Testa CPF inválido com letras")
    @Test
    void t2() {
        assertFalse(validationService.validateCpf("123a5678l01"));
    }

    @DisplayName("Testa CPF inválido em branco")
    @Test
    void t3() {
        assertFalse(validationService.validateCpf(""));
    }

    @DisplayName("Testa CPF inválido com caracter especial")
    @Test
    void t4() {
        assertFalse(validationService.validateCpf("123.456.789.10"));
    }

    @DisplayName("Testa CPF inválido com mais de 11 digitos")
    @Test
    void t5() {
        assertFalse(validationService.validateCpf("123456789001"));
    }

    @DisplayName("Testa NOME válido")
    @Test
    void t11() {
        assertTrue(validationService.validateName("amanda"));
    }

    @DisplayName("Testa NOME inválido com números")
    @Test
    void t12() {
        assertFalse(validationService.validateName("aman2"));
    }

    @DisplayName("Testa NOME inválido em branco")
    @Test
    void t13() {
        assertFalse(validationService.validateName(""));
    }

    @DisplayName("Testa NOME inválido com menos de 3 caractere")
    @Test
    void t15() {
        assertFalse(validationService.validateName("aa"));
    }

    @DisplayName("Testa ENDEREÇO válido")
    @Test
    void t16() {
        assertTrue(validationService.validateAddress("rua joao,113"));
    }

    @DisplayName("Testa ENDEREÇO inválido com caractere especial")
    @Test
    void t17() {
        assertFalse(validationService.validateAddress("rua neves !@"));
    }
}