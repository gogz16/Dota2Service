package a.syrov.api.service;

import a.syrov.api.entity.Hero;
import a.syrov.api.dao.HeroDAO;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    private final HeroDAO heroDAO;

    public HeroService(HeroDAO heroDAO) {
        this.heroDAO = heroDAO;
    }

    public Hero save(Hero hero) {
        return heroDAO.save(hero);
    }

    public Hero getHero(Long id) {
        return heroDAO.findById(id).orElse(null);
    }

}
