package Vektor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VektorTest {

    double[] xdata = { 1, 2, 3, 4 };
    double[] ydata = { 5, 2, 4, 1 };

    Vektor x = new Vektor(xdata);
    Vektor y = new Vektor(ydata);

    /**
     * Vynasobenie vektora konstantou
     */
    @Test
    void nasobenieKonstantou() {
        double[] pole = { 500, 200, 400, 100 };
        double konstanta = 100;
        Vektor ocakavanyVysledok = new Vektor(pole);
        Vektor operacia = y.vynasobenieKonstantou(konstanta);
        assertEquals(ocakavanyVysledok.toString(),operacia.toString());
    }

    /**
     * Vynasobenie vektora x * x a pouzitie odmocniny
     */
    @Test
    void magnituda() {
        assertEquals(5.477225575051661,x.magnituda());
    }

    /**
     * Scitanie dvoch vektorov
     */
    @Test
    void plus() {
        double[] pole = { 6, 4, 7, 5 };
        Vektor ocakavanyVysledok = new Vektor(pole);
        Vektor operacia = x.plus(y);
        assertEquals(ocakavanyVysledok.toString(),operacia.toString());
    }

    /**
     * Odcitanie dvoch vektorov
     */
    @Test
    void minus() {
        double[] pole = { -4, 0, -1, 3 };
        Vektor ocakavanyVysledok = new Vektor(pole);
        Vektor operacia = x.minus(y);
        assertEquals(ocakavanyVysledok.toString(),operacia.toString());
    }

    /**
     * Vynasobenie vektorov a scitanie
     */
    @Test
    void nasobenieVektorovAScitanie() {
        double ocakavanyVysledok = 25.0;
        double operacia = x.nasobenieVektorov(y);
        assertEquals(ocakavanyVysledok,operacia);
    }
}