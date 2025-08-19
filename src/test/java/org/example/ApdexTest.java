package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApdexTest {

    @Test
    public void calcularApdex() {
        // arrange
        Apdex apdex = new Apdex();

        // act
        double apdexBom = apdex.calcularApdex(90, 0, 100);

        // assert
        assertEquals(0.9, apdexBom, 0.01);
    }

    @Test
    public void validarApdexExcelente() {
        Apdex apdex = new Apdex();
        double valor = apdex.calcularApdex(95, 3, 100);
        assertTrue(valor >= 0.94 && valor <= 1,
                "Esperado Apdex Excelente entre 0.94 e 1");
    }

    @Test
    public void validarApdexBom() {
        Apdex apdex = new Apdex();
        double valor = apdex.calcularApdex(85, 0, 100);
        assertTrue(valor >= 0.85 && valor <= 0.93,
                "Esperado Apdex Bom entre 0.85 e 0.93");
    }

    @Test
    public void validarApdexRegular() {
        Apdex apdex = new Apdex();
        double valor = apdex.calcularApdex(70, 0, 100);
        assertTrue(valor >= 0.70 && valor <= 0.84,
                "Esperado Apdex Regular entre 0.70 e 0.84");
    }

    @Test
    public void validarApdexRuim() {
        Apdex apdex = new Apdex();
        double valor = apdex.calcularApdex(60, 0, 100);
        assertTrue(valor >= 0.50 && valor <= 0.69,
                "Esperado Apdex Ruim menor que 0.70");
    }

    @Test
    public void validarApdexInaceitavel() {
        Apdex apdex = new Apdex();
        double valor = apdex.calcularApdex(23, 0, 100);
        assertTrue(valor >= 0 && valor <= 0.49,
                "Esperado Apdex Inaceitável menor que 0.50");
    }
}
