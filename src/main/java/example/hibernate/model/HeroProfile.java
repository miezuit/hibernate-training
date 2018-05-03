package example.hibernate.model;

import javax.persistence.*;
import java.util.Date;

@Embeddable
public class HeroProfile {

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birth_date")
    private Date dateOfBirth;

    public HeroProfile() {
    }

    public HeroProfile(String phoneNumber, Gender gender, Date dateOfBirth) {
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "HeroProfile{" + "phoneNumber='" + phoneNumber + '\'' + ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
