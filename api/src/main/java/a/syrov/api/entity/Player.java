package a.syrov.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue
    private Long id;

    private String nickname;
    private Role role;
    @ManyToOne
    private Team team;
}
