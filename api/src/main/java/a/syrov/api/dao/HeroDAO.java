package a.syrov.api.dao;

import a.syrov.api.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroDAO extends JpaRepository<Hero, Long> {

}
