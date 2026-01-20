package a.syrov.api.dto;

import a.syrov.api.entity.Pick;
import lombok.Data;

@Data
public class PickDTO {
    private Long id;
    private Long heroId;
    private Long playerId;

//    public static PickDTO from(Pick pick) {
//        PickDTO pickDTO = new PickDTO();
//        pickDTO.setId(pick.getId());
//        pickDTO.setHeroId(pick.getHero().getId());
//        pickDTO.setPlayerId(pick.getPlayer().getId());
//        return pickDTO;
//    }
}
