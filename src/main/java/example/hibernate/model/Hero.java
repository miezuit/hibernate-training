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
    @ElementCollection
    @CollectionTable(
            name="nicknames",
            joinColumns=@JoinColumn(name="hero_id")
    )
    @Column(name="nickname")
    private Set<String> nicknames = new HashSet<>();

    public Hero() {
    }

    public Hero(String name, Integer life, Integer power
                ) {
        this.life = life;
        this.power = power;
        this.name = name;
    }

    public void addNickname(String nickname) {
        nicknames.add(nickname);
    }

    @Override
    public String toString() {
        return "Hero{" + "id=" + id + ", name='" +
                name + '\'' + ", life=" + life + ", power=" + power + ", nicknames=" + nicknames + " }";
    }
}
