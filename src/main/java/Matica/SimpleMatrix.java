package Matica;

import Vektor.Vektor;

/***
 * TUTO TRIEDU MOMENTALNE NEPOUZIVAM , NO MOZNO SA MI ESTE BUDE HODIT
 */
@Deprecated
public class SimpleMatrix {

    public SimpleMatrix(double[][] pole) {
        this.pole = pole;
    }

    private double [][] pole;

    public double[][] getPole() {
        return pole;
    }

    /**
     * Podpora pre nasobenie matic zlomkom
     */



    /**
     * Nasobenie : Matica x Vektor
     */
    public void nasobenieMaticaVektor(Vektor other) {
        if(other.length() != this.getPole().length)
            throw new IllegalArgumentException("Neda sa nasobit.");
        for (int i=0; i < this.pole.length; i++) {
            for (int j=0; j < this.pole.length;j++) {
                this.pole[i][j] = (int)(this.pole[i][j]*other.getData()[j]);
            }
        }
    }

    /**
     * Nasobenie : Matica x Konstanta
     * @param factor
     */
    public void vynasobenieMaticeKonstantou(double factor) {
        for (int i = 0; i < this.getPole().length; i++) {
            for (int j=0 ; j < this.getPole()[0].length;j++) {
                this.getPole()[i][j] *= factor;
            }
        }
    }

    /**
     * Otocenie matice riadky na stlpce
     * @return Otocena matica
     */
    public SimpleMatrix otocenieMatice() {
        double[][] pole = new double[this.getPole()[0].length][this.getPole().length];
        SimpleMatrix tempMatica = new SimpleMatrix(pole);

        for(int i=0; i < this.getPole().length;i++){
            for (int j = 0; j < this.getPole()[0].length; j++) {
                tempMatica.getPole()[j][i] = this.getPole()[i][j];
            }
        }
        return tempMatica;
    }

    /**
     * Nasobenie : Matica x Matica
     * @return Vysledna matica
     */
    public SimpleMatrix nasobenieMaticaMatica(SimpleMatrix prva, SimpleMatrix druha) {
        double[][] vysl = new double[prva.getPole().length][druha.getPole()[0].length];
        for(int i = 0; i < prva.getPole().length; i++) {
            for (int j = 0; j <druha.getPole()[0].length; j++) {
                for (int k = 0; k < prva.getPole()[0].length; k++) {
                    vysl[i][j] += prva.getPole()[i][k] * druha.getPole()[k][j];
                }
            }
        }
        return new SimpleMatrix(vysl);
    }

    /**
     * Scitanie : Matica + Matica
     * @return Vysledna matica
     */
    public SimpleMatrix scitanieMaticaMatica(SimpleMatrix prva, SimpleMatrix druha) {
        double[][] vysl = new double[prva.getPole().length][druha.getPole()[0].length];
        for(int i = 0; i < prva.getPole().length; i++) {
            for (int j = 0; j <druha.getPole()[0].length; j++) {
                    vysl[i][j] += prva.getPole()[i][j] + druha.getPole()[i][j];
            }
        }
        return new SimpleMatrix(vysl);
    }

    /**
     * Odcitanie : Matica - Matica
     * @return Vysledna matica
     */
    public SimpleMatrix odcitanieMaticaMatica(SimpleMatrix prva, SimpleMatrix druha) {
        double[][] vysl = new double[prva.getPole().length][druha.getPole()[0].length];
        for(int i = 0; i < prva.getPole().length; i++) {
            for (int j = 0; j <druha.getPole()[0].length; j++) {
                vysl[i][j] += prva.getPole()[i][j] - druha.getPole()[i][j];
            }
        }
        return new SimpleMatrix(vysl);
    }

    /**
     * Vypis vyslednej matice
     */
    public void vypisVysledku() {
        for(double[] row : this.getPole()) {
            for (double column : row) {
                System.out.print((int)column + "    ");
            }
            System.out.println();
        }
    }


}
