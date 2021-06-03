package classwork.sample;

public class Stuff extends Employee implements ParticipantOfMeeting {

    public Stuff(String position, int salary, Contract contract, Department department) {
        super(position, salary, department);
        super.contract = contract; //можно this, так как стафф расширяет Employee и имеет все его поля
    }

    public void goToMeetingRoom() {
        System.out.println("I go to meeting");
    }

    @Override
    public void goWork() {
        System.out.println("I'm catch a taxi and run to our office");
        System.out.println("I'm check in our control system");
        System.out.println("I'm log in on our corporate system");
        goToMeetingRoom();
        super.goWork();
    }

    @Override
    public void doWork() {
        System.out.println("I'm coding System for VIP client");
        super.doWork();
    }

    @Override
    public void finishWork() {
        super.finishWork();
    }
}
