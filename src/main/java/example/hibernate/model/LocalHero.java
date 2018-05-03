package example.hibernate.model;

public class LocalHero extends Hero {

    private String residenceCity;

    private LocalHero() {
    }

    public LocalHero(String name, Integer life, Integer power, String residenceCity) {
        super(name, life, power);
        this.residenceCity = residenceCity;
    }

}
