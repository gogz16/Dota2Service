package a.syrov.api.controller;

import a.syrov.api.client.OpenDotaApiClient;
import a.syrov.api.dto.OpenDotaAbilityDTO;
import a.syrov.api.service.AbilityService;
import a.syrov.api.service.HeroService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/ability")
public class AbilityController {
    private final AbilityService abilityService;
    private final HeroService heroService;
    private final OpenDotaApiClient openDotaApiClient;

    public AbilityController(AbilityService abilityService, HeroService heroService, OpenDotaApiClient openDotaApiClient) {
        this.abilityService = abilityService;
        this.heroService = heroService;
        this.openDotaApiClient = openDotaApiClient;
    }

    //просмотр способностей из OpenDota
    @GetMapping()
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Map<String, OpenDotaAbilityDTO> getOpenDotaAbilities() {
        return openDotaApiClient.getHeroAbilities();
    }

    //массовое сохранение способностей из OpenDota
    @PostMapping("/import")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String importAbilities() {
        int count = abilityService.saveAllFromOpenDota();
        return "Saved " + count + " abilities";
    }
}
