package example.hibernate.application;

import java.util.*;
import example.hibernate.application.command.CreateHeroCommand;
import example.hibernate.model.Hero;
import example.hibernate.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HeroApplicationService {

    private final HeroRepository repository;

    @Autowired
    public HeroApplicationService(HeroRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Hero createHero(CreateHeroCommand command) {
        Hero hero = new Hero(command.getName(), command.getLife(), command.getPower());
        repository.save(hero);
        return hero;
    }

    @Transactional
    public Hero findHeroWithId(Long id) {
        return repository.findOne(id);
    }

    @Transactional
    public List<Hero> findHeroesNamed(String name) {
        return repository.findByName(name);
    }

    @Transactional
    public void retireHero(Long id) {
        repository.delete(id);
    }
}
