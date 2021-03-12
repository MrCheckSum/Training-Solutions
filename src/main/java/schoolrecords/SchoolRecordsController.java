package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    private ClassRecords classRecords;
    private List<Subject> subjects = new ArrayList<>();

    private List<Tutor> tutors;


    private List<String> subjectNames = Arrays.asList("Subject1", "Subject2", "Subject3");


    public SchoolRecordsController(ClassRecords classRecords) {
        this.classRecords = classRecords;
    }

    public void initSchool() {
        for (String subjectname : subjectNames) {
            subjects.add(new Subject(subjectname));
        }
        tutors = Arrays.asList(
                new Tutor("Tutor1", Arrays.asList(new Subject("Subject1"), new Subject("Subject3"))),
                new Tutor("Tutor2", Arrays.asList(new Subject("Subject3"), new Subject("Subject2"))),
                new Tutor("Tutor3", Arrays.asList(new Subject("Subject2"), new Subject("Subject1"), new Subject("Subject3")))
        );
    }

    public void verbalTest() {
        String message = "";
        Student student = null;
        System.out.println("Verbal test:\n\r");

        try {
            student = classRecords.repetition();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        if (student != null) {
            System.out.println("Student: " + student.getName() + "\n\r");

            int selectedTutor = selectTutor();

            int selectedSubject = selectSubject(selectedTutor);

            String selectedMark = selectMark();

            student.grading(new Mark(MarkType.valueOf(selectedMark), new Subject(subjectNames.get(selectedSubject)), tutors.get(selectedTutor)));
            System.out.println("Registration successful!");
        }
    }

    public int selectTutor() {

        Scanner scanner = new Scanner(System.in);
        int tutorIndex = 0;
        for (Tutor tutor : tutors) {
            System.out.println(tutorIndex + 1 + ". " + tutor.getName());
            tutorIndex++;
        }
        System.out.println("Select Tutor: " + tutorIndex);
        int maxIndex = tutorIndex;
        tutorIndex = 0;
        while (tutorIndex == 0) {
            try {
                tutorIndex = scanner.nextInt();
            } catch (InputMismatchException e) {
                tutorIndex = 0;
                scanner.nextLine();
            }
            if (tutorIndex < 1 || tutorIndex > maxIndex) {
                tutorIndex = 0;
            }
        }
        tutorIndex--;
        return tutorIndex;
    }

    public int selectSubject(int tutorIndex) {

        Scanner sc = new Scanner(System.in);
        int subjectIndex = 0;
        for (String subjectName : subjectNames) {
            if (tutors.get(tutorIndex).tutorTeachingSubject(new Subject(subjectName))) {
                System.out.println(subjectIndex + 1 + ". " + subjectName);
                subjectIndex++;
            }
        }
        System.out.println("Select Subject: " + subjectIndex);
        int maxIndex = subjectIndex;
        subjectIndex = 0;
        while (subjectIndex == 0) {
            try {
                subjectIndex = sc.nextInt();
            } catch (InputMismatchException e) {
                subjectIndex = 0;
                sc.nextLine();
            }
            if (subjectIndex < 1 || subjectIndex > maxIndex) {
                subjectIndex = 0;
            }
        }
        subjectIndex--;
        return subjectIndex;
    }

    public String selectMark() {

        Scanner sc = new Scanner(System.in);
        int markIndex = 0;
        for (MarkType mark : MarkType.values()) {
            System.out.println(String.format("%1s - ( %1d ) %-15s", MarkType.values()[markIndex], mark.getValue(), mark.getDescription()));
            markIndex++;
        }
        String mark = "";
        System.out.print("Select Mark ( ");
        for (MarkType item : MarkType.values()) {
            System.out.print(item + " ");
        }
        System.out.println(")");
        while (mark.equals("")) {
            mark = sc.nextLine();
            mark = mark.toUpperCase();
            switch (mark) {
                case "A":
                case "B":
                case "C":
                case "D":
                case "F":
                    break;
                default:
                    mark = "";
            }
        }
        return mark;
    }

    public Student selectStudent() {

        int studentIndex = 0;
        String studentNames = null;
        Student studentItem = null;
        try {
            studentNames = classRecords.listStudentNames();
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("There is no student in the class!" + e.getMessage());
        }
        if (studentNames != null) {
            List<String> students = new ArrayList<>();
            Scanner sc = new Scanner(studentNames).useDelimiter(", ");
            while (sc.hasNext()) {
                students.add(sc.next());
                System.out.println(studentIndex + 1 + ". " + students.get(studentIndex));
                studentIndex++;
            }
            System.out.println("Select Student: 1 - " + (studentIndex));
            sc.close();
            sc = new Scanner(System.in);
            int maxIndex = studentIndex;
            studentIndex = 0;
            while (studentIndex == 0) {
                try {
                    studentIndex = sc.nextInt();
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    studentIndex = 0;
                }
                if (studentIndex < 1 || studentIndex > maxIndex) {
                    studentIndex = 0;
                }
            }
            studentIndex--;
            studentItem = classRecords.findStudentByName(students.get(studentIndex));
        }
        return studentItem;
    }

    public void averageByStudent(boolean subj) {

        Student selectedStudent = selectStudent();
        if (selectedStudent != null) {
            if (!subj) {
                try {
                    System.out.println(String.format("Student: %-20s - Average: %4.2f", selectedStudent.getName(), selectedStudent.calculateAverage()));
                } catch (ArithmeticException e) {
                    System.out.println(String.format("Student: %-20s - %s", selectedStudent.getName(), e.getMessage()));
                }
            } else {
                System.out.println(selectedStudent.getName() + " : Average by subjects:");
                for (String subjectname : subjectNames) {
                    try {
                        System.out.println(String.format("Subject: %-20s - Average: %4.2f", subjectname, selectedStudent.calculateSubjectAverage(new Subject(subjectname))));
                    } catch (ArithmeticException e) {
                        System.out.println(String.format("Subject: %-20s - %30s", subjectname, e.getMessage()));
                    }
                }
            }
        }
    }

    public void printStudentAverage() {
        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        studyResultByNames = classRecords.listStudyResults();
        if (studyResultByNames.size() > 0) {
            for (StudyResultByName item : studyResultByNames) {
                System.out.println(String.format("%-20s - Average: %4.2f", item.getStudentName(), item.getStudyAverage()));
            }
        } else {
            System.out.println("There is no student in the class!");
        }
    }

    public void printClassAverageBySubject() {
        for (String subjectName : subjectNames) {
            try {
                System.out.println(String.format("Subject: %20s - Average: %4.2f", subjectName, classRecords.calculateClassAverageBySubject(new Subject(subjectName))));
            } catch (ArithmeticException e) {
                System.out.println(String.format("Subject: %20s - %30s", subjectName, e.getMessage()));
            }
        }
    }

    public void printClassAverage() {
        try {
            System.out.println("Class average: " + classRecords.calculateClassAverage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printStudents() {
        try {
            System.out.println(classRecords.listStudentNames());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("There is no student in the class!" + e.getMessage());
        }
    }

    public void findStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search for student by name:");
        try {
            System.out.println(classRecords.findStudentByName(scanner.nextLine()).toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addNewStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New student's name?");
        try {
            String studentName = scanner.nextLine();


            System.out.println(classRecords.addStudent(new Student(studentName)) ? "New student added" : "Studnet exists");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Delete student by name");
        try {
            System.out.println(classRecords.removeStudent(classRecords.findStudentByName(scanner.nextLine())) ? "Delete successful!" : "Delete unsuccessful!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }


    public void printMenu() {
        System.out.println(" 1. Show students' name\n\r" +
                " 2. Search student by name\n\r" +
                " 3. Add student \n\r" +
                " 4. Remove student by name\n\r" +
                " 5. Verbal test of a student \n\r" +
                " 6. Calculate class average\n\r" +
                " 7. Calculate subject average\n\r" +
                " 8. Show students' average\n\r" +
                " 9. Show student average\n\r" +
                "10. Student's averages by subjects\n\r" +
                "11. Exit");
    }

    public static void main(String[] args) {
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController(new ClassRecords("First Class", new Random()));

        schoolRecordsController.initSchool();

        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        while (run) {
            schoolRecordsController.printMenu();
            int select = 0;
            try {
                select = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                select = 12;
            }
            switch (select) {
                case 1:
                    schoolRecordsController.printStudents();
                    break;
                case 2:
                    schoolRecordsController.findStudent();
                    break;
                case 3:
                    schoolRecordsController.addNewStudent();
                    break;
                case 4:
                    schoolRecordsController.removeStudent();
                    break;
                case 5:
                    schoolRecordsController.verbalTest();
                    break;
                case 6:
                    schoolRecordsController.printClassAverage();
                    break;
                case 7:
                    schoolRecordsController.printClassAverageBySubject();
                    break;
                case 8:
                    schoolRecordsController.printStudentAverage();
                    break;
                case 9:
                    schoolRecordsController.averageByStudent(false);
                    break;
                case 10:
                    schoolRecordsController.averageByStudent(true);
                    break;
                case 11:
                    run = false;
                    break;
                default:
                    System.out.println("Choose again");
            }
            if (select != 11) {
                System.out.println("Press ENTER to continue.");
                scanner.nextLine();
            }
        }
    }

}
