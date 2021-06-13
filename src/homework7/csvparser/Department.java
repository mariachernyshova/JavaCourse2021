package homework7.csvparser;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employes) {
        this.employees = employes;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

//    @Override
//    public String toString() {
//        this.
//    }
}
