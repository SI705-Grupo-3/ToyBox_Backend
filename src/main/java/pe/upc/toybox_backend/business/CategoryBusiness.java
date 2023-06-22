package pe.upc.toybox_backend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.toybox_backend.entities.Category;
import pe.upc.toybox_backend.repositories.CategoryRepository;

import java.util.List;


@Service
public class CategoryBusiness {
    @Autowired
    private CategoryRepository categoryRepository;
    @Transactional //register
    public Category registerCategory(Category category) {
        return categoryRepository.save(category);
    }
    //list
    public List<Category> listCategory() {
        return categoryRepository.findAll();
    }
    @Transactional //update
    public Category updateCategory(Category category) throws Exception{
        categoryRepository.findById(category.getId()).orElseThrow(() -> new Exception("No se encontró la entidad"));
        return categoryRepository.save(category);
    }
    @Transactional //delete
    public Category deleteCategory(Long id) throws Exception{
        Category category = categoryRepository.findById(id).orElseThrow(() -> new Exception("No se encontró la entidad"));
        categoryRepository.delete(category);
        return category;
    }
    //list Category By ID
    public Category listIdCategory(Long id) throws Exception{
        Category category = categoryRepository.findById(id).orElseThrow(() -> new Exception("No se encontró la entidad"));
        return category;
    }

}
