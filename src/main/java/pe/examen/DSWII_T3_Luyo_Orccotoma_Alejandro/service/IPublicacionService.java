package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.service;

import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.dto.PublicacionDTO;

import java.util.List;

public interface IPublicacionService {
    List<PublicacionDTO> obtenerPublicacionesDTO();
}
