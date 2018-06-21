package example.hibernate.application;

import example.hibernate.application.command.CreateHeroCommand;
import example.hibernate.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class HeroApplicationService {

    private final HeroRepository repository;

    @Autowired
    public HeroApplicationService(HeroRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void createHero(CreateHeroCommand createHeroCommand) {

    }

    @Transactional
    public void findHeroWithId(String id) {

    }
}
