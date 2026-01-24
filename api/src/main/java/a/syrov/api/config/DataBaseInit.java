package a.syrov.api.config;

import a.syrov.api.service.AbilityService;
import a.syrov.api.service.HeroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static java.lang.Boolean.TRUE;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataBaseInit implements ApplicationRunner {

    @Value("${db_init}")
    private Boolean init;
    private final HeroService heroService;
    private final AbilityService abilityService;

    @Override
    public void run(ApplicationArguments args) {
        if (TRUE.equals(init)) {

            try {
                int count = heroService.saveAllFromOpenDota();
                log.info("Successfully imported {} heroes.", count);
            } catch (Exception e) {
                log.error("Cannot fill database with heroes. Error={}", e.getMessage(), e);
            }

            try {
                int count = abilityService.saveAllFromOpenDota();
                log.info("Successfully imported {} abilities.", count);
            } catch (Exception e) {
                log.error("Cannot fill database with abilities. Error={}", e.getMessage(), e);
            }
        }
    }
}
