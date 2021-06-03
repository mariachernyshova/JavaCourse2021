package classwork.sample;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        //создаем головной отдел и добавляем туда шефа
        Department department = new Department("headDep");

        Contract staffContract = new OpenContract<RubCurrency>();
        Contract outStaffContract = new FixedContract<UsdCurrency>();

        Employee firstEmployee = new Stuff("Chief", 1000000, staffContract, department);
        department.addEmployee(firstEmployee);
        Employee thirdEmployee = new HalfStuff("Developer", 100000, staffContract, department);
        department.addEmployee(thirdEmployee);
        Employee secondEmployee = new OutStuff("Developer", 100000, outStaffContract);
        department.addEmployee(secondEmployee);

        Company myCompany = new Company("DreamCompany");

        for (Employee e: department.getEmployeeList()) {
            if (e instanceof ParticipantOfMeeting) {
                department.getStuffEmployeeList().add((ParticipantOfMeeting) e);
            }
        }
        for (Object p : department.getStuffEmployeeList()) {
            System.out.println(p.getClass().getName());
        }

        //добавляем отдел в компанию
        myCompany.addDepartment(department);

        System.out.println(Person.AgeCalculator.getAge(LocalDate.MIN));

    }
}
