package classwork.sample;

import java.sql.*;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class Employee extends Person implements Worker {
    private static ResourceBundle employeeBundle = ResourceBundle.getBundle("employee", Locale.ENGLISH);

    private static long id = 1;
    private String position;
    private int salary;
    protected Department department;
    protected int workDayDuration;
    protected Contract contract;
    protected int workHours;

//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    public Employee(String position, int salaryRub, Person person) {
//        super(person.firstName, person.surName);
//        this.position = position;
//        this.salaryRub = salaryRub;
//    }

    public Employee(String position, int salary) {
        super("Ivan","Ivanov","Ivanovich");
        this.position = position;
        this.salary = salary;
    }

    public Employee(String position, int salary, Department department) {
        //birthDay чтобы не было NPE
        super("Ivan","Ivanov","Ivanovich", LocalDate.now());
        this.position = position;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String firstName, String surName, String middleName, String position,
                    int salary, int workDayDuration, Department department) {
        super(firstName, surName, middleName);
        this.position = position;
        this.salary = salary;
        this.workDayDuration = workDayDuration;
        this.department = department;
    }

//    public Employee(String firstName, String surName, String middleName, String position,
//                    int salary, int workDayDuration, Department department) {
//        super(firstName, surName, middleName);
//        this.position = position;
//        this.salary = salary;
//        this.workDayDuration = workDayDuration;
//        this.department = department;
//    }

    public Employee(String position, int salary, int workDayDuration, Department department) {
        super("Ivan","Ivanov", "Ivanovitch");
        this.position = position;
        this.salary = salary;
        this.workDayDuration = workDayDuration;
        this.department = department;
    }

    public void saveEmployee() throws SQLException, ClassNotFoundException {
//        Class.forName("org.postgresql.Driver");
        //для postgre url имя хоста имя бд
        //try with resources потому что нужно закрывать (автоматически закроется)
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/employees","postgres", "123456");) {
            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO person (id, surname, firstname, middlename, birthday) VALUES (?, ?, ?, ?, ?)");
            //? потому что передаем в параметрах
            long personId = Person.id++;
            statement.setLong(1, personId);
            statement.setString(2, this.surName);
            statement.setString(3, this.firstName);
            statement.setString(4, this.middleName);
            statement.setDate(5, Date.valueOf(this.getBirthDay()));
            //выполним запрос
            statement.executeUpdate();

            statement = con.prepareStatement(
                    "INSERT INTO employee (id, position, salary, personid) VALUES (?, ?, ?, ?)");
            //? потому что передаем в параметрах
            statement.setLong(1, Employee.id++);
            statement.setString(2, this.position);
            statement.setDouble(3, this.salary);
            statement.setLong(4, personId);
            //выполним запрос
            statement.executeUpdate();
        }

        /*
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "123456")) {
            Savepoint s = null;
            try {
                con.setAutoCommit(false);
                s = con.setSavepoint("Savepoint1");
                PreparedStatement statement = con.prepareStatement(
                        "INSERT INTO person (personid, surname, firstname, middlename, birthday) VALUES (?, ?, ?, ?, ?)");
                long personId = Person.personId;
                statement.setLong(1, Person.personId++);
                statement.setString(2, this.surName);
                statement.setString(3, this.firstName);
                statement.setString(4, this.middleName);
                statement.setDate(5, Date.valueOf(this.getBirthDay()));
                statement.executeUpdate();
                statement = con.prepareStatement(
                        "INSERT INTO employee (id, position , salary, personid) VALUE (?, ?, ?, ?)");
                statement.setLong(1, Employee.employeeId++);
                statement.setString(2, this.position);
                statement.setDouble(3, this.salary);
                statement.setLong(4, personId);
                statement.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback(s);
                con.commit();
                e.printStackTrace();
            }
        }
         */
    }

    public void loadEmployeeFromDB() {
//        Class.forName("org.postgresql.Driver");
        //для postgre url имя хоста имя бд
        //try with resources потому что нужно закрывать (автоматически закроется)
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres", "123456");) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT p.id, p.surname, p.firstname, p.middlename, p.birthday, e.position, e.salary " +
                    "FROM person p JOIN employee e ON p.id=e.id " +
                    "WHERE p.id = 1");
            if (rs.next()) {
                this.surName = rs.getString("surname");
                this.firstName = rs.getString("firstname");
                this.middleName = rs.getString("middletname");
                this.setBirthDay(rs.getDate("birthday").toLocalDate());
                this.position = rs.getString("position");
                this.salary = rs.getInt("salary");
            }

//            rs.close();
//            statement.close();
//            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void goWork() {
        System.out.println(employeeBundle.getString("goWork"));
    }

    @Override
    public void doWork() {
        System.out.println(employeeBundle.getString("doWork"));
    }

    @Override
    public void finishWork() {
        System.out.println(employeeBundle.getString("finishWork"));
    }

    @Override
    public String toString() {
        return this.surName + ";" + this.firstName + ";" + this.middleName + ";" +
                this.getBirthDayString() + ";" +
                this.getPassportPrefix() + ";" + this.getPassportNumber() + ";" +
                this.position + ";" + NumberFormat.getInstance().format(this.salary) + ";" + this.workDayDuration + ";" +this.workHours;
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
