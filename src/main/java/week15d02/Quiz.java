package week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
Adott egy vetélkedő kérdésbankja egy fájlban. A fájlban az egy kérdéshez tartozó adatok két sorban helyezkednek el.
Első sorban a kérdés, a második sorban a válasz a pontszám és a téma szóközzel elválasztava.
Olvasd be a fájl tartalmát a memóriába, majd oldjátok meg a lenti feladatokat.
​
```
Mikor volt a mohacsi vesz?
1526 1 tortenelem
Melyik evben bomlott fel a Nyugat-Romai Birodalom?
476 1 tortenelem
Melyik a legkisebb primszam?
2 1 matematika
Mennyi 64 kobgyoke?
4 2 matematika
Hany atloja van a szabalyos nyolcszognek?
24 2 matematika
Melyik evben kezdodott a Honfoglalas?
895 1 tortenelem
Mikor adtak ki az Aranybullat?
1222 1 tortenelem
Melyik evben adtak ki Angliaban a Magna Chartat?
1215 3 tortenelem
```
1. Írj egy metódust, melynek paramétere a téma és add vissza, az összes kérdést abban a témában. (Csak a kérdéseket)
2. Írj egy metódust, ami random sorsol ki egy kérdést, és adja vissza annak összes adatát.
3. Készíts egy metódust ami rendszerezi a kérdéseket témakörönként. Visszatér egy datszerkezetben amelyben témánként megtalálható az összes kérdés.
4. Az előző feladat segítségével határozd meg, hogy melyik téma kérdései érik a legtöbb pontot (összpontszám)!
 */
public class Quiz {

    private final List<Category> categories = new ArrayList<>();

    public void fileReader(String fileName) {
        Path file = Path.of(fileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String line2nd = bufferedReader.readLine();
                String[] parts = line2nd.split(" ");
                int answer = Integer.parseInt(parts[0]);
                int points = Integer.parseInt(parts[1]);
                String topic = parts[2];
                categories.add(new Category(line, answer, points, topic));
            }


        } catch (IOException ioException) {
            throw new IllegalStateException("File is non-readable!", ioException);
        }
    }

    public Map<String, List<Category>> questionListByTopics() {
        Map<String, List<Category>> result = new HashMap<>();
        for (Category category : categories) {
            if (!result.containsKey(category.getTopic())) {
                result.put(category.getQuestion(), new ArrayList<>());
            }
             result.get(category.getTopic()).add(category);
        } return result;
    }

    public Category randomQuestion(Random rnd) {
        int idx = rnd.nextInt(categories.size());
        return categories.get(idx);
    }


    public List<String> questionsByGivenTopics(String topic) {
        List<String> result = new ArrayList<>();
        for (Category category : categories) {
            if (category.getTopic().equals(topic)) {
                result.add(category.getQuestion());
            }
        }
        return result;
    }


        public String getMaxSumPointByTopics() {
            Map<String, List<Category>> calculate = questionListByTopics();
            String question = null;
            int sumMain = 0;
            int sum = 0;
            for (String c : calculate.keySet()) {
                sum = countPoints(calculate, c);
                if (sum > sumMain) {
                    sumMain = sum;
                    question = c;
                }
            }
            return question;
        }

    private int countPoints(Map<String, List<Category>> calculate, String key) {
        int sum = 0;
        for (Category category : calculate.get(key)) {
            sum += category.getPoints();
        }
        return sum;
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.fileReader("kerdesek.txt");
      // System.out.println(quizShow.randomQuestion());
        System.out.println(quiz.getMaxSumPointByTopics());
        System.out.println(quiz.questionsByGivenTopics("matematika"));
        System.out.println(quiz.questionListByTopics());
    }
}


