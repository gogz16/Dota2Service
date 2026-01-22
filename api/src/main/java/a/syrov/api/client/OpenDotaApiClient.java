package a.syrov.api.client;

import a.syrov.api.entity.Hero;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(value = "openDota", url = "https://api.opendota.com/api/")
public interface OpenDotaApiClient {
    @RequestMapping(method = RequestMethod.GET, value = "/constants/heroes", produces = "application/json")
    Map<Integer, Hero> getHero();
}
