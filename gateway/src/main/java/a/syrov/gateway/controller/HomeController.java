package a.syrov.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
public class HomeController {
    @GetMapping
    public Mono<String> home(Principal principal) {
        return Mono.just(principal.toString());
    }
}
