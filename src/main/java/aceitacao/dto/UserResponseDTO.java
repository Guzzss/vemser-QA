package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class UserResponseDTO {
    private String code;
    private  String type;
    private String message;
}
