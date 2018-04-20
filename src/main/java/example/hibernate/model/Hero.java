package example.hibernate.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hero")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "life")
    private Integer life;
    @Column(name = "power")
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
