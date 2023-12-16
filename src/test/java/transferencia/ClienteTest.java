package transferencia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    public void validarInformacoesCliente() {
        Cliente mariazinha = new Cliente("Mariazinha", "12346578900", "11111");

        assertEquals(mariazinha.getNome(), "Mariazinha");
        assertEquals(mariazinha.getCPF(), "12346578900");
        assertEquals(mariazinha.getRG(), "11111");
    }
}