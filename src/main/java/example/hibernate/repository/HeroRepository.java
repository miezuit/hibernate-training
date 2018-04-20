package example.hibernate.repository;

import com.sun.tools.javah.Gen;
import example.hibernate.model.Gender;
import example.hibernate.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

    List<Hero> findByName(String name);

    Hero findFirstByName(String name);

    List<Hero> findByNameAndAndPower(String name, Integer power);

    List<Hero> findHeroesByPowerBetween(Integer smallerPower, Integer biggerPower);

    @Query("SELECT h FROM Hero h WHERE h.profile.gender = :gender")
    List<Hero> findHeroesByGender(@Param("gender") Gender gender);

    @Query("SELECT h FROM Hero h WHERE h.life = 0")
    List<Hero> findDeadHeroes();

    @Query("SELECT h FROM Hero h WHERE UPPER(h.name) = UPPER(:name)")
    List<Hero> findByNameCaseInsensitive(@Param("name") String name);

}
