package intromethods.employee;

public class Employee {

    private String name;
    private int hiringDate;
    private int salary;

    public Employee(String name, int hiringDate, int salary) {
        this.name = name;
        this.hiringDate = hiringDate;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getHiringDate() {
        return hiringDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int raiseSalary (int raise) {
        return salary + raise;
    }

    public String employeToString() {
        return "Name: "  + getName() +", HiringYear:" + getHiringDate() + ", Salary:" + salary ;
    }
}
