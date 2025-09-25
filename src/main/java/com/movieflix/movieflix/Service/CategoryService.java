package com.movieflix.movieflix.Service;

import com.movieflix.movieflix.Entity.Category;
import com.movieflix.movieflix.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category addCategory(Category category){
        return repository.save(category);
    }

    public Optional<Category> searchById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        Optional<Category> exist = repository.findById(id);
        if (exist.isPresent()){
            repository.deleteById(id);
        }
    }
}


