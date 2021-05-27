package homework3.employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Задача отсортировать список сотрудников в следующем порядке: сначала идут сотрудники более крупного подразделения, потом более мелкого. Сотрудников одного подразделения распечатывать в порядке убывания должности: сначала руководитель, потом подченные. Для сотруднико одинаковой должности и в одном офисе отсортировать по алфавиту.
 *
 * Пример:
 * List<Employee> l
 * l.add(new Employee("Саша","сотрудник", "региональный офис"));
 * l.add(new Employee("Оля","зам. руководителя", "городской офис"));
 * l.add(new Employee("Сергей","стажер", "городской офис"));
 * l.add(new Employee("Катя","сотрудник", "региональный офис"));
 * l.add(new Employee("Игорь","руководитель", "региональный офис"));
 *
 * Collections.sort(l)
 *
 * Игорь руководитель региональный офис
 * Катя сотрудник региональный офис
 * Саша сотрудник региональный офис
 * Оля зам. руководителя городской офис
 * Сергей стажер городской офис
 */

class Employee implements Comparable<Employee> {
    String name;
    String position;
    //значения в порядке убывания важности: руководитель, зам. руководителя, начальник отдела, старший сотрудник,
    // сотрудник, стажер.
    String department;
    //в порядке убывания важности: центральный офис, региональный офис, областной офис, городской офис, районный офис.

    public Employee (String name, String position, String department) {
        this.name = name;
        this.position = position;
        this.department = department;
    }

    public int getPosition(String position) {
        switch (position) {
            case "руководитель" :
                return 6;
            case "зам. руководителя":
                return 5;
            case "начальник отдела":
                return 4;
            case "старший сотрудник":
                return 3;
            case "сотрудник":
                return 2;
            case "стажер":
                return 1;
            default:
                return 0;
        }
    }
    public int getDepartment(String department) {
        switch (department) {
            case "центральный офис":
                return 5;
            case "региональный офис":
                return 4;
            case "областной офис":
                return 3;
            case "городской офис":
                return 2;
            case "районный офис":
                return 1;
            default:
                return 0;
        }
    }

    //Метод compareTo в Java сравнивает вызывающий объект с объектом, переданным в качестве параметра,
    //и возвращает в результате выполнения сравнения целое число:
    //положительное, если вызывающий объект больше объекта, переданного в качестве параметра;
    //отрицательное, если вызывающий объект меньше объекта, переданного в качестве параметра;
    //нуль, если объекты равны.
    //нужен наоборот список от большего к меньшему
    @Override
    public int compareTo(Employee o) {
        int dep =  getDepartment(o.department) - getDepartment(this.department);
        if (dep != 0) {
            return dep;
        }

        int pos = getPosition(o.position) - getPosition(this.position);
        if (pos != 0) {
            return pos;
        }

        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("%s: %s(%s)", name, position, department);
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Саша","сотрудник", "региональный офис"));
        employeeList.add(new Employee("Оля","зам. руководителя", "городской офис"));
        employeeList.add(new Employee("Сергей","стажер", "городской офис"));
        employeeList.add(new Employee("Катя","сотрудник", "региональный офис"));
        employeeList.add(new Employee("Игорь","руководитель", "региональный офис"));

        System.out.printf("%s\n", employeeList);
        Collections.sort(employeeList);
        System.out.printf("Отсортированный список:\n\t%s\n", employeeList);
    }
}
