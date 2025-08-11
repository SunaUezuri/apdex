package org.example;

public class Apdex {

    public double calcularApdex(int satisfatorios, int toleraveis, int total) {
        if (total == 0) return 0;
        return (satisfatorios + (toleraveis / 2.0)) / total;
    }
}

