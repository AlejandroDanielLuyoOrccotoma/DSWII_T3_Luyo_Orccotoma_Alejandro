package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.bd.Usuario;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.repositories.UsuarioRepository;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario obtenerUsuarioPorNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }
}
