package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    Cliente xuxa;
    Cliente silvioSantos;

    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa", "12346578900", "11111");
        silvioSantos = new Cliente("Silvio Santos", "00987654321", "22222");

        contaXuxa = new Conta("0025", "2254", 2500.00, xuxa);
        contaSilvio = new Conta("0026", "2251", 3500.00, silvioSantos);
    }

    @Test
    public void realizarTransacao() {
        contaXuxa.realizarTransferencia(1000, contaSilvio);
        assertEquals(1500.00, contaXuxa.getSaldo());
        assertEquals(4500.00, contaSilvio.getSaldo());
    }

    @Test
    public void validarTransferenciaInvalida() {
        boolean resultado = contaXuxa.realizarTransferencia(3500.00, contaSilvio);
        assertFalse(resultado);
    }

    @Test
    public void validarInformacoesConta() {
        Cliente mariazinha = new Cliente("Mariazinha", "12346578900", "11111");
        Conta contaMariazinha = new Conta("0001", "1x5x", 1000.00, mariazinha);

        assertEquals(contaMariazinha.getAgencia(), "0001");
        assertEquals(contaMariazinha.getNumeroConta(), "1x5x");
        assertEquals(contaMariazinha.getSaldo(), 1000.00);
        assertEquals(contaMariazinha.getProprietario(), mariazinha);
    }

}