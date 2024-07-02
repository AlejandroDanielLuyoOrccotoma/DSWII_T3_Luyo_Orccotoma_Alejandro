package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.bd.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);
    Usuario findByNombres(String nombres);
}
