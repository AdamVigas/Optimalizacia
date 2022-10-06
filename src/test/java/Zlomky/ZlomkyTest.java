package Zlomky;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZlomkyTest {

    Zlomky prvyZlomok = new Zlomky(6,4);
    Zlomky druhyZlomok = new Zlomky(4,3);


    /**
     * Ocakavany vysledok pri scitani zlomku 34/12
     */
    @Test
    void add() {
        Zlomky ocakavanyVysledok = new Zlomky(34,12);
        Zlomky operacia = prvyZlomok.add(druhyZlomok);
        assertEquals(ocakavanyVysledok.toString(),operacia.toString());
    }


    /**
     * Ocakavany vysledok pri odctitani zlomku 2/12
     */
    @Test
    void sub() {
        Zlomky ocakavanyVysledok = new Zlomky(2,12);
        Zlomky operacia = prvyZlomok.sub(druhyZlomok);
        assertEquals(ocakavanyVysledok.toString(),operacia.toString());
    }

    /**
     * Ocakavany vysledok pri nasobeni zlomku 24/12
     */
    @Test
    void mult() {
        Zlomky ocakavanyVysledok = new Zlomky(24,12);
        Zlomky operacia = prvyZlomok.mult(druhyZlomok);
        assertEquals(ocakavanyVysledok.toString(),operacia.toString());
    }

    /**
     * Ocakavany vysledok pri deleni zlomku 18/16
     */
    @Test
    void div() {
        Zlomky ocakavanyVysledok = new Zlomky(18,16);
        Zlomky operacia = prvyZlomok.div(druhyZlomok);
        assertEquals(ocakavanyVysledok.toString(),operacia.toString());
    }
}