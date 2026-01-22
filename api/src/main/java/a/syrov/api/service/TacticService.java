package a.syrov.api.service;

import a.syrov.api.dao.TacticDAO;
import a.syrov.api.dto.TacticDTO;
import a.syrov.api.entity.Tactic;
import a.syrov.api.mapper.TacticMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacticService {
    private final TacticDAO tacticDAO;
    private final TacticMapper tacticMapper;

    public TacticService(TacticDAO tacticDAO, TacticMapper tacticMapper) {
        this.tacticDAO = tacticDAO;
        this.tacticMapper = tacticMapper;
    }

    public Tactic createTactic(TacticDTO tacticDTO) {
        return tacticDAO.save(tacticMapper.toTactic(tacticDTO));
    }

    @Transactional
    public List<TacticDTO> getAllTactics() {
        List<Tactic> tactics = tacticDAO.findAll();
        return tacticMapper.fromTactics(tactics);
    }

    public Tactic findById(Long id) {
        return tacticDAO.findById(id).orElse(null);
    }
}
