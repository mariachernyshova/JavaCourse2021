package classwork.sample;

import javax.swing.Icon;
import java.awt.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    protected String firstName;
    protected String surName;
    protected String middleName;
    protected Passport passport;
    protected static long id = 1;
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

        public short getPrefix() {
            return prefix;
        }
        public int getNumber() {
            return number;
        }

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

    public Person(String firstName, String surName, String middleName, LocalDate birthDay) {
        this(firstName, surName, middleName);
        this.setBirthDay(birthDay);
    }

    public Person(String firstName, String surName, String middleName) {
        this.firstName = firstName;
        this.surName = surName;
        this.middleName = middleName;
    }

    public Person(String firstName, String surName, String middleName, LocalDate birthDay, Passport passport, Sex sex) {
        this(firstName, surName, middleName);
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

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getBirthDayString() {
        return birthDay == null? "" : birthDay.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
    }

    public String getFullName() {
        return surName + "  " + firstName + "    " + middleName;
    }

    public String getPassportFullNumber() {
        return passport.prefix + " " + passport.number;
    }

    public String getPassportPrefix() {
        return passport == null ? "" : passport.prefix + "";
    }

    public String getPassportNumber() {
        return passport == null ? "" : passport.number + "";
    }
}