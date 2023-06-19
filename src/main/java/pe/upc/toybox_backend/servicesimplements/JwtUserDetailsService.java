package pe.upc.toybox_backend.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.upc.toybox_backend.entities.User;
import pe.upc.toybox_backend.repositories.UserRepository;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

//Clase 2
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Aqui lógica para buscar el usuario en BD
        //Usuario defecto web:password

        if ("web".equals(username)) {
            return new User("web", "$2a$12$CTtjF8P3IJVK6pP4w9pTxuldMqQRrfrLbLLIlasdu2K6ii2vWGly2",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
    }*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findUserByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        //List<GrantedAuthority> roles = new ArrayList<>();

        /*user.getRoles().forEach(rol -> {
            //System.out.println(rol.getRol());
            roles.add(new SimpleGrantedAuthority(rol.getRol()));
        });*/

        UserDetails ud = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),true, true, true, true, new ArrayList<>());
        //al pasar una lista vacía, indicamos que el usuario no tiene ningún rol asignado.
        return ud;
    }
}