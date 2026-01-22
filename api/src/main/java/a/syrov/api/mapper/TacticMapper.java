package a.syrov.api.mapper;

import a.syrov.api.dto.TacticDTO;
import a.syrov.api.entity.Tactic;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PickMapper.class)
public interface TacticMapper {
    TacticDTO fromTactic (Tactic tactic);

    List<TacticDTO> fromTactics(List<Tactic> tactics);

    Tactic toTactic(TacticDTO tacticDTO);
}
