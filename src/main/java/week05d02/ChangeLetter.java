package week05d02;

/*
A mai gyakorlati feladatot itt közlöm. Gondolkozz rajta, keresd ki a használni kívánt metódusokat, de ne oldd meg, mert akkor a konzultáción unatkozni fogsz!
A week05d02.ChangeLetter osztályban írj meg egy String changeVowels(String) metódust,
mely kicseréli a paraméterként átadott szövegben az angol magánhangzókat csillag karakterre. Írj hozzá teszteseteket is!
A feladat megoldása és GitHubra feltöltése mindenki számára kötelező, nem feltétlen ma, hanem a hét végéig.
 */

public class ChangeLetter {

    private static final String CHG_TXT = "aeiouAEIOU";

    public String changeVowels(String text) {
        for (int i = 0; i < CHG_TXT.length(); i++) {
    //        text = text.replace(CHG_TXT.charAt(i), '*');
            text = text.replace(CHG_TXT.charAt(i), '*');
        }
        return text;
    }

    public static void main(String[] args) {
        ChangeLetter changeLetter = new ChangeLetter();
        System.out.println(changeLetter.changeVowels("qwertzuiopasdfghjklíyxcvbnmQWERTZUIOPASDFGHJKLYXCVBNM"));
    }
}