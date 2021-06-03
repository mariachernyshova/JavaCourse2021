package classwork.sample;

public class HalfStuff extends Employee implements ParticipantOfMeeting {

    public HalfStuff(String position, int salary, Contract contract, Department department) {
        super(position, salary, department);
//        super.contract = contract; //можно this, так как стафф расширяет Employee и имеет все его поля
        super.workDayDuration = 4;
        super.department = department;
    }

    @Override
    public void goToMeetingRoom() {
        if (workHours < workDayDuration) {
            System.out.println("I go to meeting");
        } else {
            System.out.println("I go to home");
        }
    }
}
