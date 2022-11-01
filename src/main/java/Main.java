import Matica.Matrix;
import Simplex.Simplex;


public class Main {

    public static void main(String[] args) {

        /***
         * POMOCNA TRIEDA
         * Matica si nacita z integeroveho dvojrozmerneho pola nas problem
         * Simplexova trieda ju vyrata a vypise maticu s vysledkom - mam aj test triedu
         */

        /**
         * Zadanie na youtube : https://www.youtube.com/watch?v=FY97HLnstVw
         */

        int[][] pole = {
                {1, -7, -4, 0, 0, 0, 0},
                {0, 2, 1, 1, 0, 0, 20},
                {0, 1, 1, 0, 1, 0, 18},
                {0, 1, 0, 0, 0, 1, 8}
        };

        /**
         * Vase zadanie z prezentacie
         */

        int[][] pole2 = {
                {-3, -5, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 4},
                {0, 1, 0, 1, 0, 6},
                {3, 2, 0, 0, 1, 18}
        };

        // TU STACI ZMENI IBA POLE - PRIPRAVIL SOM DVE NA UKAZKU
        Matrix matrix = new Matrix(pole2);
        Simplex simplex = new Simplex(matrix);
        simplex.runSimplex();
    }

}
