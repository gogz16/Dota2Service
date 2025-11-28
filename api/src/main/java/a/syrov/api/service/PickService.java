package a.syrov.api.service;

import a.syrov.api.dao.HeroDAO;
import a.syrov.api.dao.PickDAO;
import a.syrov.api.dao.PlayerDAO;
import a.syrov.api.dao.TacticDAO;
import a.syrov.api.entity.Pick;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PickService {
    private final PickDAO pickDAO;
    private final TacticDAO tacticDAO;
    private final PlayerDAO playerDAO;
    private final HeroDAO heroDAO;

    public PickService(PickDAO pickDAO, TacticDAO tacticDAO, PlayerDAO playerDAO, HeroDAO heroDAO) {
        this.pickDAO = pickDAO;
        this.tacticDAO = tacticDAO;
        this.playerDAO = playerDAO;
        this.heroDAO = heroDAO;
    }

    public Pick createPick(Pick pick) {
        return pickDAO.save(pick);
    }

    public List<Pick> getByTactic(Long id) {
        return pickDAO.findAllByTactic_Id(id);
    }
}
