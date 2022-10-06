package Vektor;

public class Vektor {

    private final int n;         // dlzka vektora
    private double[] data;       // pole vektora
    public Vektor(int n) {
        this.n = n;
        this.data = new double[n];
    }


    public double[] getData() {
        return data;
    }

    // vytvorenie vektora z pola
    public Vektor(double[] data) {
        n = data.length;

        this.data = new double[n];
        for (int i = 0; i < n; i++)
            this.data[i] = data[i];
    }

    // vracia velkost vektora
    public int length() {
        return n;
    }

    // nasobenie dvoch vektorov
    public double nasobenieVektorov(Vektor druhyVektor) {
        if (this.length() != druhyVektor.length())
            throw new IllegalArgumentException("dimensions disagree");
        double sum = 0.0;
        for (int i = 0; i < n; i++)
            sum = sum + (this.data[i] * druhyVektor.data[i]);
        return sum;
    }

    public double magnituda() {
        return Math.sqrt(this.nasobenieVektorov(this));
    }

    // Euklidovska vzdialenost medzi vektormi
    public double distanceTo(Vektor druhyVektor) {
        if (this.length() != druhyVektor.length())
            throw new IllegalArgumentException("chyba");
        return this.minus(druhyVektor).magnituda();
    }

    // scitanie vektorov
    public Vektor plus(Vektor druhyVektor) {
        if (this.length() != druhyVektor.length())
            throw new IllegalArgumentException("dimensions disagree");
        Vektor c = new Vektor(n);
        for (int i = 0; i < n; i++)
            c.data[i] = this.data[i] + druhyVektor.data[i];
        return c;
    }

    // odcitanie vektorov
    public Vektor minus(Vektor druhyVektor) {
        if (this.length() != druhyVektor.length())
            throw new IllegalArgumentException("chyba");
        Vektor c = new Vektor(n);
        for (int i = 0; i < n; i++)
            c.data[i] = this.data[i] - druhyVektor.data[i];
        return c;
    }


    public double kartezsky(int i) {
        return data[i];
    }


    public Vektor vynasobenieKonstantou(double factor) {
        Vektor c = new Vektor(n);
        for (int i = 0; i < n; i++)
            c.data[i] = factor * data[i];
        return c;
    }


    public Vektor smer() {
        if (this.magnituda() == 0.0)
            throw new ArithmeticException("nulovy vektor nema ziaden smer");
        return this.vynasobenieKonstantou(1.0 / this.magnituda());
    }

    // vracia stringovu reprezentaciu vektora
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('(');
        for (int i = 0; i < n; i++) {
            s.append(data[i]);
            if (i < n-1) s.append(", ");
        }
        s.append(')');
        return s.toString();
    }

}