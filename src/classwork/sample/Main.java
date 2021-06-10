package classwork.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws MySpecificException, FileNotFoundException {
        //создаем головной отдел и добавляем туда шефа
        Department department = new Department("headDep");

        Contract staffContract = new OpenContract<RubCurrency>();
        Contract outStaffContract = new FixedContract<UsdCurrency>();

//        Employee firstEmployee = new Stuff("Chief", 1000000, staffContract, department);
        Stuff firstEmployee = new Stuff("Chief", 1000000, staffContract, department);
        department.addEmployee(firstEmployee);
        department.getStuffEmployeeList().add(firstEmployee);
//        Employee thirdEmployee = new HalfStuff("Developer", 100000, staffContract, department);
        Stuff thirdEmployee = new HalfStuff("Developer50", 100000, staffContract, department);
        department.addEmployee(thirdEmployee);
//        Employee secondEmployee = new OutStuff("Developer", 100000, outStaffContract);
        Employee secondEmployee = new OutStuff("Developer30", 100000, outStaffContract);
        department.addEmployee(secondEmployee);

        Company myCompany = new Company("DreamCompany");

        File employeesOut = new File("D:\\JavaECourse2021\\src\\classwork\\sample\\employees_out");
        try (FileWriter emplWriter= new FileWriter(employeesOut)) {
            for (Employee e: department.getEmployeeList()) {
                if (e instanceof ParticipantOfMeeting) {
                    department.getStuffEmployeeList().add((ParticipantOfMeeting) e);
                }
                emplWriter.write(e.toString() + '\n');
            }
            for (Object p : department.getStuffEmployeeList()) {
                System.out.println(p.getClass().getName());
            }
        } catch (IOException e) {

        }

//        for (Employee e: department.getEmployeeList()) {
//            if (e instanceof ParticipantOfMeeting) {
//                department.getStuffEmployeeList().add((ParticipantOfMeeting) e);
//            }
//        }
//        for (Object p : department.getStuffEmployeeList()) {
//            System.out.println(p.getClass().getName());
//        }
        //добавляем отдел в компанию
        myCompany.addDepartment(department);

        ////////
        Person person = new Person("Иван", "Иванов", "Иванович");
        Person.Passport passport = person.passport;
        String fullName = person.getFullName();
        String [] fullNamePart = fullName.split("\\s+");
        String email = "akazakov@gmail.com";
        Pattern p = Pattern.compile("(\\s+)");
        Matcher m = p.matcher(fullName);
        String textForPersonEarnSalary = "Дорогой %s! Вам начислена заработная плата за %s месяц %s год";
        System.out.println(String.format(textForPersonEarnSalary, person.getFullName(),
                LocalDate.now().getMonth().getDisplayName(TextStyle.SHORT_STANDALONE, Locale.getDefault()),
                LocalDate.now().getYear()+""));
        while (m.find()) {
            System.out.println(m.group(1));
        }
        if (email.matches("[a-zA-Z]+\\@[a-zA-Z\\.]+")) {
            System.out.println("Email ok");
        }  else {
            System.out.println("Email invalid");
        }
        for (String part: fullNamePart) {
            System.out.println(part);
        }
        System.out.println(person.getFullName());
///////////

        System.out.println(Person.AgeCalculator.getAge(LocalDate.MIN));

//        File employees = new File("D:\\JavaECourse2021\\src\\classwork\\sample\\employees");
        employeesOut = new File("D:\\JavaECourse2021\\src\\classwork\\sample\\employees");
        //работа с потоками
//        try(FileInputStream employeeStream = new FileInputStream(employees)) {
//            String employeesFromFile = new String(employeeStream.readAllBytes());
//            System.out.println(employeesFromFile);
//            String [] employeesParts = employeesFromFile.split(";");
//            Employee employeeFromFile = new Employee(employeesParts[0], employeesParts[1],
//                    employeesParts[2], employeesParts[6], Integer.parseInt(employeesParts[7]),
//                    Integer.parseInt(employeesParts[8]), null);
//
//        } catch (IOException e) {
//
//        }
        try {
            //создание каталога
//           Path directory = Files.createDirectory(Path.of("D:\\JavaECourse2021\\src\\Part2"));
           Path directory = Path.of("D:\\JavaECourse2021\\src");
           for (String fileName : directory.toFile().list()) {
               System.out.println(fileName);
           }

            for(String part : Files.readAllLines(employeesOut.toPath())) {
                String [] employeesParts = part.split(";");
                Employee employeeFromFile = new Employee(employeesParts[1], employeesParts[0],
                    employeesParts[2], employeesParts[6], Integer.parseInt(employeesParts[7]),
                    Integer.parseInt(employeesParts[8]), null);
                System.out.println(employeeFromFile.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
