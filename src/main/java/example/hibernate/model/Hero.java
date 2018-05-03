package example.hibernate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer life;
    private Integer power;
    @Embedded
    private HeroProfile profile;

    public String getName() {
        return name;
    }

    public Integer getLife() {
        return life;
    }

    public Integer getPower() {
        return power;
    }

    public Hero() {
    }

    public Hero(String name, Integer life, Integer power, HeroProfile profile
                ) {
        this.life = life;
        this.power = power;
        this.name = name;
        this.profile = profile;
    }

    public HeroProfile getProfile() {
        return this.profile;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", life=" + life +
                ", power=" + power +
                ", profile=" + profile +
                '}';
    }
}
