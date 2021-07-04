package homework4.employee;

import java.util.Scanner;

/**
 * Поиск сотрудников на предприятии
 * Предприятие состоит из отделов. В каждом отделе трудятся сотрудники. В каждом отделе есть один руководитель.
 * Отделы представляю иерархию, то есть один отдел может включать в себя список подотделов.
 * <p>
 * Смоделировать ситуацию и написать программу, которая позволит находить подчиненных для заданного руководителя.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название компании: ");
        String nameCompany = scanner.nextLine();
        System.out.println("Введите имя и фамилию директора:");
        System.out.print("имя: ");
        String nameDir = scanner.nextLine();
        System.out.print("фамилия: ");
        String surNameDir = scanner.nextLine();

        Employee director = new Employee(nameDir, surNameDir);
        Company company = new Company(nameCompany, director);

        createTreeDepWithEmployee(company);

        System.out.print("Введите название отдела, для которого нужно вывести список подчиненных: ");
        String curDep = scanner.nextLine();

        //сейчас выводится вместе с руководителем отдела , так как выводится весь список сотрудников отдела с его подотделами
        company.findAndPrintSubordinates(curDep);
    }

    public static void createTreeDepWithEmployee(Object obj) {
        //сотрудники в отделах и руководители далее генерируются с учетом названия отдела
        Scanner scanner = new Scanner(System.in);
        Integer countDep;
        Integer countEmpl;

        //создание подотделов и сотрудников
        if (obj instanceof Company) {
            System.out.println("Введите количество отделов первого уровня компании: ");
            countDep = scanner.nextInt();
            Company company = (Company) obj;
            for (int i = 1; i <= countDep; i++) {
                Department department = new Department(i, new Employee("head" + i, ""));
                createTreeDepWithEmployee(department);
                company.addDepartment(department);
            }
        } else {
            if (obj instanceof Department) {
                Department curDepartment = (Department) obj;

                System.out.println(String.format("Введите количество сотрудников отдела '%s'", ((Department) obj).getName()));
                countEmpl = scanner.nextInt();
                String curDepName = curDepartment.getName();
                for (int i = 1; i <= countEmpl; i++) {
                    Employee employee = new Employee("empl" + curDepName + "_" + (curDepartment.getEmployees().size() + 1), "");
                    curDepartment.addEmployee(employee);
                }

                System.out.println(String.format("Введите количество подотделов отдела '%s'", ((Department) obj).getName()));
                countDep = scanner.nextInt();
                for (int i = 1; i <= countDep; i++) {
                    String nameDep = curDepName + "_" + i;
                    Department subDepartment = new Department(nameDep, new Employee("head" + nameDep, ""));
                    createTreeDepWithEmployee(subDepartment);
                    curDepartment.addSubDepartment(subDepartment);
                }
            }
        }
    }
}
