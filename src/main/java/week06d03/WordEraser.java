/*Mai Junior/Mid-level feladat.
A week06s03.WordEraser osztályban legyen egy eraseWord(String words, String word) metódus,
mely az első paraméter szöveget úgy változtatja meg, hogy a második paraméter összes előforulását kitörli belőle.
A words paraméterben a szavak szóközzel vannak elválasztva. A metódus térjen vissza a törölni kívánt szavak nélküli Stringgel.
(Mellőzzük a replace és replaceAll használatát)*/


package week06d03;

public class WordEraser {

    public String eraseWord(String words, String word) {

        String[] wordList = words.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordList.length; i++) {  //for (String item : wordList) {
            if (!wordList[i].equals(word)) {     //if (!item.equals(word)) {
                sb.append(wordList[i] + " ");   //sb.append(item + " ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        WordEraser wordEraser = new WordEraser();
        System.out.println(wordEraser.eraseWord("alma körte barack alma szilva körte birsalma", "alma"));

    }

}

