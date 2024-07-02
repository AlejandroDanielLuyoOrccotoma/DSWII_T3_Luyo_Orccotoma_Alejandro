package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByNomrol(String nomrol);
}
