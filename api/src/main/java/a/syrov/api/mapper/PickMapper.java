package a.syrov.api.mapper;

import a.syrov.api.dto.PickDTO;
import a.syrov.api.entity.Pick;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PickMapper {

    @Mapping(target = "heroId", source = "hero.id")
    @Mapping(target = "playerId", source = "player.id")
    PickDTO pickToPickDTO(Pick pick);

    List<PickDTO> pickToPickDTO(List<Pick> picks);
}
