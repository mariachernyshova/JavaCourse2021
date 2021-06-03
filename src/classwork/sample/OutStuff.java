package classwork.sample;

import java.time.LocalDate;

public class OutStuff extends Employee{

    public OutStuff(String position, int salary, Contract contract) {
        super(position, salary, null);
        super.contract = contract; //можно this, так как стафф расширяет Employee и имеет все его поля
    }

    public void connectToVPN() {
        System.out.println("I'm connected to VPN");
    }

    @Override
    public void goWork() {
        System.out.println("I'm get up");
        System.out.println("I'm take a cap of coffee");
        System.out.println("I'm log in on our corporate system");
        connectToVPN();
        super.goWork();
    }

    @Override
    public void doWork() {
        System.out.println("I'm coding System for ordinary client");
        super.doWork();
    }

    @Override
    public void finishWork() {
        super.finishWork();
    }
}
