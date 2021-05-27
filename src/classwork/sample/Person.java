package classwork.sample;

import javax.swing.Icon;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;

public class Person {
    protected String firstName;
    protected String surName;
    protected Passport passport;
    private LocalDate birthDay;
    private Sex sex;

    enum Sex {
        MALE(new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {

            }

            @Override
            public int getIconWidth() {
                return 0;
            }

            @Override
            public int getIconHeight() {
                return 0;
            }
        }),
        FEMALE(new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {

            }

            @Override
            public int getIconWidth() {
                return 0;
            }

            @Override
            public int getIconHeight() {
                return 0;
            }
        });

        private Icon picture;
        Sex(Icon picture) {
            this.picture = picture;
        }
    }

    //внутренний (локальный) класс
    class Passport {
        private short prefix;
        private int number;

        private String issuer;
        private String issuerCode;
        private LocalDate dateOfIssue;

        public String getIssuerInfo() {
            class Issuer {
                private String issuerFullInfo;
                public Issuer() {
                    issuerFullInfo = issuer + "\n" + issuerCode;
                }
                String getIssuerFullInfo() {
                    return issuerFullInfo;
                }
            }

            return new Issuer().getIssuerFullInfo();
        }
    }

    static class AgeCalculator{
        public static int getAge(LocalDate date) {
            return Period.between(date, LocalDate.now()).getYears();
        }
    }

//    public Person() {
//
//    }

    public Person(String firstName, String surName, LocalDate birthDay) {
        this(firstName, surName);
        this.setBirthDay(birthDay);
    }

    public Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public Person(String firstName, String surName, LocalDate birthDay, Passport passport, Sex sex) {
        this(firstName, surName);
        this.surName = surName;
        this.setBirthDay(birthDay);
        this.passport = passport;
//        this.sex = sex;
        this.sex = Sex.MALE;
        }

    public void setBirthDay(LocalDate birthDay) {
        if (!birthDay.isAfter(LocalDate.now())) {
            this.birthDay = birthDay;
        } else {
            new Exception("Greet from future");
        }
    }

    public String getPassportFullNumber() {
        return passport.prefix + " " + passport.number;
    }

}