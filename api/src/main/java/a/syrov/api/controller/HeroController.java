package a.syrov.api.controller;

import a.syrov.api.entity.Hero;
import a.syrov.api.service.HeroService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hero")
public class HeroController {
    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
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
}