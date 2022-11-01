package Zlomky;

public class Zlomok {
    private int citatel, menovatel;
    public Zlomok(int cit, int men){
        citatel =cit;
        menovatel =men;
    }

    public int getCitatel() {
        return citatel;
    }

    public int getMenovatel() {
        return menovatel;
    }

    public Zlomok add(Zlomok other){
        if(other.citatel == 0 && other.menovatel == 0) {
            return new Zlomok(citatel,menovatel);
        }else if (citatel == 0 && menovatel == 0) {
            return new Zlomok(other.citatel, other.menovatel);
        }
        int n = citatel * other.menovatel + other.citatel * menovatel;
        int d = menovatel * other.menovatel;
        return new Zlomok(n, d);
    }

    public Zlomok sub(Zlomok other){
        int n = citatel * other.menovatel - other.citatel * menovatel;
        int d = menovatel * other.menovatel;
        return new Zlomok(n, d);
    }

    public Zlomok mult(Zlomok other){
        int n = citatel * other.citatel;
        int d = menovatel * other.menovatel;
        return new Zlomok(n, d);
    }

    public Zlomok div(Zlomok other){
        int n = citatel * other.menovatel;
        int d = menovatel * other.citatel;
        return new Zlomok(n, d);
    }



    public static boolean maxFraction(Zlomok first, Zlomok sec)
    {
        // Declare nume1 and nume2 for get the value of
        // first numerator and second numerator
        int a = first.citatel;
        int b = first.menovatel;
        int c = sec.citatel;
        int d = sec.menovatel;

        // Compute ad-bc
        int Y = a * d - b * c;

        return (Y > 0) ? true : false;
    }

    public static boolean minFraction(Zlomok first, Zlomok sec)
    {
        // Declare nume1 and nume2 for get the value of
        // first numerator and second numerator
        int a = first.citatel;
        int b = first.menovatel;
        int c = sec.citatel;
        int d = sec.menovatel;

        // Compute ad-bc
        int Y = a * d - b * c;

        return (Y < 0) ? true : false;
    }


    public static boolean equalsFraction(Zlomok first, Zlomok sec)
    {
        // Declare nume1 and nume2 for get the value of
        // first numerator and second numerator
        int a = first.citatel;
        int b = first.menovatel;
        int c = sec.citatel;
        int d = sec.menovatel;

        // Compute ad-bc
        int Y = a * d - b * c;

        return (Y == 0) ? true : false;
    }

    @Override
    public String toString() {
        /*if(menovatel != 0 && citatel % menovatel == 0){
                return citatel+"";
        }else if(citatel == 0) {
            return citatel+"";
        }else*/
         return citatel + "/"+ menovatel;
    }

}