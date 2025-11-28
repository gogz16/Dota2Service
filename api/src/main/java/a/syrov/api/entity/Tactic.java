package a.syrov.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Tactic {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Team team;
    @OneToMany(mappedBy = "tactic")
    private List<Pick> picks;
}
