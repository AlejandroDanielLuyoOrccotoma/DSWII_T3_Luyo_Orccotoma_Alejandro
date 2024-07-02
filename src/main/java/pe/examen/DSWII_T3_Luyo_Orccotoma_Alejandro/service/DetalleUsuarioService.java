package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.bd.Rol;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.model.bd.Usuario;
import pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.repositories.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = obtenerUsuarioPorUsername(username);
        return autenticacionUsuario(usuario,obtenerListaRoles(usuario.getRoles()));
    }

    public Usuario obtenerUsuarioPorUsername(String nomusuario){
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    private UserDetails autenticacionUsuario(Usuario usuario, List<GrantedAuthority> authorityList){
        return new User(
                usuario.getNomusuario(),
                usuario.getPassword(),
                usuario.getActivo(),
                true,true,true,
                authorityList
        );
    }

    public  List<GrantedAuthority> obtenerListaRoles(Set<Rol> roles){
        List<GrantedAuthority> authorityList= new ArrayList<>();
        for (Rol rol:roles){
            authorityList.add(new SimpleGrantedAuthority("ROLE_"+rol.getNomrol()));
        }
        return  authorityList;
    }
}
