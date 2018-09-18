package nl.evertwoud.geoguess;

public class GuessImage {
    int resId;
    boolean isEurope;

    public GuessImage(int pResId, boolean pIsEurope) {
        resId = pResId;
        isEurope = pIsEurope;
    }

    public int getResId() {
        return resId;
    }

    public boolean isEurope() {
        return isEurope;
    }
}
