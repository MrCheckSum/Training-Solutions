package intromethods;

public class EmpolyeeMain {
    public static void main(String[] args) {
        Employee employee = new Employee("Jack Doe", 2000, 100000);
        System.out.println(employee.employeToString());
        System.out.println("Raised salary: " + employee.raiseSalary(10000));
    }
}
