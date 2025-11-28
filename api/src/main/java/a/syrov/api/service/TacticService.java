package a.syrov.api.service;

import a.syrov.api.dao.TacticDAO;
import a.syrov.api.dto.TacticDTO;
import a.syrov.api.entity.Tactic;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacticService {
    private final TacticDAO tacticDAO;

    public TacticService(TacticDAO tacticDAO) {
        this.tacticDAO = tacticDAO;
    }

    public Tactic createTactic(Tactic tactic) {
        return tacticDAO.save(tactic);
    }
    @Transactional
    public List<TacticDTO> getAllTactics() {
        return tacticDAO.findAll().stream().map(TacticDTO::from).toList();
    }

    public Tactic findById(Long id) {
        return tacticDAO.findById(id).orElse(null);
    }
}
