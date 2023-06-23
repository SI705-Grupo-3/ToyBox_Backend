package pe.upc.toybox_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.toybox_backend.business.UserBusiness;
import pe.upc.toybox_backend.dtos.UserDTO;
import pe.upc.toybox_backend.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserBusiness userBusiness;
    @PostMapping("/register") //register
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
        User user;
        try {
            user=convertToEntity(userDTO);
            userDTO=convertToDto(userBusiness.registerUser(user));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible registrarlo");
        }
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }
    @GetMapping("/list") //list
    public ResponseEntity<List<UserDTO>> listUser(){
        List<User> list = userBusiness.listUser();
        List<UserDTO> listDto = convertToLisDto(list);
        return new ResponseEntity<List<UserDTO>>(listDto,HttpStatus.OK);
    }
    @PutMapping("/update") //update
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO usr) {
        UserDTO userDTO;
        User user;
        try {
            user = convertToEntity(usr);
            user = userBusiness.updateUser(user);
            userDTO = convertToDto(user);
            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo actualizar ...");
        }
    }
    @DeleteMapping("/delete/{id}") //delete
    public ResponseEntity<UserDTO> deleteUser(@PathVariable(value = "id") Long id){
        User user;
        UserDTO userDTO;
        try {
            user = userBusiness.deleteUser(id);
            userDTO = convertToDto(user);
            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo eliminar ...");
        }
    }
    @GetMapping("/list/{id}") //list id
    public ResponseEntity<UserDTO> listIdUser(@PathVariable(value = "id") Long id){
        User user;
        UserDTO userDTO;
        try {
            user = userBusiness.listIdUser(id);
            userDTO = convertToDto(user);
            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo listar por id ...");
        }
    }
    private UserDTO convertToDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }
        private User convertToEntity(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User post = modelMapper.map(userDTO, User.class);
        return post;
    }
    private List<UserDTO> convertToLisDto(List<User> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/get") //list
    public ResponseEntity<UserDTO> getUser(@RequestParam("username") String username){
        UserDTO userDTO;
        User user;
        try {
            user= userBusiness.getUser(username);
            userDTO=convertToDto(user);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible encontrar usuario");
        }
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }

}
