package a.syrov.api.dto;

import a.syrov.api.entity.Tactic;
import lombok.Data;

import java.util.List;

@Data
public class TacticDTO {
    private Long id;
    private String name;
    private List<PickDTO> picks;

    public static TacticDTO from(Tactic tactic) {
        TacticDTO tacticDTO = new TacticDTO();
        tacticDTO.setId(tactic.getId());
        tacticDTO.setName(tactic.getName());
        tacticDTO.setPicks(tactic.getPicks().stream().map(PickDTO::from).toList());
        return tacticDTO;
    }
}
