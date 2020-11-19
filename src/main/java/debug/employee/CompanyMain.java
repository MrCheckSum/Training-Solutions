package debug.employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John Doe", 1970);
        Employee employee2 = new Employee("Jack Doe", 1980);
        Employee employee3 = new Employee("Peter Griffin", 1981);

        Company company = new Company(new ArrayList<>());

        company.addEmployee(employee1);
        company.addEmployee(employee2);
        company.addEmployee(employee3);

        Employee find = company.findEmployeeByName("Peter Griffin");

        System.out.println(find.getName() + " " + find.getYearOfBirth());

        List<String> names = company.listEmployeeName();
        System.out.println(names);
    }
}
