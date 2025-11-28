package a.syrov.api.dao;

import a.syrov.api.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDAO extends JpaRepository<Team, Long> {

}
