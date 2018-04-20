package example.hibernate.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import example.hibernate.model.Gender;
import example.hibernate.model.Hero;
import example.hibernate.model.HeroProfile;
import example.hibernate.repository.HeroRepository;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("example.hibernate")
public class Application implements CommandLineRunner {

    private final HeroRepository repository;

    @Autowired
    public Application(HeroRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void run(String... args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Hero superman = new Hero("Superman", 1000, 2000);

        objectMapper.writeValue(new File("target/hero.json"), superman);

        String json = "{\"name\":\"Superman\",\"life\":1000,\"power\":2000}";

        Hero hero = objectMapper.readValue(json, Hero.class);

        //save();
        //showHeroes();
    }

    @Transactional
    protected void showHeroes() {
        List<Hero> heroes;

        Hero hero = repository.findFirstByName("Superman");

        System.out.println(hero);

        //System.out.println(hero.getProfile());

        //heroes = repository.findHeroesByGender(Gender.MALE);
    }

    @Transactional
    protected void save() {

        HeroProfile profile = new HeroProfile(
                "0734890178",
                Gender.MALE,
                new GregorianCalendar(1938, Calendar.FEBRUARY, 29).getTime()
        );

        Hero superman = new Hero("Superman", 1000, 2000);

        repository.save(superman);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args).close();
    }

}
