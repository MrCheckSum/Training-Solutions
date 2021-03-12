package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random random = new Random(5);
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random random) {
        this.className = className;
        this.random = random;
        this.students = students;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
        boolean isThere = true;
        for (Student s : students) {
            if (s.getName().equals(student.getName())) {
                isThere = false;
            }
        }
        if (isThere == true) {
            students.add(student);
        }
        return isThere;
    }

    public boolean removeStudent(Student student){
        boolean isThere = false;
        for (Student s : students) {
            if (s.getName().equals(student.getName())) {
                isThere = true;
            }
        }
        if (isThere == true) {
            students.remove(student);
        }
        return isThere;
    }

    public double calculateClassAverage() {
        if (students.size() == 0) {
            throw new ArithmeticException("No students in the class!");
        }

        double sum = 0.0;
        for (Student s : students) {
            if (s.calculateAverage() == 0.0) {
                throw new ArithmeticException("No marks presented yet!");
            }
            sum = sum + s.calculateAverage();
        }

        double average = sum / students.size();
        String s = Double.toString(average) + "0";
        s = s.substring(0, 4);
        average = Double.parseDouble(s);
        return average;
    }

    public double calculateClassAverageBySubject(Subject subject) {

        List<Double> subjectAverage = new ArrayList<>();
        for (Student s : students) {
            if (s.calculateSubjectAverage(subject) > 0.0) {
                subjectAverage.add(s.calculateSubjectAverage(subject));
            }
        }

        double sum = 0.0;
        for (Double d : subjectAverage) {
            sum = sum + d;
        }

        double average = sum / subjectAverage.size();
        String s = Double.toString(average) + "0";
        s = s.substring(0, 4);
        average = Double.parseDouble(s);
        return average;
    }

    public Student findStudentByName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must be filled in!");
        }
        if (students.size() == 0) {
            throw new IllegalStateException("There are no students in any class!");
        }

        Student student = null;
        for (Student s : students) {
            if (s.getName().equals(name)) {
                student = s;
            }
        }

        if (student == null) {
            throw new IllegalArgumentException("Student not found! " + name);
        }

        return student;
    }

    public Student repetition() {
        if (students.size() == 0) {
            throw new IllegalStateException("No students to select for repetition!");
        }

        int repetition = random.nextInt(5);
        Student student = students.get(repetition);
        return student;
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> nameAndStudyResultList = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            nameAndStudyResultList.add(new StudyResultByName(students.get(i).getName(), students.get(i).calculateAverage()));
        }

        return nameAndStudyResultList;
    }

    public String listStudentNames() {
        String studentNames = "";

        for (int i = 0; i < students.size(); i++) {
            studentNames = studentNames + (students.get(i).getName() + ", ");
        }
        studentNames = studentNames.substring(0, studentNames.length() - 2);

        return studentNames;
    }

    private boolean isEmpty(String str) {
        return (str == null || str.equals("") || str.isBlank());
    }

}
