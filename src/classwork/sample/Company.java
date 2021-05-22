package classwork.sample;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private List<Department> departmentList;

    public Company(String name) {
        this.name = name;
        this.departmentList = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Department> getDepartmentList() { return departmentList; }
//    public void setDepartmentList(List<Department> departmentList) { this.departmentList = departmentList; }

    public void addDepartment(Department department) {
        departmentList.add(department);
    }
}
