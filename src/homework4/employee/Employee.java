package homework4.employee;

import java.time.LocalDate;

public class Employee {

    private String name;
    private String surName;
    private LocalDate birthDay;

    public Employee(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public void setBirthDay(LocalDate bd) {
        this.birthDay = bd;
    }

    @Override
    public String toString() {
        return name + surName + ", ";
    }
}
