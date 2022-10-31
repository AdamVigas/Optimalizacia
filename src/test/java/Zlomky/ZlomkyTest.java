package Zlomky;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZlomkyTest {

    Zlomok prvyZlomok = new Zlomok(6,4);
    Zlomok druhyZlomok = new Zlomok(4,3);


    /**
     * Ocakavany vysledok pri scitani zlomku 34/12
     */
    @Test
    void add() {
        Zlomok ocakavanyVysledok = new Zlomok(34,12);
        Zlomok operacia = prvyZlomok.add(druhyZlomok);
        assertEquals(ocakavanyVysledok.toString(),operacia.toString());
    }


    /**
     * Ocakavany vysledok pri odctitani zlomku 2/12
     */
    @Test
    void sub() {
        Zlomok ocakavanyVysledok = new Zlomok(2,12);
        Zlomok operacia = prvyZlomok.sub(druhyZlomok);
        assertEquals(ocakavanyVysledok.toString(),operacia.toString());
    }

    /**
     * Ocakavany vysledok pri nasobeni zlomku 24/12
     */
    @Test
    void mult() {
        Zlomok ocakavanyVysledok = new Zlomok(24,12);
        Zlomok operacia = prvyZlomok.mult(druhyZlomok);
        assertEquals(ocakavanyVysledok.toString(),operacia.toString());
    }

    /**
     * Ocakavany vysledok pri deleni zlomku 18/16
     */
    @Test
    void div() {
        Zlomok ocakavanyVysledok = new Zlomok(18,16);
        Zlomok operacia = prvyZlomok.div(druhyZlomok);
        assertEquals(ocakavanyVysledok.toString(),operacia.toString());
    }
}