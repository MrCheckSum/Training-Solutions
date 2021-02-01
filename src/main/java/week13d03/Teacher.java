package week13d03;

/*
Adott a következő szerkezetű fájl, beosztas.txt:
Albatrosz Aladin
biologia
9.a
2
Albatrosz Aladin
osztalyfonoki
9.a
1
Csincsilla Csilla
matematika
9.b
2
A fájl tantárgyfelosztást tartalmaz.
A tanttárgyfelosztást 4-es blokkokban adjuk meg.
Első sor a tanár neve, majd a tantárgy, majd az osztály ahol tanítja és végül az, hogy heti hány órában.
Írj egy metódust, ami paraméterül várja egy tanár nevét, és kiírja, hogy hány órája van egy héten.
 */

public class Teacher {

    private String name;
    private String subject;
    private String studentClass;
    private int nrOfWeeklyLessons;

    public Teacher(String name, String subject, String studentClass, int nrOfWeeklyLessons) {
        this.name = name;
        this.subject = subject;
        this.studentClass = studentClass;
        this.nrOfWeeklyLessons = nrOfWeeklyLessons;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public int getNrOfWeeklyLessons() {
        return nrOfWeeklyLessons;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name +
                ", subject='" + subject +
                ", studentClass='" + studentClass +
                ", nrOfWeeklyLessons=" + nrOfWeeklyLessons +
                '}';
    }
}
