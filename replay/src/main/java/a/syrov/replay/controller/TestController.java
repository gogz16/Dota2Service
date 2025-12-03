package a.syrov.replay.controller;

import a.syrov.replay.client.ApiClient;
import a.syrov.replay.client.Hero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/replay")
public class TestController {

    public final ApiClient apiClient;

    public TestController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }


    @GetMapping()
    public String getReplay() {
      //  Hero hero = apiClient.getHero(1L);
        return "Hello retard!))";
    }
}
