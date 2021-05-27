package classwork.sample;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private List<Employee> employeeList = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, Employee headEmployee) {
        this.name = name;
        employeeList.add(headEmployee);
    }

    //паттерны?
    public Employee getOrAddHeadEmployee() {
        if (employeeList.isEmpty()) {
            employeeList.add(0, new Employee());
        }
        return employeeList.get(0);
    }

    public void addEmployee(Employee employee) { employeeList.add(employee); }
}
