package pe.upc.toybox_backend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.toybox_backend.entities.User;
import pe.upc.toybox_backend.repositories.UserRepository;

import java.util.List;

@Service
public class UserBusiness {
    @Autowired
    private UserRepository userRepository;
    @Transactional //register
    public User registerUser(User user) {
        return userRepository.save(user);
    }
    //list
    public List<User> listUser() {
        return userRepository.findAll();
    }
    @Transactional //update
    public User updateUser(User user) throws Exception{
        userRepository.findById(user.getId()).orElseThrow(() -> new Exception("No se encontró la entidad"));
        return userRepository.save(user);
    }
    @Transactional //delete
    public User deleteUser(Long id) throws Exception{
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("No se encontró la entidad"));
        userRepository.delete(user);
        return user;
    }
    public User listIdUser(Long id) throws Exception{
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("No se encontró la entidad"));
        return user;
    }
    public User getUser(String username) throws Exception{
        return userRepository.findUserByUsername(username);
    }


    //
}
