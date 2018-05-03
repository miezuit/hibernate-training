package example.hibernate.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class Hero {
    @Id
    private Long id;
    private String name;
    private Integer life;
    private Integer power;

    public Hero() {
    }

    public Hero(Long id, String name, Integer life, Integer power
                ) {
        this.id = id;
        this.life = life;
        this.power = power;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" + "id=" + id + ", name='" + name + '\'' + ", life=" + life + ", power=" + power + '}';
    }
}
