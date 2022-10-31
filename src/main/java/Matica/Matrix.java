package Matica;


import Zlomky.Zlomok;

public class Matrix {

    /**
     * TATO TRIEDA BOLA POUZITA NA SIMPLEXOVU METODU - SimpleMatrix je zatial nepouzita aj ked tam mam podporu na + - * /
     **/


    private Zlomok [][] matrix;

    public Matrix(int [][] para) {
        this.matrix = new Zlomok[para.length][para[0].length];
        fillMatrix(para);
    }

    public Zlomok[][] getMatrix() {
        return matrix;
    }


    public int getNumerator(int x, int y) {
        return matrix[x][y].getCitatel();
    }

    public int getDenominator(int x, int y) {
        return matrix[x][y].getMenovatel();
    }

    public void fillMatrix(int [][] para) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                matrix[i][j] = new Zlomok(para[i][j],1);
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length;j++) {
                System.out.print(matrix[i][j].toString() + " ");
            }
            System.out.println();
        }
    }



}
