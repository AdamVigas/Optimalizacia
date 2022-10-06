package Zlomky;

public class Zlomky {
    private int citatel, menovatel;
    public Zlomky(int cit, int men){
        citatel =cit;
        menovatel =men;
    }

    public int getCitatel() {
        return citatel;
    }

    public int getMenovatel() {
        return menovatel;
    }

    public Zlomky add(Zlomky other){
        int n = citatel * other.menovatel + other.citatel * menovatel;
        int d = menovatel * other.menovatel;
        return new Zlomky(n, d);
    }

    public Zlomky sub(Zlomky other){
        int n = citatel * other.menovatel - other.citatel * menovatel;
        int d = menovatel * other.menovatel;
        return new Zlomky(n, d);
    }

    public Zlomky mult(Zlomky other){
        int n = citatel * other.citatel;
        int d = menovatel * other.menovatel;
        return new Zlomky(n, d);
    }

    public Zlomky div(Zlomky other){
        int n = citatel * other.menovatel;
        int d = menovatel * other.citatel;
        return new Zlomky(n, d);
    }

    @Override
    public String toString() {
        return citatel + " / "+ menovatel;
    }

}