package classwork.sample;

import java.time.LocalDate;

public class Person {
    protected String firstName;
    protected String surName;
    private LocalDate birthDay;

    public void setBirthDay(LocalDate birthDay) {
        if (!birthDay.isAfter(LocalDate.now())) {
            this.birthDay = birthDay;
        } else {
            new Exception("Greet from future");
        }
    }

    public Person(String firstName, String surName, LocalDate birthDay) {
        this(firstName, surName);
        this.setBirthDay(birthDay);
    }

    public Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }
}