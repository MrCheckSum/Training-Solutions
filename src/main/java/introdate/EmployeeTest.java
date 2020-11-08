package introdate;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee employee = new Employee("Kis Karoly",1980,1,1);
        System.out.println(employee.getDateOfBirth());
        System.out.println(employee.getBeginEmployment());
    }
}
