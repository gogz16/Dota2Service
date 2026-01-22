package a.syrov.api.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class TacticDTO {
    private Long id;
    @NotEmpty(message = "Не пустое!")
    @Size(min = 2, max = 15, message = "Размер от {min} до {max}")
    private String name;
    private List<PickDTO> picks;

}
