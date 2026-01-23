package a.syrov.api.controller;

import a.syrov.api.client.OpenDotaApiClient;
import a.syrov.api.entity.Hero;
import a.syrov.api.service.HeroService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hero")
public class HeroController {
    private final HeroService heroService;
    private final OpenDotaApiClient openDotaApiClient;

    public HeroController(HeroService heroService, OpenDotaApiClient openDotaApiClient) {
        this.heroService = heroService;
        this.openDotaApiClient = openDotaApiClient;
    }
    // все герои из OpenDota
    @GetMapping()
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Map<Integer, Hero> getOpenDotaHero() {
        return openDotaApiClient.getHero();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Hero getHero(@PathVariable Long id) {
        return heroService.getHero(id);
    }

    @PostMapping()
    public Hero saveHero(@RequestBody Hero hero) {
        return heroService.save(hero);
    }

    // получить всех героев из БД со способностями (сначала заимпортить героев и способности надо)
    @GetMapping("/db")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<Hero> getHeroesFromDb() {
        return heroService.getAllHeroes();
    }

    // массовое сохранение героев из OpenDota
    @PostMapping("/import")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String importHeroes() {
        int count = heroService.saveAllFromOpenDota();
        return "Saved " + count + " heroes";
    }

}