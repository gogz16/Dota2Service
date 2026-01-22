package a.syrov.api.exceptions;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.LinkedMultiValueMap;

import java.util.List;

@Getter
@Builder
public class ErrorResponse {
    LinkedMultiValueMap<String, String> errors;
    List<String> globalErrors;
}
