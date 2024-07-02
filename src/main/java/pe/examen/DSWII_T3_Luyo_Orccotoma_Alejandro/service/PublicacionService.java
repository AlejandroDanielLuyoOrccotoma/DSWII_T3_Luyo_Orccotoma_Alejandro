package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.bd.Publicacion;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.dto.PublicacionDTO;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.repositories.PublicacionRepository;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicacionService implements IPublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PublicacionDTO> obtenerPublicacionesDTO() {
        List<Publicacion> publicaciones = publicacionRepository.findAll();
        return publicaciones.stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    private PublicacionDTO convertirADTO(Publicacion publicacion) {
        return modelMapper.map(publicacion, PublicacionDTO.class);
    }
}
