package example.hibernate.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("extra")
public class ExtraterrestrialHero extends Hero {

    private String residencePlanet;

    private ExtraterrestrialHero() {
    }

    public ExtraterrestrialHero(String name, Integer life, Integer power, String residencePlanet) {
        super(name, life, power);
        this.residencePlanet = residencePlanet;
    }

    @Override
    public String toString() {
        return "ExtraterrestrialHero{" +
                super.toString() + ", residencePlanet='" + residencePlanet + '\'' +
                '}';
    }
}
