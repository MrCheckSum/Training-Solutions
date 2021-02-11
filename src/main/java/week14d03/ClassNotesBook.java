package week14d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassNotesBook {

    private List<Student> students; //lehet = new hashMap és add metódus

    public ClassNotesBook(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> sortNoteBook() {
        List<Student> result = new ArrayList<>(students);
        Collections.sort(result); // Collections.sort(result, Comparator.comparing(s->s.getName()) vagy  Collections.sort(result, Comparator.comparing(Student::getName)
        return result;
    }



    public static void main(String[] args) {
        ClassNotesBook classNotesBook = new ClassNotesBook(new ArrayList<>(List.of(new Student("John"), new Student("Jane"), new Student("Bill"), new Student("Jack"))));

        System.out.println(classNotesBook.sortNoteBook()); //másolatot rendezzük
        System.out.println(classNotesBook.getStudents());  //ez az eredeti listát adja vissza változatlan rendezéssel
    }
}
