package example.hibernate.repository;

import example.hibernate.model.Villain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VillainRepository extends JpaRepository<Villain, Long> {

    List<Villain> findByName(String name);

    Villain findFirstByName(String name);
}
