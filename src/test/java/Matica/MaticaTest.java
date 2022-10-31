package Matica;

import Vektor.Vektor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class MaticaTest {
    double [][] MATICA_POLE = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
            };

    double [] VEKTOR_POLE = {2,2,2};
    SimpleMatrix MATICA_TEST = new SimpleMatrix(MATICA_POLE);
    Vektor VEKTOR_TEST = new Vektor(VEKTOR_POLE);

    /**
     * Testovanie nasobenia : Matica x Vektor
     */
    @Test
    void nasobenieMaticaVektor() {
        double[][] OCAKAVANE_POLE = {
                {2,4,6},
                {8,10,12},
                {14,16,18}
        };
        //inicializacia matice s polom
        SimpleMatrix OCAKAVANY_VYSLEDOK = new SimpleMatrix(OCAKAVANE_POLE);
        //operacia
        MATICA_TEST.nasobenieMaticaVektor(VEKTOR_TEST);
        Arrays.deepEquals(OCAKAVANY_VYSLEDOK.getPole(), MATICA_TEST.getPole());
    }

    /**
     * Vynasobenie matice konstantou - v tomto pripade cislom 100
     */
    @Test
    void vynasobenieMaticeKonstantou() {
        double[][] OCAKAVANE_POLE = {
                {100,200,300},
                {400,500,600},
                {700,800,900}
        };
        //inicializacia matice s polom
        SimpleMatrix OCAKAVANY_VYSLEDOK = new SimpleMatrix(OCAKAVANE_POLE);
        //inicializacia konstanty
        int konstanta = 100;
        //operacia
        MATICA_TEST.vynasobenieMaticeKonstantou(konstanta);
        Arrays.deepEquals(OCAKAVANY_VYSLEDOK.getPole(), MATICA_TEST.getPole());
    }

    /**
     * Vynasobenie matice druhou maticou - tu som pouzil rovnaku maticu ktoru som vynasobil rovnakou maticou
     */
    @Test
    void nasobenieMaticaMatica() {
        double[][] OCAKAVANE_POLE = {
                {1,4,6},
                {16,25,36},
                {49,64,81}
        };
        //inicializacia matice s polom
        SimpleMatrix OCAKAVANY_VYSLEDOK = new SimpleMatrix(OCAKAVANE_POLE);

        //operacia
        MATICA_TEST.nasobenieMaticaMatica(MATICA_TEST,MATICA_TEST);
        Arrays.deepEquals(OCAKAVANY_VYSLEDOK.getPole(), MATICA_TEST.getPole());
    }

    /**
     * Scitanie dvoch rovnakych matic
     */
    @Test
    void scitanieMaticaMatica() {
        double[][] OCAKAVANE_POLE = {
                {2,4,6},
                {8,10,12},
                {14,16,18}
        };
        //inicializacia matice s polom
        SimpleMatrix OCAKAVANY_VYSLEDOK = new SimpleMatrix(OCAKAVANE_POLE);

        //operacia
        MATICA_TEST.scitanieMaticaMatica(MATICA_TEST,MATICA_TEST);
        Arrays.deepEquals(OCAKAVANY_VYSLEDOK.getPole(), MATICA_TEST.getPole());
    }

    /**
     * Odcitanie dvoch matic - tu som pouzil na lepsiu demonstraciu novu maticu, ktoru som odcital od tej skusobnej
     */
    @Test
    void odcitanieMaticaMatica() {
        double[][] OCAKAVANE_POLE = {
                {-2,-1,0},
                {1,2,3},
                {4,5,6}
        };

        //vytvorenie dalsej matice pre lepsi test
        double[][] DRUHE_POLE_TEST = {
                {3,3,3},
                {3,3,3},
                {3,3,3}
        };
        SimpleMatrix DRUHA_MATICA_TEST = new SimpleMatrix(DRUHE_POLE_TEST);
        //inicializacia matice s polom
        SimpleMatrix OCAKAVANY_VYSLEDOK = new SimpleMatrix(OCAKAVANE_POLE);
        //operacia
        MATICA_TEST.odcitanieMaticaMatica(MATICA_TEST,DRUHA_MATICA_TEST);
        Arrays.deepEquals(OCAKAVANY_VYSLEDOK.getPole(), MATICA_TEST.getPole());
    }

    /**
     * Otocenie matice , pole ktore bolo v riadku je teraz v stlpci
     */
    @Test
    void otocenieMatice() {
        double[][] OCAKAVANE_POLE = {
                {1,4,7},
                {2,5,8},
                {3,6,9}
        };
        //inicializacia matice s polom
        SimpleMatrix OCAKAVANY_VYSLEDOK = new SimpleMatrix(OCAKAVANE_POLE);

        //operacia
        MATICA_TEST = MATICA_TEST.otocenieMatice();
        Arrays.deepEquals(OCAKAVANY_VYSLEDOK.getPole(), MATICA_TEST.getPole());
    }
}