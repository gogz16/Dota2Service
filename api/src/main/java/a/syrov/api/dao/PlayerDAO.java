package a.syrov.api.dao;

import a.syrov.api.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerDAO extends JpaRepository<Player, Long> {
    List<Player> findByTeamId(Long teamId);
}
