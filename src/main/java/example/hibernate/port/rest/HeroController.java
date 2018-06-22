package example.hibernate.port.rest;

import java.util.*;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import example.hibernate.application.HeroApplicationService;
import example.hibernate.application.command.CreateHeroCommand;
import example.hibernate.model.Hero;
import example.hibernate.port.rest.exception.NotFoundException;

@RestController
@RequestMapping("/api/v1/hero")
public class HeroController {
    private final HeroApplicationService heroApplicationService;

    @Autowired
    public HeroController(HeroApplicationService heroApplicationService) {
        this.heroApplicationService = heroApplicationService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Hero findHeroById(@PathVariable Long id) {
        Hero hero = heroApplicationService.findHeroWithId(id);

        if (hero == null) {
            throw new NotFoundException();
        }

        return hero;
    }

    @RequestMapping(value = "/named/{name}", method = RequestMethod.GET)
    public List<Hero> findHeroByName(@PathVariable String name) {
        return heroApplicationService.findHeroesNamed(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Hero createHero(@RequestBody CreateHeroCommand createHero) {
        return heroApplicationService.createHero(createHero);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void retireHero(@PathVariable Long id) {
        heroApplicationService.retireHero(id);
    }
}
