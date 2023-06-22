package pe.upc.toybox_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.toybox_backend.business.CategoryBusiness;
import pe.upc.toybox_backend.dtos.CategoryDTO;
import pe.upc.toybox_backend.entities.Category;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryBusiness categoryBusiness;
    @PostMapping("/register") //register
    public ResponseEntity<CategoryDTO> registerCategory(@RequestBody CategoryDTO categoryDTO){
        Category category;
        try {
            category=convertToEntity(categoryDTO);
            categoryDTO=convertToDto(categoryBusiness.registerCategory(category));
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No fue posible registrarlo");
        }
        return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
    }
    @GetMapping("/list") //list
    public ResponseEntity<List<CategoryDTO>> listCategory(){
        List<Category> list = categoryBusiness.listCategory();
        List<CategoryDTO> listDto = convertToLisDto(list);
        return new ResponseEntity<List<CategoryDTO>>(listDto,HttpStatus.OK);
    }
    @PutMapping("/update") //update
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO cat) {
        CategoryDTO categoryDTO;
        Category category;
        try {
            category= convertToEntity(cat);
            category = categoryBusiness.updateCategory(category);
            categoryDTO = convertToDto(category);
            return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo actualizar ...");
        }
    }
    @DeleteMapping("/delete/{id}") //delete
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable(value = "id") Long id){
        Category category;
        CategoryDTO categoryDTO;
        try {
            category = categoryBusiness.deleteCategory(id);
            categoryDTO = convertToDto(category);
            return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo eliminar ...");
        }
    }
    @GetMapping("/list/{id}") //list id
    public ResponseEntity<CategoryDTO> listIdCategory(@PathVariable(value = "id") Long id){
        Category category;
        CategoryDTO categoryDTO;
        try {
            category = categoryBusiness.listIdCategory(id);
            categoryDTO = convertToDto(category);
            return new ResponseEntity<CategoryDTO>(categoryDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo listar por id ...");
        }
    }
    private CategoryDTO convertToDto(Category category) {
        ModelMapper modelMapper = new ModelMapper();
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }
    private Category convertToEntity(CategoryDTO categoryDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Category post = modelMapper.map(categoryDTO, Category.class);
        return post;
    }
    private List<CategoryDTO> convertToLisDto(List<Category> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
