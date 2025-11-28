package a.syrov.api.service;

import a.syrov.api.dao.PlayerDAO;
import a.syrov.api.dao.TeamDAO;
import a.syrov.api.entity.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamDAO teamDAO;

    public TeamService(TeamDAO teamDAO, PlayerDAO playerDAO) {
        this.teamDAO = teamDAO;
    }

    public Team createTeam(Team team) {
        return teamDAO.save(team);
    }

    public List<Team> getAllTeams() {
        return teamDAO.findAll();
    }

}
