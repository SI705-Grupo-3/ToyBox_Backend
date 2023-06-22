package pe.upc.toybox_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.toybox_backend.business.ProductRegistrationBusiness;
import pe.upc.toybox_backend.dtos.ProductRegistrationDTO;
import pe.upc.toybox_backend.entities.ProductRegistration;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/product-registration")
public class ProductRegistrationController {
    @Autowired
    private ProductRegistrationBusiness productRegistrationBusiness;
    @PostMapping("/register") //register
    public ResponseEntity<ProductRegistrationDTO> registerProductRegistration(@RequestBody ProductRegistrationDTO productRegistrationDTO){
        ProductRegistration productRegistration;
        try {
            productRegistration=convertToEntity(productRegistrationDTO);
            productRegistrationDTO=convertToDto(productRegistrationBusiness.registerProductRegistration(productRegistration));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible registrarlo");
        }
        return new ResponseEntity<ProductRegistrationDTO>(productRegistrationDTO, HttpStatus.OK);
    }
    @GetMapping("/list") //list
    public ResponseEntity<List<ProductRegistrationDTO>> listProductRegistration(){
        List<ProductRegistration> list = productRegistrationBusiness.listProductRegistration();
        List<ProductRegistrationDTO> listDto = convertToLisDto(list);
        return new ResponseEntity<List<ProductRegistrationDTO>>(listDto,HttpStatus.OK);
    }
    @GetMapping("/list/{id}") //list id
    public ResponseEntity<ProductRegistrationDTO> listIdProductRegistration(@PathVariable(value = "id") Long id){
        ProductRegistration productRegistration;
        ProductRegistrationDTO productRegistrationDTO;
        try {
            productRegistration = productRegistrationBusiness.listIdProductRegistration(id);
            productRegistrationDTO = convertToDto(productRegistration);
            return new ResponseEntity<ProductRegistrationDTO>(productRegistrationDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo listar por id ...");
        }
    }
    private ProductRegistrationDTO convertToDto(ProductRegistration productRegistration) {
        ModelMapper modelMapper = new ModelMapper();
        ProductRegistrationDTO productRegistrationDTO = modelMapper.map(productRegistration, ProductRegistrationDTO.class);
        return productRegistrationDTO;
    }
    private ProductRegistration convertToEntity(ProductRegistrationDTO productRegistrationDTO) {
        ModelMapper modelMapper = new ModelMapper();
        ProductRegistration post = modelMapper.map(productRegistrationDTO, ProductRegistration.class);
        return post;
    }
    private List<ProductRegistrationDTO> convertToLisDto(List<ProductRegistration> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
