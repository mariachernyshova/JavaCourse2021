package classwork.sample;

import java.time.LocalDate;

public class Employee extends Person{
    private String position;
    private int salaryRub;

    public Employee(String position, int salaryRub, Person person) {
        super(person.firstName, person.surName);
        this.position = position;
        this.salaryRub = salaryRub;
    }

    public Employee(String position, int salaryRub) {
        super("Ivan","Ivanov");
        this.position = position;
        this.salaryRub = salaryRub;
    }
}

/**
 * в таком способе не наследуются свойства и методы Person
 *
 public class Employee {
 private String position;
 private int salaryRub;
 private Person person;

 public Employee(String position, int salaryRub, Person person) {
 this.person = person;
 this.position = position;
 this.salaryRub = salaryRub;
 }

 public Employee(String position, int salaryRub) {
 this.position = position;
 this.salaryRub = salaryRub;
 }

 public void say(String whatYouMustSay) {
System.out.println(whatYouMustSay);
 int day = Calendar.DAY_OF_MONTH;
 }

 public void setBirthDay(LocalDate date) {
 person.setBirthDay(date);
 }
 }
 */
