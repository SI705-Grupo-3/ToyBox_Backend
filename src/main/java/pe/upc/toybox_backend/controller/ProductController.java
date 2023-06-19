package pe.upc.toybox_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.toybox_backend.business.ProductBusiness;
import pe.upc.toybox_backend.dtos.ProductDTO;
import pe.upc.toybox_backend.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductBusiness productBusiness;
    @PostMapping("/product") //register
    public ResponseEntity<ProductDTO> registerProduct(@RequestBody ProductDTO productDTO){
        Product product;
        try {
            product=convertToEntity(productDTO);
            productDTO=convertToDto(productBusiness.registerProduct(product));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible registrarlo");
        }
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }
    @GetMapping("/products") //list
    public ResponseEntity<List<ProductDTO>> listProduct(){
        List<Product> list = productBusiness.listProduct();
        List<ProductDTO> listDto = convertToLisDto(list);
        return new ResponseEntity<List<ProductDTO>>(listDto,HttpStatus.OK);
    }

    private ProductDTO convertToDto(Product product) {
        ModelMapper modelMapper = new ModelMapper();
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }
    private Product convertToEntity(ProductDTO productDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Product post = modelMapper.map(productDTO, Product.class);
        return post;
    }
    private List<ProductDTO> convertToLisDto(List<Product> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
