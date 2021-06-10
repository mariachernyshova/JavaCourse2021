package classwork.sample;

public class EmployeeFactory {
    public static Employee createEmloyee(String position, int salary, Contract contract,
                                         Department department, int workDayDuration) {
        Employee e = null;
        if (workDayDuration > 4) {
            e = new Stuff(position, salary, contract, department);
        } else {
            e = new HalfStuff(position, salary, contract, department);
        }

        return e;
    }
}
