package example.hibernate.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class LocalHero extends Hero {

    private String residenceCity;

    private LocalHero() {
    }

    public LocalHero(Long id, String name, Integer life, Integer power, String residenceCity) {
        super(id, name, life, power);
        this.residenceCity = residenceCity;
    }

    @Override
    public String toString() {
        return "LocalHero{" +
                super.toString() + ", residenceCity='" + residenceCity + '\'' +
                '}';
    }
}
