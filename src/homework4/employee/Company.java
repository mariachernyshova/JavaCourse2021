package homework4.employee;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private Employee director;
    private List<Department> departments = new ArrayList<>();

    public Company(String name, Employee director) {
        this.name = name;
        this.director = director;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    public void findAndPrintSubordinates(String nameDep) {
        if (this.name.equals(nameDep)) {
            this.getDepartments().forEach(Department::getSubordinates);
        } else {
            this.getDepartments().forEach(department -> department.findRecursion(nameDep));
        }
    }

}
