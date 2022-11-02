package Simplex;

import Matica.Matrix;
import Zlomky.Zlomok;

public class Simplex {
    int x;
    int y;
    Matrix matrix;

    boolean end = false;

    Zlomok pivot = null;

    public Simplex(Matrix matrix) {
        this.matrix = matrix;
    }


    public void runSimplex() {
        matrix.printMatrix();
        while(!end) {
            findSmallestNegative();
            findPivot();
            makePivotNumberOne();
            eliminate();
            matrix.printMatrix();
        }
    }


    public void findSmallestNegative(){
        int min = 1;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length;j++) {
                if(matrix.getMatrix()[i][j].getCitatel() < 0) {
                    if(min >= matrix.getMatrix()[i][j].getCitatel()) {
                        min = matrix.getMatrix()[i][j].getCitatel();
                        x = i;
                        y = j;
                    }
                }
            }
        }
        if(min == 1) {
            end = true;
        }
    }

    public Zlomok findPivot() {
        Zlomok min = new Zlomok(99999999,1);
        for (int i = 1; i < matrix.getMatrix().length; i++) {
            pivot = matrix.getMatrix()[i][matrix.getMatrix()[0].length -1].div(matrix.getMatrix()[i][y]);
            if(pivot.getCitatel() != 0 && pivot.getMenovatel() != 0) {
                if(Zlomok.minFraction(pivot,min)) {
                    min = pivot;
                    x = i;
                }
            }
        }
        return min;
    }

    public void makePivotNumberOne() {
        int cit = matrix.getMatrix()[x][y].getCitatel();
        int men = matrix.getMatrix()[x][y].getMenovatel();
        if(!Zlomok.equalsFraction(matrix.getMatrix()[x][y],new Zlomok(1,1))) {
            for (int i = 0; i < matrix.getMatrix()[0].length ; i++) {
                matrix.getMatrix()[x][i] = matrix.getMatrix()[x][i].mult(new Zlomok(men,cit));
            }
        }
        checkFractions();
    }

    public void checkFractions() {
        int num;
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length;j++) {
                if(matrix.getMatrix()[i][j].getCitatel() != 0){
                    if(matrix.getMatrix()[i][j].getCitatel() % matrix.getMatrix()[i][j].getMenovatel() == 0) {
                        num = matrix.getMatrix()[i][j].getCitatel() / matrix.getMatrix()[i][j].getMenovatel();
                        matrix.getMatrix()[i][j] = new Zlomok(num,1);
                    }else if(matrix.getMatrix()[i][j].getCitatel() % 2 ==0 && matrix.getMatrix()[i][j].getMenovatel() % 2 == 0) {
                        while((matrix.getMatrix()[i][j].getCitatel() % 2 ==0 && matrix.getMatrix()[i][j].getMenovatel() % 2 == 0)) {
                            matrix.getMatrix()[i][j].setCitatel(matrix.getMatrix()[i][j].getCitatel()/2);
                            matrix.getMatrix()[i][j].setMenovatel(matrix.getMatrix()[i][j].getMenovatel()/2);
                        }
                    }
                }else if(matrix.getMatrix()[i][j].getMenovatel() > 0 ) {
                    matrix.getMatrix()[i][j] = new Zlomok(0,0);
                }
            }
        }
    }

    public void eliminate() {
        Zlomok temp = null;
        Zlomok res;
        int cit;
        int men;
        for (int k = 0; k < matrix.getMatrix().length;k++) {
            if(k != x) {
                cit = matrix.getMatrix()[k][y].getCitatel()*-1;
                men = matrix.getMatrix()[k][y].getMenovatel();
                temp = new Zlomok(cit,men);
            }
            for (int i = 0; i < matrix.getMatrix()[0].length;i++) {
                if(k != x) {
                    res = matrix.getMatrix()[x][i].mult(temp).add(matrix.getMatrix()[k][i]);
                    matrix.getMatrix()[k][i] = res;
                }
            }
        }
        checkFractions();
    }



}
