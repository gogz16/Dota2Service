package a.syrov.api.dao;

import a.syrov.api.entity.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AbilityDAO extends JpaRepository<Ability, Long> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE dota.ability", nativeQuery = true)
    void truncateTable();
}