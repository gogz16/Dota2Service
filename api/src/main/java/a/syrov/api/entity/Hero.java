package a.syrov.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Hero {
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //без этого не проходит запрос на выборку героев из БД
    private List<Ability> abilities;

}
