package Simplex;

import Matica.Matrix;
import Zlomky.Zlomok;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SimplexTest {


    /**
     * ZADANIE :
     * 2x1 + x2 + s1 = 20
     * x1 + x2 + s2 = 18
     * x1 + s3 = 8
     * MAX Z = 7x1 + 4x2
     * Ratanie prikladu online :
     * https://www.youtube.com/watch?v=FY97HLnstVw&t=659s
     */
    int[][] pole = {
            {1, -7, -4, 0, 0, 0, 0},
            {0, 2, 1, 1, 0, 0, 20},
            {0, 1, 1, 0, 1, 0, 18},
            {0, 1, 0, 0, 0, 1, 8}
    };

    Matrix matrix = new Matrix(pole);
    Simplex simplex = new Simplex(matrix);



    Zlomok[][] OCAKAVANY_VYSLEDOK = {
            {new Zlomok(1,1),new Zlomok(0,0),new Zlomok(0,0),new Zlomok(3,1),new Zlomok(1,1),new Zlomok(0,0),new Zlomok(78,1)},
            {new Zlomok(0,0),new Zlomok(0,0),new Zlomok(1,1),new Zlomok(-1,1),new Zlomok(2,1),new Zlomok(0,0),new Zlomok(16,1)},
            {new Zlomok(0,0),new Zlomok(1,1),new Zlomok(0,0),new Zlomok(1,1),new Zlomok(-1,1),new Zlomok(0,0),new Zlomok(2,1)},
            {}
    };

    @Test
    void runSimplex() {
        simplex.runSimplex();
        Arrays.deepEquals(matrix.getMatrix(), OCAKAVANY_VYSLEDOK);
    }
}