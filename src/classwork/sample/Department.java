package classwork.sample;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private List<Employee> employeeList = new ArrayList<>();
    // <?> -- объекты строго фиксиованного любого типа, но только одного
    // <? super Employee>  объекты строго фиксиованного типа, который расширяет Employee, но только одного
    //private List<? super Employee> meetingEmployeeList = new ArrayList<>();
    private List<ParticipantOfMeeting> meetingEmployeeList = new ArrayList<>();
    private List<? super ParticipantOfMeeting> stuffEmployeeList= new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, Employee headEmployee) {
        this.name = name;
        employeeList.add(headEmployee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<? super ParticipantOfMeeting> getStuffEmployeeList() {
        return stuffEmployeeList;
    }

    //паттерны?
    public Employee getOrAddHeadEmployee() {
        if (employeeList.isEmpty()) {
            employeeList.add(0, new Employee("", 0, 8, new Department("")));
        }
        return employeeList.get(0);
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        if (employee instanceof ParticipantOfMeeting) {
            meetingEmployeeList.add((ParticipantOfMeeting) employee);
        }
    }
}
