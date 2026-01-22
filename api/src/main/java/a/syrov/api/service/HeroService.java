package a.syrov.api.service;

import a.syrov.api.client.OpenDotaApiClient;
import a.syrov.api.dao.HeroDAO;
import a.syrov.api.entity.Hero;
import a.syrov.api.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    private final HeroDAO heroDAO;
    private final OpenDotaApiClient openDotaApiClient;


    public HeroService(HeroDAO heroDAO, OpenDotaApiClient openDotaApiClient) {
        this.heroDAO = heroDAO;
        this.openDotaApiClient = openDotaApiClient;
    }

    public Hero save(Hero hero) {
        return heroDAO.save(hero);
    }

    public Hero getHero(Long id) {
        return heroDAO.findById(id).orElseThrow(NotFoundException::new);
    }

}
