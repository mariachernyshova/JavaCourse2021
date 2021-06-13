package homework7.csvparser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainParse {
    public static void main(String[] args) {
        //получить два списка
        List<ParseError> errors = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        String departmentsParse = "id_dep,dep_name\n" +
                "1,IT\n" +
                "2,Accounts\n" +
                "3,Sales";

//        String departmentsParse =
//                "i,IT\n" +
//                        "2,Accounts\n" +
//                        "3,Sales";

        String employessParse = "id_emp,emp_name,id_dep\n" +
                "1,Jack,1\n" +
                "2,Anna,1\n" +
                "3,Bob,2\n" +
                "4,Kathy,3\n" +
                "5,Nick,2";

        String[] depStrings = departmentsParse.split("\n");
        String[] emplStrings = employessParse.split("\n");

        System.out.println("Ошибки в departments:");
        //dep
        //обработка первой строки
        if (!depStrings[0].equals("id_dep,dep_name")) {
            errors.add(new ParseError("строка 0", "первая строка должна быть заголовком 'id_dep,dep_name'"));
        }
        //создаем dep
        for (int i = 1; i < depStrings.length; i++) {
            //разделяем по запятым
            String[] department = depStrings[i].split(",");
            if (department.length != 2) {
                //обработка количества полей
                errors.add(new ParseError("строка " + i, "Число полей в строке не совпадает с заданной структурой"));
            }
            if (!department[0].matches("\\d+")) {
                //id не число
                errors.add(new ParseError("строка " + i, "В поле id содержится текст"));
            }

            if (errors.size() == 0) {
                departments.add(new Department(Integer.parseInt(department[0]), department[1]));
            }
        }
        printErrors(errors);

        errors.clear();
        System.out.println("Ошибки в employees:");
        if (!departments.isEmpty()) {
            //обработка первой строки
            if (!emplStrings[0].equals("id_emp,emp_name,id_dep")) {
                errors.add(new ParseError("строка 0", "первая строка должна быть заголовком 'id_emp,emp_name,id_dep'"));
            }
            //создаем empl
            for (int i = 1; i < emplStrings.length; i++) {
                //разделяем по запятым
                String[] employee = emplStrings[i].split(",");
                if (employee.length != 3) {
                    //обработка количества полей
                    errors.add(new ParseError("строка " + i, "Число полей в строке не совпадает с заданной структурой"));
                }
                if (!employee[0].matches("\\d+")) {
                    //id не число
                    errors.add(new ParseError("строка " + i, "В поле id содержится текст"));
                }

                if (!departments.stream().map(Department::getId).collect(Collectors.toList()).contains(Integer.parseInt(employee[2]))) {
                    errors.add(new ParseError("строка " + i, "Сотрудник ссылается на несуществующее подразделение"));
                }

                if (errors.size() == 0) {
                    int idDep = Integer.parseInt(employee[2]);
                    Department findDep = departments.stream()
                            .filter(v-> v.getId() == idDep)
                            .collect(Collectors.toList()).get(0);
                    Employee empl = new Employee(Integer.parseInt(employee[0]), employee[1]);
                    findDep.addEmployee(empl);
                }
            }
        }
        printErrors(errors);

        printDepartments(departments);
//        printErrors(errors);
    }

    public static void printErrors(List<ParseError> erorrs) {
        for (ParseError error : erorrs) {
            System.out.println(error.getLine() + ": " + error.getErrorText());
        }

    }

    public static void printDepartments(List<Department> deps) {
        for (Department dep : deps) {
            System.out.println(dep.getId() + "(" + dep.getName() + ")" + ": " + dep.getEmployees().toString());
//            dep.getEmployees().forEach(empl -> {
//                System.out.println("\t" + empl.toString());
//            });
        }

    }

}
