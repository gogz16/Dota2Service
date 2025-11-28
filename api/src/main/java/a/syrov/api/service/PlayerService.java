package a.syrov.api.service;

import a.syrov.api.dao.PlayerDAO;
import a.syrov.api.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    public final PlayerDAO playerDAO;

    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public Player createPlayer(Player player) {
        return playerDAO.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerDAO.findAll();
    }

    public List<Player> getPlayersByTeam(Long teamId) {
        return playerDAO.findByTeamId(teamId);
    }
}
