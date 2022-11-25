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
            if(findSmallestNegative()){
                findPivot();
                makePivotNumberOne();
                eliminate();
                matrix.printMatrix();

            }
        }
    }

    public void runSimplexWithPhase(int num) {
        twoPhase(num);
        matrix.printMatrix();
        while(!end) {
            if(findSmallestNegative2()){
                findPivot2();
                makePivotNumberOne();
                eliminate();
                matrix.printMatrix();
            }
        }
        eliminateFinishedPhase(num);
        matrix.printMatrix();
        end = false;
        while(!end) {
            if(findSmallestNegative2()){
                findPivot2();
                makePivotNumberOne();
                eliminate();
                matrix.printMatrix();
            }
        }
    }

    public void eliminateFinishedPhase(int num) {
        Matrix newMatrix = new Matrix(new int[matrix.getMatrix().length-1][matrix.getMatrix()[0].length - num]);


        for (int i = 0; i < matrix.getMatrix().length; i++) {
            int temp = num;
            for (int j = matrix.getMatrix()[0].length -1 - temp; j < matrix.getMatrix()[0].length -1; j++) {
                matrix.getMatrix()[i][j] = new Zlomok(999999,999999);
                temp--;
            }
        }

        int g = 0;
        for (int i = 1; i < matrix.getMatrix().length; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                if(matrix.getMatrix()[i][j].getCitatel() != 999999 && matrix.getMatrix()[i][j].getMenovatel() != 999999) {
                    newMatrix.getMatrix()[i-1][j-g] = matrix.getMatrix()[i][j];
                    g = 0;
                }else {
                    g++;
                }
            }
        }

        matrix = newMatrix;
    }


    public boolean findSmallestNegative(){
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
            return false;
        }
        return true;
    }

    public Zlomok findPivot() {
        Zlomok min = new Zlomok(99999999,1);

        for (int i = 1; i < matrix.getMatrix().length; i++) {
            if(matrix.getMatrix()[i][matrix.getMatrix()[0].length -1].getCitatel() >= 0 && matrix.getMatrix()[i][y].getCitatel() > 0) {
                pivot = matrix.getMatrix()[i][matrix.getMatrix()[0].length -1].div(matrix.getMatrix()[i][y]);

                if(pivot.getCitatel() >= 0 && pivot.getMenovatel() >= 0) {
                    if(Zlomok.equalsFraction(pivot, min)) {
                        int temp = compareVectors(i);
                        min = matrix.getMatrix()[temp][y];
                        x = temp;
                    }else {
                        if(pivot.getCitatel() == 0 && pivot.getMenovatel() == 0) {
                            min  = pivot;
                            x = i;
                        }
                        if(Zlomok.minFraction(pivot,min)) {
                            min = pivot;
                            x = i;
                        }
                    }

                }

            }

        }

        return min;
    }

    public int compareVectors(int i) {
        for (int j = 0; j < matrix.getMatrix()[0].length; j ++ ) {
            if(matrix.getMatrix()[i][j].getCitatel() > 0 && matrix.getMatrix()[i-1][j].getCitatel() > 0) {
                if(!Zlomok.equalsFraction(matrix.getMatrix()[i][j],matrix.getMatrix()[i-1][j])) {
                    if(Zlomok.minFraction(matrix.getMatrix()[i][j], matrix.getMatrix()[i-1][j])) {
                        return i;
                    }else return i-1;
                }
            }
        }
        return 0;
    }


    public void twoPhase(int num) {
        Matrix finalnaMatica = null;
        int cislo = 0;
        int [] pomoc = new int[matrix.getMatrix().length];
        Matrix matrix1 = null;

        boolean found = false;
        for (int i = 1; i < matrix.getMatrix().length;i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length;j++) {
                if(j >= num && j!=matrix.getMatrix()[0].length -1) {
                    if(Zlomok.equalsFraction(matrix.getMatrix()[i][j], new Zlomok(1,1)) && matrix.getMatrix()[i][j].getCitatel() != 0) {
                        found = true;
                        break;
                    }else {
                        found = false;
                    }
                }
            }
            if(found) {
                found = false;
            }else {
                cislo++;
                pomoc[i] = 1;
                matrix1 = new Matrix(new int[matrix.getMatrix().length][matrix.getMatrix()[0].length+1]);
                for (int k = 0; k < matrix.getMatrix().length;k++) {
                    for (int g = 0; g < matrix.getMatrix()[0].length;g++) {
                        if(i==k && g == matrix1.getMatrix()[0].length -2) {
                            matrix1.getMatrix()[k][g] = new Zlomok(1,1);
                        }
                        if(g == matrix.getMatrix()[0].length-1) {
                            matrix1.getMatrix()[k][g+1] = matrix.getMatrix()[k][g];
                        }else
                            matrix1.getMatrix()[k][g] = matrix.getMatrix()[k][g];
                    }
                }
                Zlomok [] pole = new Zlomok[matrix1.getMatrix()[0].length];
                for (int ss = 0; ss < pole.length; ss++) {
                    if(ss == matrix1.getMatrix()[0].length -2) {
                        pole[ss] = new Zlomok(0,0);
                    }
                    if(pole[ss] == null) {
                        pole[ss] = new Zlomok(0,0).add(new Zlomok(-matrix1.getMatrix()[i][ss].getCitatel(),matrix1.getMatrix()[i][ss].getMenovatel()));
                    }else
                        pole[ss].add(new Zlomok(matrix1.getMatrix()[i][ss].getCitatel(),matrix1.getMatrix()[i][ss].getMenovatel()));
                }
            }
            matrix = matrix1;
            if(cislo != 0) {
                Zlomok[] pom = new Zlomok[matrix.getMatrix()[0].length];


                for (int k = 0; k < pomoc.length; k++) {
                    if(pomoc[k] == 1) {
                        for (int g = 0; g < pom.length; g++) {
                            if(pom[g] == null) {
                                pom[g] = new Zlomok(-matrix.getMatrix()[k][g].getCitatel(),matrix.getMatrix()[k][g].getMenovatel());
                            }else {
                                pom[g] = pom[g].add(new Zlomok(-matrix.getMatrix()[k][g].getCitatel(),matrix.getMatrix()[k][g].getMenovatel()));
                            }
                        }
                    }
                }


                for (int r = cislo+1; r > 1; r--) {
                    pom[pom.length - r] = new Zlomok(0,0);
                }


                finalnaMatica = new Matrix(new int[matrix.getMatrix().length+1][matrix.getMatrix()[0].length]);
                for (int first = 0; first < finalnaMatica.getMatrix()[0].length; first++) {
                    finalnaMatica.getMatrix()[0][first] = pom[first];
                }



                for (int first = 0 ; first < matrix.getMatrix().length; first++) {
                    for (int second = 0; second < matrix.getMatrix()[0].length; second++) {
                        finalnaMatica.getMatrix()[first+1][second] = matrix.getMatrix()[first][second];
                    }
                }

            }
        }
        this.matrix = finalnaMatica;
    }


    public boolean findSmallestNegative2(){
        int min = 1;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length-1;j++) {
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
            return false;
        }
        return true;
    }


    public Zlomok findPivot2() {
        Zlomok min = new Zlomok(99999999,1);
        for (int i = 2; i < matrix.getMatrix().length; i++) {
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
