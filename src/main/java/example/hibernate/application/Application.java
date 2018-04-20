package example.hibernate.application;

import example.hibernate.model.Gender;
import example.hibernate.model.Hero;
import example.hibernate.model.HeroProfile;
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
import java.util.Calendar;
import java.util.GregorianCalendar;
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
    protected void showHeroes() {
        List<Hero> heroes;

        Hero hero = repository.findFirstByName("Superman");

        System.out.println(hero);

        System.out.println(hero.getProfile());

        System.out.println(hero.getProfile().getHero());

        heroes = repository.findHeroesByGender(Gender.MALE);

        heroes.stream().forEach(System.out::println);
    }

    @Transactional
    protected void save() {

        HeroProfile profile = new HeroProfile(
                "0734890178",
                Gender.MALE,
                new GregorianCalendar(1938, Calendar.FEBRUARY, 29).getTime()
        );

        Hero superman = new Hero("Superman", 1000, 2000, profile);

        profile.setHero(superman);

        repository.save(superman);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args).close();
    }

}
