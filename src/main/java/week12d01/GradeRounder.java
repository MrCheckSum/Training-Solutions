package week12d01;

/*
Készíts egy GradeRounder osztályt, amiben van egy int[] grades roundGrades(int[] grades) metódus.
A grades tömb pontszámokat tartalmaz 0 és 100 között. A feladat az, hogy kerekítsük a benne lévő számokat a következő szabály szerint:
Ha a pontszám és az 5 következő többszöröse közötti különbség kisebb, mint 3, akkor kerekítsük fel a számot az 5 következő többszörösére.
Fontos: a 40 pont alatti pontszámok elégtelenek, ezeket egyáltalán nem kell kerekíteni.
Példa: a pontszám 84. 85 - 84 kevesebb mint 3, így felfelé kerekítünk.
 */
public class GradeRounder {

    int[] roundGrades(int[] grades) {
        for (int counter = 0; counter < grades.length; counter++) {
            if (grades[counter] > 40) {
                int divideLimit = grades[counter] / 5;
                int roundLimit = (divideLimit + 1) * 5;
                if ((roundLimit - grades[counter]) < 3) {
                    grades[counter] = roundLimit;
                }
            }
        }
        return grades;
    }
}
