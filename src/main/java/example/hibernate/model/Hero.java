package example.hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer life;
    private Integer power;

    public Hero() {
    }

    public Hero(String name, Integer life, Integer power
                ) {
        this.life = life;
        this.power = power;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" + "id=" + id + ", name='" + name + '\'' + ", life=" + life + ", power=" + power + '}';
    }
}
