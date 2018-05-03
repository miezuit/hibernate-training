package example.hibernate.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("local")
public class LocalHero extends Hero {

    private String residenceCity;

    private LocalHero() {
    }

    public LocalHero(String name, Integer life, Integer power, String residenceCity) {
        super(name, life, power);
        this.residenceCity = residenceCity;
    }

    @Override
    public String toString() {
        return "LocalHero{" +
                super.toString() + ", residenceCity='" + residenceCity + '\'' +
                '}';
    }
}
