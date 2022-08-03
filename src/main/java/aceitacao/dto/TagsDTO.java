package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor

public class TagsDTO {
    private String id;
    private String name;
}
