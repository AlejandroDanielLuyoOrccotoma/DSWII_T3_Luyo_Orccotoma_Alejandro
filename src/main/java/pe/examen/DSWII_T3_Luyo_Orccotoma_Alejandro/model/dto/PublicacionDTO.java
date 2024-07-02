package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PublicacionDTO {
    private String titulo;
    private String resumen;
    private LocalDate fechPublicacion;
    private String nomAutor;
    private String apeAutor;
}
