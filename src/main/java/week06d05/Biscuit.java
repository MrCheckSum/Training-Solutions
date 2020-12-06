/*
Készíts a week06d05 csomagban egy Biscuit nevű osztályt, amelynek van 2 attribútuma:
BiscuitType type és int gramAmount.
A BiscuitType legyen felsorolásos típus a 3 kedvenc kekszfajtáddal.
A Biscuit nevű osztálynak legyen egy static metódusa of néven, mely paraméterként egy BiscuitType-ot,
és egy int gramAmount-ot vár és visszaad egy új Biscuit objektumot amelyet a megadott paraméterek alapján hoz létre.
Bónusz feladat: konzolra írás esetén a Biscuit jelenítse meg a type és a gramAmount mezőket!
 */

package week06d05;

public class Biscuit {

    private BiscuitType type;
    private int gramAmount;

    public Biscuit(BiscuitType type, int gramAmount) {
        this.type = type;
        this.gramAmount = gramAmount;
    }

    public static Biscuit of(BiscuitType type, int gramAmount) {
        return new Biscuit(type, gramAmount);
    }

    @Override
    public String toString() {
        return type.toString() + ": " + gramAmount + " g";
    }

    public static void main(String[] args) {
        Biscuit biscuit = new Biscuit(BiscuitType.KEKSZ_2, 200);
        System.out.println(biscuit.toString());

    }
}
