package org.example;

public class Apdex {

    public double calcularApdex(int s, int to, int ta) {
        if (ta == 0) return 0;



        return (s + (to / 2.0)) / ta;
    }
}
