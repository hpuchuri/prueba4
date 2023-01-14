package pe.gob.vuce.sgringesta.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class IngestaResponseDTO {
    private String colaIngestaID;
    //private Integer cuerpo;
    List<IngestaResponseDTO> cuerpo;
}
