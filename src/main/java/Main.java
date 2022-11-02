import Matica.Matrix;
import Simplex.Simplex;
import Zlomky.Zlomok;


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

        int[][] pole3 = {
                {-5, -4, 0, 0, 1, 0},
                {3, 5, 1, 0, 0, 78},
                {4, 1, 0, 1, 0, 36}
        };



        // TU STACI ZMENI IBA POLE - PRIPRAVIL SOM DVE NA UKAZKU
        Matrix matrix = new Matrix(pole2);
        Simplex simplex = new Simplex(matrix);
        simplex.runSimplex();

        /*Zlomok z1 = new Zlomok(99999999,1);
        Zlomok z2 = new Zlomok(20,2);
        //prve ked je mensie ako druhe tak je to true
        System.out.println(Zlomok.minFraction(z2 ,z1));*/
    }

}
