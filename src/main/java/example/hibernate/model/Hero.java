package example.hibernate.model;

import javax.persistence.*;
import java.util.Date;

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

    public String getName() {
        return name;
    }

    public Integer getLife() {
        return life;
    }

    public Integer getPower() {
        return power;
    }

    //    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="profile_id")
//    //private HeroProfile profile;

    public Hero() {
    }

    public Hero(String name, Integer life, Integer power
            //, //HeroProfile profile
                ) {
        this.life = life;
        this.power = power;
        this.name = name;
        //this.profile = profile;
    }

//    public HeroProfile getProfile() {
//        //return this.profile;
//    }

    @Override
    public String toString() {
        return "Hero{" + "id=" + id + ", name='" + name + '\'' + ", life=" + life + ", power=" + power + '}';
    }
}
