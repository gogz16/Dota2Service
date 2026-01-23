package a.syrov.api.service;

import a.syrov.api.client.OpenDotaApiClient;
import a.syrov.api.dao.AbilityDAO;
import a.syrov.api.dao.HeroDAO;
import a.syrov.api.entity.Hero;
import a.syrov.api.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HeroService {
    private final HeroDAO heroDAO;
    private final AbilityDAO abilityDAO;
    private final OpenDotaApiClient openDotaApiClient;


    public HeroService(HeroDAO heroDAO, AbilityDAO abilityDAO, OpenDotaApiClient openDotaApiClient) {
        this.heroDAO = heroDAO;
        this.abilityDAO = abilityDAO;
        this.openDotaApiClient = openDotaApiClient;
    }

    public Hero save(Hero hero) {
        return heroDAO.save(hero);
    }

    public Hero getHero(Long id) {
        return heroDAO.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<Hero> getAllHeroes() {
        return heroDAO.findAll();
    }

    public Hero findByName(String name) {
        return heroDAO.findByName(name);
    }

    @Transactional
    public int saveAllFromOpenDota() {
        Map<Integer, Hero> openDotaHeroes = openDotaApiClient.getHero();
        List<Hero> heroesToSave = new ArrayList<>(openDotaHeroes.values());
        heroDAO.saveAll(heroesToSave);
        return heroesToSave.size();
    }

}
