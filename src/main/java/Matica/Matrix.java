package Matica;

import Zlomky.Zlomok;

public class Matrix {

    private Zlomok[][] matrix;

    public Zlomok[][] getMatrix() {
        return matrix;
    }

    public Matrix(int[][] matrix) {
        this.matrix = fillMatrix(matrix);
    }

    public Zlomok[][] fillMatrix(int[][] para) {
        Zlomok[][] temp = new Zlomok[para.length][para[0].length];
        for(int i = 0; i < para.length; i++) {
            for (int j = 0; j < para[0].length; j++) {
                if(para[i][j] == 0) {
                    temp[i][j] = new Zlomok(0,0);
                }else temp[i][j] = new Zlomok(para[i][j],1);
            }
        }
        return temp;
    }

    public void printMatrix(){
        System.out.println("-------------------------");
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length;j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
