package classwork.sample;

public class Employee extends Person implements Worker{
    private String position;
    private int salary;
    protected Department department;
    protected int workDayDuration;
    protected Contract contract;
    protected int workHours;

//    public Employee(String position, int salaryRub, Person person) {
//        super(person.firstName, person.surName);
//        this.position = position;
//        this.salaryRub = salaryRub;
//    }

    public Employee(String position, int salary) {
        super("Ivan","Ivanov");
        this.position = position;
        this.salary = salary;
    }

    public Employee(String position, int salary, Department department) {
        super("Ivan","Ivanov");
        this.position = position;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String firstName, String surName, String position,
                    int salary, int workDayDuration, Department department) {
        super(firstName, surName);
        this.position = position;
        this.salary = salary;
        this.workDayDuration = workDayDuration;
        this.department = department;
    }

    public Employee(String position, int salary, int workDayDuration, Department department) {
        super("Ivan","Ivanov");
        this.position = position;
        this.salary = salary;
        this.workDayDuration = workDayDuration;
        this.department = department;
    }

    @Override
    public void goWork() {
        System.out.println("I'm at work");
    }

    @Override
    public void doWork() {
        System.out.println("I'm doing my work");
    }

    @Override
    public void finishWork() {
        System.out.println("I'm finished my work");
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
