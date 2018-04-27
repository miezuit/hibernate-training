package example.hibernate.application;

import example.hibernate.model.Hero;
import example.hibernate.model.Villain;
import example.hibernate.repository.HeroRepository;
import example.hibernate.repository.VillainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("example.hibernate")
@EnableJpaRepositories("example.hibernate.repository")
@EntityScan("example.hibernate.model")
public class Application implements CommandLineRunner {

    private final HeroRepository repository;
    private final VillainRepository villainRepository;

    @Autowired
    public Application(HeroRepository repository, VillainRepository villainRepository) {
        this.repository = repository;
        this.villainRepository = villainRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws IOException {
        save();
        //showHeroes();
    }

    @Transactional
    protected void showHeroes() {
        List<Hero> heroes;

        Hero hero = repository.findFirstByName("Batman");

        System.out.println(hero);
    }

    @Transactional
    protected void save() {

        Hero batman = new Hero("Batman", 500, 1000);

        Villain joker = new Villain("Joker", 300, 700);
        Villain catWoman = new Villain("Cat Woman", 200, 300);

        batman.addEnemy(joker);
        batman.addEnemy(catWoman);

        repository.save(batman);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args).close();
    }

}
