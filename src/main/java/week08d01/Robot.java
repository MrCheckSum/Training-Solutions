/*
A feladatban egy robot mozgását fogjuk szimulálni.
Képzelj el egy koordináta rendszert, ahol a robot az origóban van.
A robot négy irányba képes mozogni fel, le, balra és jobbra.
A week08d01.Robot osztályban írj egy move() metódust ami egy karaktersorozatot vár.
pl: FFLLLLLBBBBJJJJJJJ, ahol az F = fel, L=le, B=bal, J=jobb.
A metódus visszatérési értéke legyen a robot mozgás utáni pozíciója.
A feladat szabadon bővíthető osztályokkal és metódusokkal.
Bónusz kiegészítés, hogyha más karaktert is tartalmaz a paraméter String nem csak a FLBJ valamelyikét,
akkor dobjunk IllegalArgumentExceptiont!
 */
package week08d01;

public class Robot {

    private Point position = new Point(0, 0);

    public Point move(String movements) {
        movements = movements.toUpperCase();
        for (int i = 0; i < movements.length(); i++) {
            moveOneStep(movements.charAt(i));
        }
        return this.position;
    }

    private void moveOneStep(char letter) {
        switch (letter) {
            case 'F': {
                position.increaseY();
                return;
            }
            case 'L': {
                position.decreaseY();
                return;
            }
            case 'J': {
                position.increaseX();
                return;
            }
            case 'B': {
                position.decreaseX();
                return;
            }
            default:
                throw new IllegalArgumentException("Nincs ilyen mozgási irány!");
        }
    }

    public Point getPosition() {
        return position;
    }
}
