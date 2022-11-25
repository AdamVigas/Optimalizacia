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

        /**
         * Zadanie z youtube : https://www.youtube.com/watch?v=rzRZLGD_aeE
         */
        int[][] pole3 = {
                {-5, -4, 0, 0, 1, 0},
                {3, 5, 1, 0, 0, 78},
                {4, 1, 0, 1, 0, 36}
        };

        /**
         * Priklad z prezentacie - priklad zacyklenia - test anticyklickeho pravidla
         */
        int [][] anticyklicky_test  = {
                {20, -53, -41, 204, 0, 0, 0, 0},
                {2, -11, -5, 18, 1, 0, 0, 0},
                {-1, 4, 2, -8, 0, 1, 0, 0},
                {-2, 11, 5, -18, 0, 0, 1, 1}
        };



        /***
         * Zadanie z youtube : https://www.youtube.com/watch?v=XK26I9eoSl8
         */
        int[][] pole4 = {
                {-6, -5, -4, 0, 0, 0, 1, 0},
                {2, 1, 1, 1, 0, 0, 0, 180},
                {1, 3, 2, 0, 1, 0, 0, 300},
                {2, 1, 2, 0, 0, 1, 0, 240}
        };

        /**
         * Priklad z prezentacie - dve fazy
         */
        int[][] dveFazy = {
               //x1 x2 p1 p2  b
        /*z*/   {-2, -3, 0, 0, 0},
                {3, 2, 0, 0, 14},
                {2, -4, -1, 0, 2},
                {4, 3, 0, 1,  19}
        };


        Matrix matrix = new Matrix(anticyklicky_test);
        Simplex simplex = new Simplex(matrix);
        simplex.runSimplex();


        //simplex.runSimplexWithPhase(2);
    }

}
