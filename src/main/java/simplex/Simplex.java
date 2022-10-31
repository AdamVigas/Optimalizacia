package simplex;

import Matica.Matrix;
import Zlomky.Zlomok;

public class Simplex {

    private Matrix matrix;

    boolean koniec = false;

    private Zlomok pomocneMin = new Zlomok(999999999,1);

    private Zlomok min = new Zlomok(0,0);
    private int x;
    private int y;

    public Simplex(Matrix matrix) {
        this.matrix = matrix;
    }

    public void runSimplex() {
        while (!koniec) {

            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                    if (matrix.getNumerator(i, j) < 0) {
                        if (min.getCitatel() == 0 && min.getMenovatel() == 0) {
                            min = matrix.getMatrix()[i][j];
                            x = i;
                            y = j;
                        } else {
                            if (Zlomok.minFraction(matrix.getMatrix()[i][j], min)) {
                                x = i;
                                y = j;
                                min = matrix.getMatrix()[i][j];
                            }
                        }
                    }
                }
            }


            if (min.getCitatel() < 0) {

                min = new Zlomok(0, 0);
                for (int i = x + 1; i < matrix.getMatrix().length; i++) {

                    Zlomok temp;

                    if (matrix.getMatrix()[i][y].getCitatel() > 0) {
                        temp = matrix.getMatrix()[i][matrix.getMatrix()[0].length - 1].div(matrix.getMatrix()[i][y]);
                    } else {

                        temp = new Zlomok(9999999, 999999);
                    }


                    if (Zlomok.minFraction(temp,pomocneMin)) {
                        x = i;
                        pomocneMin = temp;

                    }

                }
                pomocneMin = new Zlomok(9999999, 1);


                // ideme eliminovat
                for (int i = 0; i < matrix.getMatrix().length; i++) {
                    int num = matrix.getMatrix()[i][y].getCitatel() * -1;
                    for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                        if (i != x) {
                            matrix.getMatrix()[i][j] = matrix.getMatrix()[i][j].add(new Zlomok((num * matrix.getMatrix()[x][j].getCitatel()), 1));
                        }
                    }
                }

            } else {
                System.out.println("VYSLEDOK : ");
                //vynulovanie zlomkov, ktore sa zobrazovali ako nula jednotin tj. 0/1
                for (int i = 0; i < matrix.getMatrix().length; i++) {
                    for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                        if(matrix.getMatrix()[i][j].getCitatel() == 0) {
                            matrix.getMatrix()[i][j] = new Zlomok(0,0);
                        }
                    }
                }
                koniec = true;
            }
            matrix.printMatrix();
            System.out.println("----------------------------\n\n");
        }

    }
}


