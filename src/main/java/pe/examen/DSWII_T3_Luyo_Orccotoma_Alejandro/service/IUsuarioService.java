package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.service;

import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.bd.Usuario;

public interface IUsuarioService {
    Usuario obtenerUsuarioPorNomUsuario(String nomusuario);
}
