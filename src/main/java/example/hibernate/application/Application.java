package example.hibernate.application;

import example.hibernate.model.ExtraterrestrialHero;
import example.hibernate.model.Hero;
import example.hibernate.model.LocalHero;
import example.hibernate.repository.HeroRepository;
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

    @Autowired
    public Application(HeroRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void run(String... args) throws IOException {
        save();
        showHeroes();
    }

    @Transactional
    protected void save() {

        Hero superman = new LocalHero("Superman", 1000, 2000, "New York");
        Hero thor = new ExtraterrestrialHero("Thor", 1000, 1900, "Asgard");

        repository.save(superman);
        repository.save(thor);
    }

    @Transactional
    protected void showHeroes() {
        List<Hero> heroes;

        Hero hero = repository.findFirstByName("Superman");

        System.out.println(hero);

        hero = repository.findFirstByName("Thor");

        System.out.println(hero);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args).close();
    }

}
