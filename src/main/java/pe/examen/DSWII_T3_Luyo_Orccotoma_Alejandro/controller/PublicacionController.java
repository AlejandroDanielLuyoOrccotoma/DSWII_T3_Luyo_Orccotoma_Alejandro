package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.dto.PublicacionDTO;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.service.IPublicacionService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pubs-dto")
public class PublicacionController {

    private IPublicacionService publicacionService;

    @GetMapping
    public ResponseEntity<List<PublicacionDTO>> obtenerPublicacionesDTO() {
        List<PublicacionDTO> publicacionesDTO = publicacionService.obtenerPublicacionesDTO();
        return ResponseEntity.ok(publicacionesDTO);
    }
}