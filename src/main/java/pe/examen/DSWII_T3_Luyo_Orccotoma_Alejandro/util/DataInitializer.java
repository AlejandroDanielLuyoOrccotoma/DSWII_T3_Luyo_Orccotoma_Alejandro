package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.util;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.bd.Rol;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.bd.Usuario;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.repositories.RolRepository;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.repositories.UsuarioRepository;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataInitializer {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    @Transactional
    public void init() {

        Rol rolCoordinador = new Rol();
        rolCoordinador.setNomrol("COORDINADOR");
        rolRepository.save(rolCoordinador);

        Rol rolGestor = new Rol();
        rolGestor.setNomrol("GESTOR");
        rolRepository.save(rolGestor);

        Usuario usuario1 = new Usuario();
        usuario1.setNomusuario("coordinador");
        usuario1.setEmail("coordinador@ejemplo.com");
        usuario1.setPassword(passwordEncoder.encode("12345"));
        usuario1.setNombres("Coordinador");
        usuario1.setApellidos(":D");
        usuario1.setActivo(true);

        Usuario usuario2 = new Usuario();
        usuario2.setNomusuario("gestor");
        usuario2.setEmail("gestor@ejemplo.com");
        usuario2.setPassword(passwordEncoder.encode("12345"));
        usuario2.setNombres("Gestor");
        usuario2.setApellidos(">:c");
        usuario2.setActivo(true);

        Set<Rol> rolesCoordinador = new HashSet<>();
        rolesCoordinador.add(rolCoordinador);
        usuario1.setRoles(rolesCoordinador);

        Set<Rol> rolesGestor = new HashSet<>();
        rolesGestor.add(rolGestor);
        usuario2.setRoles(rolesGestor);

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
    }
}
