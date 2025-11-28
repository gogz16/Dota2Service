package a.syrov.api.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Pick {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Hero hero;
    @ManyToOne
    private Player player;
    @ManyToOne
    private Tactic tactic;

}
