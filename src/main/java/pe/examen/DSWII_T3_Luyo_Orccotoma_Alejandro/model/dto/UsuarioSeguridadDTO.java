package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsuarioSeguridadDTO {
    private Integer idusuario;
    private String nomusuario;
    private String token;
}

