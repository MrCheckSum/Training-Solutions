package week07d01;

/*
Készíts egy osztályt a week07d01 csomagba MathAlgorithms néven.
Ebben az osztályban legyen egy isPrime(int x) metódus ami a paraméterül kapott számról eldönti,
hogy prím-e vagy sem és ennek megfelelően true vagy false értékkel tér vissza.
Aki már tart ott és tudja mit jelent a static az nyugodtan implementálhatja a metódust statikus metódusként.
Az egyszerűség kedvért a prímeket most csak a pozitív egész számok körében értelmezzük,
így bónuszként rá lehet ellenőrizni, hogy x>0  és ha nem akkor kivételt dobni.
Prímeknek tekintjük azokat számokat melyek csak egyel és önmagukkal oszthatók, tehát a 2,3,5,7,11,13 stb. Teszt!!
 */
public class MathAlgorithms {

    public static boolean isPrime(int nr) {
        if (nr < 1) {
            throw new IllegalArgumentException("A szám nem lehet kisebb 1-nél!");
        }
        if (nr == 1) {
            return true;
        }
        if (nr == 2) {
            return true;
        }
        int div = 0;
        for (int item = 2; item <= nr; item++) {
            if (nr % item == 0) {
                div = div + 1;
            }
        }
        if (div >= 2) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(19999));
    }
}