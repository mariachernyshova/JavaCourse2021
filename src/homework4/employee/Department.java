package homework4.employee;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private Employee head;
    private List<Department> subDepartments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public Department(String name, Employee head) {
        this.name = name;
        this.head = head;
    }

    public Department(int name, Employee head) {
        this.name = String.valueOf(name);
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Employee getHead() {
        return head;
    }

    public List<Department> getSubDepartments() {
        return subDepartments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addSubDepartment(Department department) {
        this.subDepartments.add(department);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void getSubordinates() {
        //глава отдела
        System.out.println(this.head.toString());
        //сотрудники отдела
        this.employees.forEach(emp -> {
            System.out.println("\t" + emp.toString());

        });

        //подотделы
        if (this.getSubDepartments().size()!=0) {
            this.getSubDepartments().forEach(Department::getSubordinates);
        }
    }

    public void findRecursion(String nameDep) {
        if (this.name.equals(nameDep)) {
            this.getSubordinates();
        } else {
            this.subDepartments.forEach(subDep -> subDep.findRecursion(nameDep));
        }
    }
}
