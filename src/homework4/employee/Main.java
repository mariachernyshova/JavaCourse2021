package homework4.employee;

import java.util.Scanner;

/**
 * Поиск сотрудников на предприятии
 * Предприятие состоит из отделов. В каждом отделе трудятся сотрудники. В каждом отделе есть один руководитель.
 * Отделы представляю иерархию, то есть один отдел может включать в себя список подотделов.
 *
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

        //создадим 3 отдела
        /**
         *          1            |           2            |             3
         *   1_1    |     1_2    |    2_1    |     2_2    |     3_1          3_2
         * 1_11 1_12|  1_21 1_22 | 2_11 2_12 | 2_21  2_22 | 3_11  3_12 | 3_21  3_22 -- не создаются в коде, т.е. сейчас только первые два уровня схемы
         */

        //сотрудники в отделах и руководители далее генерируются с учетом названия отдела
        for (int i = 1; i <= 3; i++) {
            Department department = new Department(i, new Employee("head" + i, ""));
            company.addDepartment(department);
            for (int j = 1; j <= 2; j++) {
                String nameDep = company.getDepartments().get(i - 1).getName() + "_" + j;
                Department subDepartment = new Department(nameDep, new Employee("head" + nameDep, ""));
                company.getDepartments().get(i - 1).addSubDepartment(subDepartment);
            }
        }
        //добавим по 2 сотрудника в отдел
        for (Department department : company.getDepartments()) {
            String nameDep = department.getName();
            department.addEmployee(new Employee("empl" + nameDep + "_" + (department.getEmployees().size() + 1), ""));
            department.addEmployee(new Employee("empl" + nameDep + "_" + (department.getEmployees().size() + 1), ""));
            if (department.getSubDepartments().size() > 0) {
                for (Department subDep : department.getSubDepartments()) {
                    String nameSubDep = subDep.getName();
                    subDep.addEmployee(new Employee("empl" + nameSubDep + "_" + (subDep.getEmployees().size() + 1), ""));
                    subDep.addEmployee(new Employee("empl" + nameSubDep + "_" + (subDep.getEmployees().size() + 1), ""));
                }
            }
        }

        //подчиненные директора:
        System.out.println("Подчиненные директора:");
        company.getDepartments().forEach(dep -> {
            //руководители отделов
            System.out.println(dep.getHead().toString());
            //сотрудники отделов
            dep.getEmployees().forEach(emp -> {
                System.out.print("\t" + emp.toString());
            });
            System.out.println();

            dep.getSubDepartments().forEach(subDep -> {
                System.out.println("\t\t" + subDep.getHead().toString());
                subDep.getEmployees().forEach(emp -> {
                    System.out.print("\t\t\t" + emp.toString());
                });
                System.out.println();
            });
            System.out.println();
        });

        System.out.print("Введите название отдела, для которого нужно вывести список подчиненных: ");
        String curDep = scanner.nextLine();

        //сейчас выводится вместе с руководителем отдела , так как выводится весь список сотрудников отдела с его подотделами
        company.findAndPrintSubordinates(curDep);
    }
}
