package club.cheapok.utilities;

public class Util {
    public static int transmogrify(final int data) {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }
}