package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    void calcularApdex() {
        // arrange
        Apdex apdex = new Apdex();

        // act
        double score = apdex.calcularApdex(770, 60, 1000);

        // assert
        assertEquals(0.80, score, 0.001);
    }
}
