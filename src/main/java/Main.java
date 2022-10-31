import Matica.Matrix;
import simplex.Simplex;


public class Main {

    public static void main(String[] args) {

        /***
         * POMOCNA TRIEDA
         * Matica si nacita z integeroveho dvojrozmerneho pola nas problem
         * Simplexova trieda ju vyrata a vypise maticu s vysledkom - mam aj test triedu
         */

        int[][] pole = {
                {1, -7, -4, 0, 0, 0, 0},
                {0, 2, 1, 1, 0, 0, 20},
                {0, 1, 1, 0, 1, 0, 18},
                {0, 1, 0, 0, 0, 1, 8}
        };

        Matrix matrix = new Matrix(pole);
        Simplex simplex = new Simplex(matrix);
        simplex.runSimplex();
    }

}
