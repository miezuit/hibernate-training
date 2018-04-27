package example.hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Villain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer life;
    private Integer power;
    @ManyToMany(mappedBy="enemies")
    private Set<Hero> enemies = new HashSet<>();;

    public Villain() {
    }

    public Villain(String name, Integer life, Integer power
    ) {
        this.life = life;
        this.power = power;
        this.name = name;
    }

    public void addEnemy(Hero hero) {
        enemies.add(hero);
    }

    @Override
    public String toString() {
        return "Villain{" + "id=" + id + ", name='" + name + '\'' + ", life=" + life + ", power=" + power + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Villain villain = (Villain) o;

        return name.equals(villain.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
