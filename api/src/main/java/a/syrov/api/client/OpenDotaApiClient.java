package a.syrov.api.client;

import a.syrov.api.dto.OpenDotaAbilityDTO;
import a.syrov.api.entity.Hero;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "openDota", url = "https://api.opendota.com/api/")
public interface OpenDotaApiClient {
    @RequestMapping(method = RequestMethod.GET, value = "/constants/heroes", produces = "application/json")
    Map<Integer, Hero> getHero(); //тут можно было использовать OpenDotaHeroDTO вместо Hero и не создавать DTO-ху?

    @RequestMapping(method = RequestMethod.GET, value = "/constants/hero_abilities", produces = "application/json")
    Map<String, OpenDotaAbilityDTO> getHeroAbilities();
}
