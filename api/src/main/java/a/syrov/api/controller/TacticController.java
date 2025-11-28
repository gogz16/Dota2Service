package a.syrov.api.controller;

import a.syrov.api.dao.TacticDAO;
import a.syrov.api.dto.TacticDTO;
import a.syrov.api.entity.Pick;
import a.syrov.api.entity.Tactic;
import a.syrov.api.service.PickService;
import a.syrov.api.service.TacticService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tactics")
public class TacticController {
    private final TacticService tacticService;
    private final PickService pickService;

    public TacticController(TacticService tacticService, TacticDAO tacticDAO, PickService pickService) {
        this.tacticService = tacticService;
        this.pickService = pickService;
    }

    @PostMapping
    public Tactic createTactic(@RequestBody Tactic tactic) {
        return tacticService.createTactic(tactic);
    }

    @GetMapping
    @Transactional
    public List<TacticDTO> getAllTactics() {
        return tacticService.getAllTactics();
    }

    @PostMapping("/{id}/picks")
    public Pick createPick(@PathVariable Long id, @RequestBody Pick pick) {
        Tactic tactic = tacticService.findById(id);
        pick.setTactic(tactic);
        return  pickService.createPick(pick);
    }

    @GetMapping("/{id}/picks")
    public List<Pick> getByTactic(@PathVariable Long id) {
        return pickService.getByTactic(id);
    }
}
