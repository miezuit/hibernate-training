package example.hibernate.model;

public class ExtraterrestrialHero extends Hero {

    private String residencePlanet;

    private ExtraterrestrialHero() {
    }

    public ExtraterrestrialHero(String name, Integer life, Integer power, String residencePlanet) {
        super(name, life, power);
        this.residencePlanet = residencePlanet;
    }
}
