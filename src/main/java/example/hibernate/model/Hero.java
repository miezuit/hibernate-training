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

    @OneToMany(mappedBy="owner", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    public Hero() {
    }

    public Hero(String name, Integer life, Integer power
                ) {
        this.life = life;
        this.power = power;
        this.name = name;
    }

    public void addItem(String name, Integer power) {
        Item item = new Item(name, power, this);

        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Hero{" + "id=" + id + ", name='" + name + '\'' + ", life=" + life + ", power=" + power + '}';
    }
}
