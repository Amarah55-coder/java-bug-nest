package employee_management;

/**
 * TODO : a department is a collection of employees. It has a name and a set of employees in it.
 */
public class Department {
    /**
     * TODO : Employees should never ever be duplicated in a single department.
     * Please check if it already exists in the department before inserting if need be. Duplicate
     * here means : their employee id and name are the same.
     *
     * TODO : for our HR officer, give a function to show all details about employees, including
     * their pay.
     */

    private String name;
    private Set<FullTimeEmployee> fullTimeEmployees;
    private Set<PartTimeEmployee> partTimeEmployees;

    public Department(String name) {
        this.name = name;
        this.fullTimeEmployees = new HashSet<>();
        this.partTimeEmployees = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addFullTimeEmployee(FullTimeEmployee employee) {
        if (fullTimeEmployees.stream().noneMatch(e -> e.employeeId == employee.employeeId && e.name.equals(employee.name))) {
            fullTimeEmployees.add(employee);
        }
    }

    public void addPartTimeEmployee(PartTimeEmployee employee) {
        if (partTimeEmployees.stream().noneMatch(e -> e.employeeId == employee.employeeId && e.name.equals(employee.name))) {
            partTimeEmployees.add(employee);
        }
    }

    public void showAllEmployees() {
        System.out.println("Full Time Employees:");
        for (FullTimeEmployee employee : fullTimeEmployees) {
            System.out.println("ID: " + employee.employeeId + ", Name: " + employee.name + ", Monthly Salary: " + employee.calculatePay());
        }

        System.out.println("Part Time Employees:");
        for (PartTimeEmployee employee : partTimeEmployees) {
            System.out.println("ID: " + employee.employeeId + ", Name: " + employee.name + ", Hours Worked: " + employee.hoursWorked + ", Hourly Rate: " + employee.hourlyRate + ", Pay: " + employee.calculatePay());
        }
    
    }
    public Set<FullTimeEmployee> getFullTimeEmployees() {
        return fullTimeEmployees;
    }
}
