package a.syrov.api.dao;

import a.syrov.api.entity.Tactic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacticDAO extends JpaRepository<Tactic, Long> {
}
