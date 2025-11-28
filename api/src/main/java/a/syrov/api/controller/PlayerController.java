package a.syrov.api.controller;

import a.syrov.api.entity.Player;
import a.syrov.api.service.PickService;
import a.syrov.api.service.PlayerService;
import a.syrov.api.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;
    private final TeamService teamService;

    public PlayerController(PlayerService playerService, PickService pickService, TeamService teamService, TeamService teamService1) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/team/{id}")
    public List<Player> getPlayersByTeam(@PathVariable Long id) {
        return playerService.getPlayersByTeam(id);
    }

}
