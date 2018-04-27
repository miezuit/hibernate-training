package example.hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer life;
    private Integer power;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name="enemies",
            joinColumns=@JoinColumn(name="hero_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="villain_id", referencedColumnName="id"))
    private Set<Villain> enemies = new HashSet<>();

    public Hero() {
    }

    public Hero(String name, Integer life, Integer power
                ) {
        this.life = life;
        this.power = power;
        this.name = name;
    }

    public void addEnemy(Villain villain) {
        enemies.add(villain);
        villain.addEnemy(this);
    }

    @Override
    public String toString() {
        return "Hero{" + "id=" + id + ", name='" + name + '\'' + ", enemies=" + enemies + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hero hero = (Hero) o;

        return name.equals(hero.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
