package a.syrov.api.service;

import a.syrov.api.client.OpenDotaApiClient;
import a.syrov.api.dao.AbilityDAO;
import a.syrov.api.dto.OpenDotaAbilityDTO;
import a.syrov.api.entity.Ability;
import a.syrov.api.entity.Hero;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class AbilityService {
    private final AbilityDAO abilityDAO;
    private final HeroService heroService;
    private final OpenDotaApiClient openDotaApiClient;

    public AbilityService(AbilityDAO abilityDAO, HeroService heroService, OpenDotaApiClient openDotaApiClient) {
        this.abilityDAO = abilityDAO;
        this.heroService = heroService;
        this.openDotaApiClient = openDotaApiClient;
    }

    @Transactional
    public int saveAllFromOpenDota() {

        abilityDAO.truncateTable();

        Map<String, OpenDotaAbilityDTO> heroAbilities = openDotaApiClient.getHeroAbilities();//получаем данные из OpenDota
        int saved = 0;

        for (Map.Entry<String, OpenDotaAbilityDTO> entry : heroAbilities.entrySet()) {
            String heroName = entry.getKey(); //npc_dota_hero_antimage
            OpenDotaAbilityDTO dto = entry.getValue();//antimage_mana_break

            Hero hero = heroService.findByName(heroName);
            if (hero == null) {
                continue; //герой не найден в БД - скипаем
            }

            if (dto.getAbilities() == null) {
                continue; //способность не найдена в БД - скипаем
            }

            for (String abilityName : dto.getAbilities()) {
                if (abilityName == null || abilityName.isBlank() || abilityName.equals("generic_hidden")) {
                    continue; //если название пустое, null или равно generic_hidden - скипаем
                }

                Ability ability = new Ability();
                ability.setName(abilityName);
                ability.setHero(hero);
                abilityDAO.save(ability);
                saved++;
            }
        }
        return saved;
    }
}
