package a.syrov.api.dao;

import a.syrov.api.entity.Pick;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PickDAO extends JpaRepository<Pick, Long> {
    List<Pick> findAllByTactic_Id(Long id);
}
