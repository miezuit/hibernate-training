package example.hibernate.model;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "power")
    private Integer power;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="hero_id")
    private Hero owner;

    public Item() {
    }

    public Item(String name, Integer power, Hero owner) {
        this.name = name;
        this.power = power;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name='" + name + '\'' + ", power=" + power + '}';
    }
}
