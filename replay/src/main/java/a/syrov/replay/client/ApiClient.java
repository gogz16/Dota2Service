package a.syrov.replay.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("api")
public interface ApiClient {
    @GetMapping("/api/hero/{id}")
    Hero getHero(@PathVariable Long id);
}
